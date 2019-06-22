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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.zinzin.tooluploaddb.R;
import com.zinzin.tooluploaddb.model.teamFightTatics.Detail;
import com.zinzin.tooluploaddb.model.teamFightTatics.Item;
import com.zinzin.tooluploaddb.model.teamFightTatics.Round;
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
    int idItem = 0;
    DatabaseReference rootRef;

    public static TFTFragment newInstance() {
        return new TFTFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upload, container, false);
        rootRef = FirebaseDatabase.getInstance().getReference().child("tft_db");
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
                return "";
            }

            @Override
            protected void onPostExecute(String result) {
                for (Unit unit : unitList) {
                    rootRef.child("unitList").child(unit.getName()).setValue(unit);

                }
                for (Detail detail : detailList) {
                    rootRef.child("detailList").child(detail.getName()).setValue(detail);
                }
                for (Item item : itemList) {
                    rootRef.child("itemList").child(String.valueOf(item.getId())).setValue(item);
                }
                for (Round round : roundList) {
                    rootRef.child("roundList").child(round.getName()).setValue(round);
                }
            }
        }.execute();
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
            Log.e("qewqw","");
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
                        Elements itemCombine = elementCombineItem.getElementsByClass("rb-build-overview-td best-hero-list-items").first().select("a");
                        List<String> listCombine = new ArrayList<>();
                        for (Element combineUrl : itemCombine) {
                            listCombine.add(combineUrl.attr("href"));
                        }
                        item.setListCombine(listCombine);
                    }
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
                Elements stat = docDetail.getElementsByClass("rb-build-overview-wrap-tabl").first().getElementsByClass("rb-build-overview-td");
                List<String> statList = new ArrayList<>();
                for (int i = 0; i < stat.size() - 1; i = i + 2) {
                    statList.add(stat.get(i).text() + ": " + stat.get(i + 1).text());
                }
                String statString = "";
                for (String stats : statList) {
                    statString = statString + stats + "\n";
                }
                detail.setStat(statString.substring(0, statString.length() - 1));
                Elements skill = docDetail.getElementsByClass("rb-build-overview-wrap-tabl").get(1).getElementsByClass("rb-build-overview-td");
                detail.setSkill_des(skill.get(1).text());
                detail.setSkill_name(skill.get(2).select("img").attr("title"));
                detail.setSkill_url(skill.get(2).select("img").attr("src"));
                Elements skillDameEles = skill.get(3).getElementsByClass("ability-lb");
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
            for (int i = 0; i < 7; i++) {
                Elements unitListElements = tierElements.get(i).getElementsByClass("TierListChampionContainer");
                //lay url detail
                Elements detailElements = tierElements.get(i).select("a");
                for (Element detail : detailElements) {
                    String detailUrl = detail.attr("href");
                    detailUrlList.add(detailUrl);
                }
                //lay tier
                String tier = "";
                switch (i) {
                    case 0:
                        tier = "S Tier (GOD TIER)";
                        break;
                    case 1:
                        tier = "A Tier (STRONG)";
                        break;
                    case 2:
                        tier = "B Tier (GOOD)";
                        break;
                    case 3:
                        tier = "C Tier (AVERAGE)";
                        break;
                    case 4:
                        tier = "D Tier (BELOW AVERAGE)";
                        break;
                    case 5:
                        tier = "E Tier (WEAK)";
                        break;
                    case 6:
                        tier = "F Tier (WORST TIER)";
                        break;
                }
                for (Element unitElements : unitListElements) {
                    Unit unit = new Unit();
                    unit.setTier(tier);
                    unit.setUrl(unitElements.getElementsByClass("image-wrap-list-underlords").select("img").attr("src"));
                    unit.setCost(unitElements.getElementsByClass("span-item-tier").first().text());
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
