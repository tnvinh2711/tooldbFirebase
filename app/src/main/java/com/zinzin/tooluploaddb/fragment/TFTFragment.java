package com.zinzin.tooluploaddb.fragment;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.zinzin.tooluploaddb.R;
import com.zinzin.tooluploaddb.model.teamFightTatics.Detail;
import com.zinzin.tooluploaddb.model.teamFightTatics.Item;
import com.zinzin.tooluploaddb.model.teamFightTatics.ItemBuilder;
import com.zinzin.tooluploaddb.model.teamFightTatics.Origin;
import com.zinzin.tooluploaddb.model.teamFightTatics.Round;
import com.zinzin.tooluploaddb.model.teamFightTatics.Team;
import com.zinzin.tooluploaddb.model.teamFightTatics.Type;
import com.zinzin.tooluploaddb.model.teamFightTatics.Unit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TFTFragment extends Fragment {
    private String URL = "https://rankedboost.com/league-of-legends";
    private List<Unit> unitList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();
    private List<Round> roundList = new ArrayList<>();
    private List<String> detailUrlList = new ArrayList<>();
    private List<Detail> detailList = new ArrayList<>();
    private List<Origin> originList = new ArrayList<>();
    private List<Origin> classList = new ArrayList<>();
    private List<Team> teamList = new ArrayList<>();
    int idItem = 0;
    DatabaseReference rootRef;

    public static TFTFragment newInstance() {
        return new TFTFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upload, container, false);
        rootRef = FirebaseDatabase.getInstance().getReference().child("tft_db_test");
        Button btnUpload = view.findViewById(R.id.btn_upload);
        btnUpload.setText("upload TFT");
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseHtml();
            }
        });
        return view;
    }

    @SuppressLint("StaticFieldLeak")
    private void parseHtml() {
        new AsyncTask<Void, Void, String>() {

            public String doInBackground(Void... params) {
                getListUnit();
                getDetail(detailUrlList);
                getListItem();
                getListRound();
                getListOrigin();
                getListClass();
                getListSuggest();
                return "";
            }

            @Override
            protected void onPostExecute(String result) {
                rootRef.child("unitList").removeValue();
                for (Unit unit : unitList) {
                    rootRef.child("unit").child("unitList").child(unit.getName()).setValue(unit);
                }
                for (Detail detail : detailList) {
                    rootRef.child("detailList").child(detail.getName()).setValue(detail);
                }
                rootRef.child("itemList2").removeValue();
                for (Item item : itemList) {
                    rootRef.child("itemList2").child(String.valueOf(item.getId())).setValue(item);
                }
                rootRef.child("roundList").removeValue();
                for (Round round : roundList) {
                    rootRef.child("roundList").child(round.getName()).setValue(round);
                }
                rootRef.child("classList").removeValue();
                for (Origin class_ : classList) {
                    rootRef.child("unit").child("classList").child(class_.getName()).setValue(class_);
                }
                rootRef.child("originList").removeValue();
                for (Origin origin : originList) {
                    rootRef.child("unit").child("originList").child(origin.getName()).setValue(origin);
                }
                rootRef.child("teamList2").removeValue();
                for (Team team : teamList) {
                    rootRef.child("teamList2").child(team.getName()).setValue(team);
                }
                Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    private void getListSuggest() {
        try {
            Document docSuggest = Jsoup.connect(URL + "/teamfight-tactics/best-team-builds/").get();
            Elements suggestElements = docSuggest.getElementsByClass("counters-sidebar-strong-against-sim");
            for (int i = 0; i < suggestElements.size(); i++) {
                Team team = new Team();
                Element nameSuggestElements = docSuggest.getElementById(String.valueOf(i + 1));
//                List<String> name = new ArrayList<>();
//                for(Element nameE: nameSuggestElements.select("img")){
//                    name.add(nameE.text());
//                }
                team.setName(nameSuggestElements.text());
                Elements teamElements = suggestElements.get(i).getElementsByClass("counters-sidebar-champion-sim buildcs");

                List<Team.Hero> heroList = new ArrayList<>();
                for (Element heroElement : teamElements) {
                    Team.Hero hero = new Team.Hero();
                    hero.setName_hero(heroElement.getElementsByClass("counters-sidebar-champ-name buildcs").text());
                    hero.setUrl_hero(heroElement.getElementsByClass("image-wrap-list-underlords buildcs").select("img").attr("src"));
                    hero.setCost(heroElement.getElementsByClass("span-item-tier buildcs").text());
                    List<String> typeList = new ArrayList<>();
                    for (Element typeElement : heroElement.getElementsByClass("counters-sidebar-champ-role-sim buildcs")) {
                        typeList.add(typeElement.text());
                    }
                    hero.setType(linkStringFromArray(typeList));
                    hero.setUrl_item_1(heroElement.getElementsByClass("li-rbm buildcs").get(0).select("img").attr("src"));
                    hero.setUrl_item_2(heroElement.getElementsByClass("li-rbm buildcs").get(1).select("img").attr("src"));
                    hero.setUrl_item_3(heroElement.getElementsByClass("li-rbm buildcs").get(2).select("img").attr("src"));
                    hero.setUrl__item_combine_1_1(heroElement.getElementsByClass("li-rbm buildcs").get(0).getElementsByClass("span-underlords-list-img recipe-img-tft buildcs").get(0).attr("src"));
                    hero.setUrl__item_combine_1_2(heroElement.getElementsByClass("li-rbm buildcs").get(0).getElementsByClass("span-underlords-list-img recipe-img-tft buildcs").get(1).attr("src"));
                    hero.setUrl__item_combine_2_1(heroElement.getElementsByClass("li-rbm buildcs").get(1).getElementsByClass("span-underlords-list-img recipe-img-tft buildcs").get(0).attr("src"));
                    hero.setUrl__item_combine_2_2(heroElement.getElementsByClass("li-rbm buildcs").get(1).getElementsByClass("span-underlords-list-img recipe-img-tft buildcs").get(1).attr("src"));
                    hero.setUrl__item_combine_3_1(heroElement.getElementsByClass("li-rbm buildcs").get(2).getElementsByClass("span-underlords-list-img recipe-img-tft buildcs").get(0).attr("src"));
                    hero.setUrl__item_combine_3_2(heroElement.getElementsByClass("li-rbm buildcs").get(2).getElementsByClass("span-underlords-list-img recipe-img-tft buildcs").get(1).attr("src"));
                    heroList.add(hero);
                }
                team.setHeroList(heroList);
                teamList.add(team);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getListOrigin() {
        try {
            Document docOrigin = Jsoup.connect(URL + "/teamfight-tactics/best-origin/").get();
            Elements originsElements = docOrigin.getElementsByClass("counters-sidebar-sim");
            for (int i = 0; i < originsElements.size(); i++) {
                Origin origin = new Origin();
                origin.setUrl(originsElements.get(i).select("img").attr("src"));
                origin.setName(originsElements.get(i).getElementsByClass("perk-text").text());
                Elements desEles = originsElements.get(i).getElementsByClass("ssbulitl");
                List<String> desList = new ArrayList<>();
                for (Element desEle : desEles) {
                    desList.add(desEle.text());
                }
                origin.setDes(desList);
                originList.add(origin);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getListClass() {
        try {
            Document docOrigin = Jsoup.connect(URL + "/teamfight-tactics/best-class/").get();
            Elements originsElements = docOrigin.getElementsByClass("counters-sidebar-sim");
            for (int i = 0; i < originsElements.size(); i++) {
                Origin origin = new Origin();
                origin.setUrl(originsElements.get(i).select("img").attr("src"));
                origin.setName(originsElements.get(i).getElementsByClass("perk-text").text());
                Elements desEles = originsElements.get(i).getElementsByClass("ssbulitl");
                List<String> desList = new ArrayList<>();
                for (Element desEle : desEles) {
                    desList.add(desEle.text());
                }
                origin.setDes(desList);
                classList.add(origin);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getListRound() {
        try {
            Document docRound = Jsoup.connect(URL + "/teamfight-tactics/rounds/").get();
            Elements roundElements = docRound.getElementsByClass("ssbulitl");
            for (int i = 0; i < roundElements.size(); i++) {
                Element roundEle = roundElements.get(i);
                Round round = new Round();
                String[] des = roundEle.text().split("\\|");
                round.setName(roundEle.getElementsByClass("tiercsssection").text());
                round.setDes(des[1].trim());
                round.setUrl(roundEle.select("img").attr("src"));
                roundList.add(round);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getListItem() {
        try {
            Document docItem = Jsoup.connect(URL + "/items-list/").get();
            Elements itemElements = docItem.getElementsByClass("rb-build-overview-wrap-tabl");
            for (int i = 0; i < itemElements.size(); i++) {
                Elements itemListElenments = itemElements.get(i).getElementsByClass("rb-build-overview-tr");
                for (Element elementCombineItem : itemListElenments) {
                    Item item = new Item();
                    item.setName(elementCombineItem.getElementsByClass("item-td-underlords-title").text().replace(".", ""));
                    item.setDes(elementCombineItem.getElementsByClass("item-td-underlords-desc").text());
                    item.setUrl(elementCombineItem.select("img").attr("src"));
                    if (i > 0) {
                        Elements itemCombine = elementCombineItem.getElementsByClass("item-a-tft-two");
                        List<String> listCombine = new ArrayList<>();
                        for (Element combineUrl : itemCombine) {
                            listCombine.add(combineUrl.select("img").attr("src"));
                        }
                        item.setListCombine(listCombine);
                        Log.e("combime", listCombine.get(0) + listCombine.size());
                    }


                    List<ItemBuilder> itemBuildersGroup = new ArrayList<>();
                    Elements itemBuildersElenments = elementCombineItem.getElementsByClass("li-rbm upg-des");
                    for (Element itemB : itemBuildersElenments) {
                        ItemBuilder itemBuilder = new ItemBuilder();
                        List<String> itemBuilders = new ArrayList<>();
                        for (Element itemImg : itemB.select("img")) {
                            itemBuilders.add(itemImg.attr("src"));
                        }
                        itemBuilder.setListItem(itemBuilders);
                        itemBuildersGroup.add(itemBuilder);
                    }
                    item.setListItemBuilder(itemBuildersGroup);
                    item.setId(idItem);
                    itemList.add(item);
                    idItem++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getDetail(List<String> detailUrlList) {
        try {
            for (String url : detailUrlList) {
                if(url.contains("garen") || url.contains("kayle")){
                    continue;
                }
                Document docDetail = Jsoup.connect(url).get();
                Detail detail = new Detail();
                detail.setName(docDetail.getElementsByClass("rb-build-champion-icon").first().select("img").attr("title"));
                detail.setUrl(docDetail.getElementsByClass("rb-build-champion-icon").first().select("img").attr("src"));
                detail.setNick_name(docDetail.getElementsByClass("rb-build-subtitle-text").text());
                Elements roleElement = docDetail.getElementsByClass("perk-class-quad-wrap");
                List<Type> typeList = new ArrayList<>();
                for (int j = 0; j < roleElement.size(); j++) {
                    Type type = new Type();
                    type.setName(roleElement.get(j).getElementsByClass("perk-text").text());
                    type.setType(setType(type.getName()));
                    type.setUrl(roleElement.get(j).select("img").attr("src"));
                    Elements desElement = roleElement.get(j).getElementsByClass("ssbulitl");
                    List<String> desList = new ArrayList<>();
                    for (Element des : desElement) {
                        desList.add(des.text());
                    }
                    type.setDes(desList);
                    typeList.add(type);
                }
                detail.setType(typeList);
                detail.setDes(docDetail.getElementsByClass("rb-build-sec-desc singles-top").text());
                Elements stat = docDetail.getElementsByClass("rb-build-overview-wrap-tabl").get(1).getElementsByClass("rb-build-overview-td");
                List<String> statList = new ArrayList<>();
                for (int i = 0; i < stat.size() - 1; i = i + 2) {
                    statList.add(stat.get(i).text() + ": " + stat.get(i + 1).text());
                }
                String statString = "";
                for (String stats : statList) {
                    statString = statString + stats + "\n";
                }
                detail.setStat(statString.substring(0, statString.length() - 1));
                Element skill = docDetail.getElementsByClass("rb-build-overview-wrap-tabl-ability").first();
                detail.setSkill_des(skill.getElementsByClass("rb-build-overview-td-ability").text());
                detail.setSkill_name(skill.select("img").attr("title"));
                detail.setSkill_url(skill.select("img").attr("src"));
                Elements skillDameEles = skill.getElementsByClass("ability-lb");
                String dame = "";
                for (Element skillDameEle : skillDameEles) {
                    dame = dame + skillDameEle.text() + "\n";
                }
                detail.setSkill_damage(dame.substring(0, dame.length() - 1));
                Elements itemEle = docDetail.getElementsByClass("ul-rbm").first().getElementsByClass("li-rbm");
                List<String> urlItem = new ArrayList<>();
                for (Element item : itemEle) {
                    urlItem.add(item.select("img").attr("src"));
                }
                detail.setItems(urlItem);
                detailList.add(detail);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String setType(String name) {
        String type = "";
        if (name.equals("Wild") || name.equals("Noble") ||
                name.equals("Glacial") || name.equals("Dragon") ||
                name.equals("Exile") || name.equals("Demon") || name.equals("Ninja") || name.equals("Void")
                || name.equals("Yordle") || name.equals("Pirate") || name.equals("Phantom") || name.equals("Robot")) {
            type = "Origins";
        } else {
            type = "Class";
        }
        return type;
    }

    private void getListUnit() {
        try {
            Document docUnit = Jsoup.connect(URL + "/teamfight-tactics/").get();
            // lay list unit
            Elements tierElements = docUnit.getElementsByClass("ChampionTierBG1");
            for (int i = 9; i < 14; i++) {
                //lay url detail
                for ( Element detail: tierElements.get(i).select("a")){
                    String detailUrl = detail.attr("href");
                    detailUrlList.add(detailUrl);
                }
            Elements unitListElements = tierElements.get(i).getElementsByClass("TierListChampionContainer");
            //lay tier
            String tier = "";
            switch (i) {
                case 9:
                    tier = "5";
                    break;
                case 10:
                    tier = "4";
                    break;
                case 11:
                    tier = "3";
                    break;
                case 12:
                    tier = "2";
                    break;
                case 13:
                    tier = "1";
                    break;
            }
            for (Element unitElements : unitListElements) {
                Unit unit = new Unit();
                unit.setTier(tier);
                unit.setUrl(unitElements.select("img").attr("src"));
                switch (i) {
                    case 9:
                        unit.setCost("5$");
                        break;
                    case 10:
                        unit.setCost("4$");
                        break;
                    case 11:
                        unit.setCost("3$");
                        break;
                    case 12:
                        unit.setCost("2$");
                        break;
                    case 13:
                        unit.setCost("1$");
                        break;
                }
                Elements typeListElement = unitElements.getElementsByClass("TierListNames");
                unit.setName(typeListElement.first().text());
                List<Type> typeList = new ArrayList<>();
                for (int j = 1; j < typeListElement.size(); j++) {
                    Type type = new Type();
                    type.setName(typeListElement.get(j).getElementsByClass("type-tierlist-s").text());
                    type.setType(setType(type.getName()));
                    type.setUrl(typeListElement.get(j).select("img").attr("src"));
                    typeList.add(type);
                }
                unit.setType(typeList);
                unitList.add(unit);
            }
        }
    } catch(
    IOException e)

    {
        e.printStackTrace();
    }

}

    public String linkStringFromArray(List<String> array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.size(); i++) {
            stringBuilder.append(array.get(i)).append("/");
        }
        String s = stringBuilder.toString();
        return s.substring(0, s.length() - 1);
    }

    public String linkStringFromArray2(List<String> array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.size(); i++) {
            stringBuilder.append(array.get(i)).append(" ");
        }
        String s = stringBuilder.toString();
        return s.substring(0, s.length() - 1);
    }
}
