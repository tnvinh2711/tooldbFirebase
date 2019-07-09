package com.zinzin.tooluploaddb.model.AutoChess;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zinzin.tooluploaddb.R;

import java.lang.reflect.Type;
import java.util.List;

public class SetImage {
    public static List<Units> fullUnitsList(String text){
        text = text.replace("dota_name:","\"dota_convert\":");
        text = text.replace("name:","\"name\":");
        text = text.replace("id:","\"id\":");
        text = text.replace("tier:","\"tier\":");
        text = text.replace("tier_up:!","\"tier_up\":");
        text = text.replace("tier_down:!","\"tier_down\":");
        text = text.replace("new:!","\"new\":");
        text = text.replace("popular:!","\"popular\":");
        text = text.replace("updated:!","\"updated\":");
        text = text.replace("buff:!","\"buff\":");
        text = text.replace("nerf:!","\"nerf\":");
        text = text.replace("info:","\"info\":");
        text = text.replace("dota_race:","\"dota_convert_r\":");
        text = text.replace("dota_class:","\"dota_convert_c\":");
        text = text.replace("class:","\"class\":");
        text = text.replace("race:","\"race\":");
        text = text.replace("cost:","\"cost\":");
        text = text.replace("health:","\"health\":");
        text = text.replace("armor:","\"armor\":");
        text = text.replace("resistance:","\"resistance\":");
        text = text.replace("attack:","\"attack\":");
        text = text.replace("speed:","\"speed\":");
        text = text.replace("dps:","\"dps\":");
        text = text.replace("range:","\"range\":");
        text = text.replace("skill:","\"skill\":");
        text = text.replace("type:","\"type\":");
        text = text.replace("description:","\"description\":");
        text = text.replace("tags:","\"tags\":");
        text = text.replace("bonus:","\"bonus\":");
        Gson gson = new Gson();
        Type type = new TypeToken<List<Units>>() {}.getType();
        List<Units> unitsList = gson.fromJson(text, type);
        unitsList.get(0).setFull_image(R.drawable.slark_f);
        unitsList.get(0).setIcon_image(R.drawable.a1);
        unitsList.get(0).setMini_image(R.drawable.slark_ava);
        unitsList.get(0).setSkill_image(R.drawable.slark_skill);
        unitsList.get(0).setColor_name(R.color.color_cost_2);

        unitsList.get(1).setFull_image(R.drawable.slardar_full);
        unitsList.get(1).setIcon_image(R.drawable.a2);
        unitsList.get(1).setMini_image(R.drawable.slardar_ava);
        unitsList.get(1).setSkill_image(R.drawable.slardar_skill);
        unitsList.get(1).setColor_name(R.color.color_cost_2);

        unitsList.get(2).setFull_image(R.drawable.omniknight_full);
        unitsList.get(2).setIcon_image(R.drawable.a3);
        unitsList.get(2).setMini_image(R.drawable.omniknight_ava);
        unitsList.get(2).setSkill_image(R.drawable.omniknight_skill);
        unitsList.get(2).setColor_name(R.color.color_cost_3);

        unitsList.get(3).setFull_image(R.drawable.troll_warlord_full);
        unitsList.get(3).setIcon_image(R.drawable.a4);
        unitsList.get(3).setMini_image(R.drawable.troll_warlord_ava);
        unitsList.get(3).setSkill_image(R.drawable.troll_warlord_skill);
        unitsList.get(3).setColor_name(R.color.color_cost_4);

        unitsList.get(4).setFull_image(R.drawable.lich_full);
        unitsList.get(4).setIcon_image(R.drawable.a5);
        unitsList.get(4).setMini_image(R.drawable.lich_ava);
        unitsList.get(4).setSkill_image(R.drawable.lich_skill);
        unitsList.get(4).setColor_name(R.color.color_cost_5);

        unitsList.get(5).setFull_image(R.drawable.enigma_full);
        unitsList.get(5).setIcon_image(R.drawable.a6);
        unitsList.get(5).setMini_image(R.drawable.enigma_ava);
        unitsList.get(5).setSkill_image(R.drawable.enigma_skill);
        unitsList.get(5).setColor_name(R.color.color_cost_5);

        unitsList.get(6).setFull_image(R.drawable.shadow_shaman_full);
        unitsList.get(6).setIcon_image(R.drawable.a7);
        unitsList.get(6).setMini_image(R.drawable.shadow_shaman_ava);
        unitsList.get(6).setSkill_image(R.drawable.shadow_shaman_skill);
        unitsList.get(6).setColor_name(R.color.color_cost_1);

        unitsList.get(7).setFull_image(R.drawable.witch_doctor_full);
        unitsList.get(7).setIcon_image(R.drawable.a8);
        unitsList.get(7).setMini_image(R.drawable.witch_doctor_ava);
        unitsList.get(7).setSkill_image(R.drawable.witch_doctor_skill);
        unitsList.get(7).setColor_name(R.color.color_cost_2);

        unitsList.get(8).setFull_image(R.drawable.techies_full);
        unitsList.get(8).setIcon_image(R.drawable.a9);
        unitsList.get(8).setMini_image(R.drawable.techies_ava);
        unitsList.get(8).setSkill_image(R.drawable.techies_skill);
        unitsList.get(8).setColor_name(R.color.color_cost_5);

        unitsList.get(9).setFull_image(R.drawable.doom_full);
        unitsList.get(9).setIcon_image(R.drawable.a10);
        unitsList.get(9).setMini_image(R.drawable.doom_ava);
        unitsList.get(9).setSkill_image(R.drawable.doom_skill);
        unitsList.get(9).setColor_name(R.color.color_cost_4);

        unitsList.get(10).setFull_image(R.drawable.dragon_knight_full);
        unitsList.get(10).setIcon_image(R.drawable.a11);
        unitsList.get(10).setMini_image(R.drawable.dragon_knight_ava);
        unitsList.get(10).setSkill_image(R.drawable.dragon_knight_skill);
        unitsList.get(10).setColor_name(R.color.color_cost_4);

        unitsList.get(11).setFull_image(R.drawable.sniper_full);
        unitsList.get(11).setIcon_image(R.drawable.a12);
        unitsList.get(11).setMini_image(R.drawable.sniper_ava);
        unitsList.get(11).setSkill_image(R.drawable.sniper_skill);
        unitsList.get(11).setColor_name(R.color.color_cost_3);

        unitsList.get(12).setFull_image(R.drawable.drow_ranger_full);
        unitsList.get(12).setIcon_image(R.drawable.a13);
        unitsList.get(12).setMini_image(R.drawable.drow_ranger_ava);
        unitsList.get(12).setSkill_image(R.drawable.drow_ranger_skill);
        unitsList.get(12).setColor_name(R.color.color_cost_1);

        unitsList.get(13).setFull_image(R.drawable.abaddon_full);
        unitsList.get(13).setIcon_image(R.drawable.a14);
        unitsList.get(13).setMini_image(R.drawable.abaddon_a);
        unitsList.get(13).setSkill_image(R.drawable.abaddon_s);
        unitsList.get(13).setColor_name(R.color.color_cost_3);

        unitsList.get(14).setFull_image(R.drawable.terrorblade_full);
        unitsList.get(14).setIcon_image(R.drawable.a15);
        unitsList.get(14).setMini_image(R.drawable.terrorblade_a);
        unitsList.get(14).setSkill_image(R.drawable.terrorblade_s);
        unitsList.get(14).setColor_name(R.color.color_cost_3);

        unitsList.get(15).setFull_image(R.drawable.lina_full);
        unitsList.get(15).setIcon_image(R.drawable.a16);
        unitsList.get(15).setMini_image(R.drawable.lina_a);
        unitsList.get(15).setSkill_image(R.drawable.lina_s);
        unitsList.get(15).setColor_name(R.color.color_cost_3);

        unitsList.get(16).setFull_image(R.drawable.batrider_full);
        unitsList.get(16).setIcon_image(R.drawable.a17);
        unitsList.get(16).setMini_image(R.drawable.batrider_a);
        unitsList.get(16).setSkill_image(R.drawable.batrider_s);
        unitsList.get(16).setColor_name(R.color.color_cost_1);

        unitsList.get(17).setFull_image(R.drawable.tinker_full);
        unitsList.get(17).setIcon_image(R.drawable.a18);
        unitsList.get(17).setMini_image(R.drawable.tinker_a);
        unitsList.get(17).setSkill_image(R.drawable.tinker_s);
        unitsList.get(17).setColor_name(R.color.color_cost_1);

        unitsList.get(18).setFull_image(R.drawable.gyrocopter_full);
        unitsList.get(18).setIcon_image(R.drawable.a19);
        unitsList.get(18).setMini_image(R.drawable.gyrocopter_a);
        unitsList.get(18).setSkill_image(R.drawable.gyrocopter_s);
        unitsList.get(18).setColor_name(R.color.color_cost_5);

        unitsList.get(19).setFull_image(R.drawable.chaos_knight_full);
        unitsList.get(19).setIcon_image(R.drawable.a20);
        unitsList.get(19).setMini_image(R.drawable.chaos_knight_a);
        unitsList.get(19).setSkill_image(R.drawable.chaos_knight_s);
        unitsList.get(19).setColor_name(R.color.color_cost_2);

        unitsList.get(20).setFull_image(R.drawable.luna_full);
        unitsList.get(20).setIcon_image(R.drawable.a21);
        unitsList.get(20).setMini_image(R.drawable.luna_a);
        unitsList.get(20).setSkill_image(R.drawable.luna_s);
        unitsList.get(20).setColor_name(R.color.color_cost_2);

        unitsList.get(21).setFull_image(R.drawable.sand_king_f);
        unitsList.get(21).setIcon_image(R.drawable.a22);
        unitsList.get(21).setMini_image(R.drawable.sand_king_a);
        unitsList.get(21).setSkill_image(R.drawable.sand_king_s);
        unitsList.get(21).setColor_name(R.color.color_cost_3);

        unitsList.get(22).setFull_image(R.drawable.ogre_magi_f);
        unitsList.get(22).setIcon_image(R.drawable.a23);
        unitsList.get(22).setMini_image(R.drawable.ogre_magi_a);
        unitsList.get(22).setSkill_image(R.drawable.ogre_magi_s);
        unitsList.get(22).setColor_name(R.color.color_cost_1);

        unitsList.get(23).setFull_image(R.drawable.queen_of_pain_f);
        unitsList.get(23).setIcon_image(R.drawable.a24);
        unitsList.get(23).setMini_image(R.drawable.queen_of_pain_a);
        unitsList.get(23).setSkill_image(R.drawable.queen_of_pain_s);
        unitsList.get(23).setColor_name(R.color.color_cost_2);

        unitsList.get(24).setFull_image(R.drawable.kunkka_f);
        unitsList.get(24).setIcon_image(R.drawable.a25);
        unitsList.get(24).setMini_image(R.drawable.kunkka_a);
        unitsList.get(24).setSkill_image(R.drawable.kunkka_s);
        unitsList.get(24).setColor_name(R.color.color_cost_4);

        unitsList.get(25).setFull_image(R.drawable.venomancer_f);
        unitsList.get(25).setIcon_image(R.drawable.a26);
        unitsList.get(25).setMini_image(R.drawable.venomancer_a);
        unitsList.get(25).setSkill_image(R.drawable.venomancer_s);
        unitsList.get(25).setColor_name(R.color.color_cost_3);

        unitsList.get(26).setFull_image(R.drawable.lone_druid_f);
        unitsList.get(26).setIcon_image(R.drawable.a27);
        unitsList.get(26).setMini_image(R.drawable.lone_druid_a);
        unitsList.get(26).setSkill_image(R.drawable.lone_druid_s);
        unitsList.get(26).setColor_name(R.color.color_cost_4);

        unitsList.get(27).setFull_image(R.drawable.axe_f);
        unitsList.get(27).setIcon_image(R.drawable.a28);
        unitsList.get(27).setMini_image(R.drawable.axe_a);
        unitsList.get(27).setSkill_image(R.drawable.axe_s);
        unitsList.get(27).setColor_name(R.color.color_cost_1);

        unitsList.get(28).setFull_image(R.drawable.timbersaw_f);
        unitsList.get(28).setIcon_image(R.drawable.a29);
        unitsList.get(28).setMini_image(R.drawable.timbersaw_a);
        unitsList.get(28).setSkill_image(R.drawable.timbersaw_s);
        unitsList.get(28).setColor_name(R.color.color_cost_2);

        unitsList.get(29).setFull_image(R.drawable.shadow_fiend_f);
        unitsList.get(29).setIcon_image(R.drawable.a30);
        unitsList.get(29).setMini_image(R.drawable.shadow_fiend_a);
        unitsList.get(29).setSkill_image(R.drawable.shadow_fiend_s);
        unitsList.get(29).setColor_name(R.color.color_cost_3);

        unitsList.get(30).setFull_image(R.drawable.phantom_assassin_f);
        unitsList.get(30).setIcon_image(R.drawable.a31);
        unitsList.get(30).setMini_image(R.drawable.phantom_assassin_a);
        unitsList.get(30).setSkill_image(R.drawable.phantom_assassin_s);
        unitsList.get(30).setColor_name(R.color.color_cost_3);

        unitsList.get(31).setFull_image(R.drawable.templar_assassin_f);
        unitsList.get(31).setIcon_image(R.drawable.a32);
        unitsList.get(31).setMini_image(R.drawable.templar_assassin_a);
        unitsList.get(31).setSkill_image(R.drawable.templar_assassin_s);
        unitsList.get(31).setColor_name(R.color.color_cost_4);

        unitsList.get(32).setFull_image(R.drawable.puck_f);
        unitsList.get(32).setIcon_image(R.drawable.a33);
        unitsList.get(32).setMini_image(R.drawable.puck_a);
        unitsList.get(32).setSkill_image(R.drawable.puck_s);
        unitsList.get(32).setColor_name(R.color.color_cost_2);

        unitsList.get(33).setFull_image(R.drawable.medusa_f);
        unitsList.get(33).setIcon_image(R.drawable.a34);
        unitsList.get(33).setMini_image(R.drawable.medusa_a);
        unitsList.get(33).setSkill_image(R.drawable.medusa_s);
        unitsList.get(33).setColor_name(R.color.color_cost_4);

        unitsList.get(34).setFull_image(R.drawable.beastmaster_f);
        unitsList.get(34).setIcon_image(R.drawable.a35);
        unitsList.get(34).setMini_image(R.drawable.beastmaster_a);
        unitsList.get(34).setSkill_image(R.drawable.beastmaster_s);
        unitsList.get(34).setColor_name(R.color.color_cost_2);

        unitsList.get(35).setFull_image(R.drawable.clockwork_f);
        unitsList.get(35).setIcon_image(R.drawable.a36);
        unitsList.get(35).setMini_image(R.drawable.clockwork_a);
        unitsList.get(35).setSkill_image(R.drawable.clockwork_s);
        unitsList.get(35).setColor_name(R.color.color_cost_1);

        unitsList.get(36).setFull_image(R.drawable.bounty_hunter_f);
        unitsList.get(36).setIcon_image(R.drawable.a37);
        unitsList.get(36).setMini_image(R.drawable.bounty_hunter_a);
        unitsList.get(36).setSkill_image(R.drawable.bounty_hunter_s);
        unitsList.get(36).setColor_name(R.color.color_cost_1);

        unitsList.get(37).setFull_image(R.drawable.necrophos_f);
        unitsList.get(37).setIcon_image(R.drawable.a38);
        unitsList.get(37).setMini_image(R.drawable.necrophos_a);
        unitsList.get(37).setSkill_image(R.drawable.necrophos_s);
        unitsList.get(37).setColor_name(R.color.color_cost_4);

        unitsList.get(38).setFull_image(R.drawable.tiny_f);
        unitsList.get(38).setIcon_image(R.drawable.a39);
        unitsList.get(38).setMini_image(R.drawable.tiny_a);
        unitsList.get(38).setSkill_image(R.drawable.tiny_s);
        unitsList.get(38).setColor_name(R.color.color_cost_1);

        unitsList.get(39).setFull_image(R.drawable.disruptor_f);
        unitsList.get(39).setIcon_image(R.drawable.a40);
        unitsList.get(39).setMini_image(R.drawable.disruptor_a);
        unitsList.get(39).setSkill_image(R.drawable.disruptor_s);
        unitsList.get(39).setColor_name(R.color.color_cost_4);

        unitsList.get(40).setFull_image(R.drawable.juggernaut_f);
        unitsList.get(40).setIcon_image(R.drawable.a41);
        unitsList.get(40).setMini_image(R.drawable.juggernaut_a);
        unitsList.get(40).setSkill_image(R.drawable.juggernaut_s);
        unitsList.get(40).setColor_name(R.color.color_cost_2);

        unitsList.get(41).setFull_image(R.drawable.anti_mage_f);
        unitsList.get(41).setIcon_image(R.drawable.a42);
        unitsList.get(41).setMini_image(R.drawable.anti_mage_a);
        unitsList.get(41).setSkill_image(R.drawable.anti_mage_s);
        unitsList.get(41).setColor_name(R.color.color_cost_1);

        unitsList.get(42).setFull_image(R.drawable.crystal_maiden_f);
        unitsList.get(42).setIcon_image(R.drawable.a43);
        unitsList.get(42).setMini_image(R.drawable.crystal_maiden_a);
        unitsList.get(42).setSkill_image(R.drawable.crystal_maiden_s);
        unitsList.get(42).setColor_name(R.color.color_cost_2);

        unitsList.get(43).setFull_image(R.drawable.razor_f);
        unitsList.get(43).setIcon_image(R.drawable.a44);
        unitsList.get(43).setMini_image(R.drawable.razor_a);
        unitsList.get(43).setSkill_image(R.drawable.razor_s);
        unitsList.get(43).setColor_name(R.color.color_cost_3);

        unitsList.get(44).setFull_image(R.drawable.keeper_of_the_light_f);
        unitsList.get(44).setIcon_image(R.drawable.a45);
        unitsList.get(44).setMini_image(R.drawable.keeper_of_the_light_a);
        unitsList.get(44).setSkill_image(R.drawable.keeper_of_the_light_s);
        unitsList.get(44).setColor_name(R.color.color_cost_4);

        unitsList.get(45).setFull_image(R.drawable.tidehunter_f);
        unitsList.get(45).setIcon_image(R.drawable.a46);
        unitsList.get(45).setMini_image(R.drawable.tidehunter_a);
        unitsList.get(45).setSkill_image(R.drawable.tidehunter_s);
        unitsList.get(45).setColor_name(R.color.color_cost_5);

        unitsList.get(46).setFull_image(R.drawable.tusk_f);
        unitsList.get(46).setIcon_image(R.drawable.a47);
        unitsList.get(46).setMini_image(R.drawable.tusk_a);
        unitsList.get(46).setSkill_image(R.drawable.tusk_s);
        unitsList.get(46).setColor_name(R.color.color_cost_1);

        unitsList.get(47).setFull_image(R.drawable.enchantress_f);
        unitsList.get(47).setIcon_image(R.drawable.a48);
        unitsList.get(47).setMini_image(R.drawable.enchantress_a);
        unitsList.get(47).setSkill_image(R.drawable.enchantress_s);
        unitsList.get(47).setColor_name(R.color.color_cost_1);

        unitsList.get(48).setFull_image(R.drawable.viper_f);
        unitsList.get(48).setIcon_image(R.drawable.a49);
        unitsList.get(48).setMini_image(R.drawable.viper_a);
        unitsList.get(48).setSkill_image(R.drawable.viper_s);
        unitsList.get(48).setColor_name(R.color.color_cost_3);

        unitsList.get(49).setFull_image(R.drawable.alchemist_f);
        unitsList.get(49).setIcon_image(R.drawable.a50);
        unitsList.get(49).setMini_image(R.drawable.alchemist_a);
        unitsList.get(49).setSkill_image(R.drawable.alchemist_s);
        unitsList.get(49).setColor_name(R.color.color_cost_4);

        unitsList.get(50).setFull_image(R.drawable.treant_protector_f);
        unitsList.get(50).setIcon_image(R.drawable.a51);
        unitsList.get(50).setMini_image(R.drawable.treant_protector_a);
        unitsList.get(50).setSkill_image(R.drawable.treant_protector_s);
        unitsList.get(50).setColor_name(R.color.color_cost_3);

        unitsList.get(51).setFull_image(R.drawable.morphling_f);
        unitsList.get(51).setIcon_image(R.drawable.a52);
        unitsList.get(51).setMini_image(R.drawable.morphling_a);
        unitsList.get(51).setSkill_image(R.drawable.morphling_s);
        unitsList.get(51).setColor_name(R.color.color_cost_2);

        unitsList.get(52).setFull_image(R.drawable.lycan_f);
        unitsList.get(52).setIcon_image(R.drawable.a53);
        unitsList.get(52).setMini_image(R.drawable.lycan_a);
        unitsList.get(52).setSkill_image(R.drawable.lycan_s);
        unitsList.get(52).setColor_name(R.color.color_cost_3);

        unitsList.get(53).setFull_image(R.drawable.windranger_f);
        unitsList.get(53).setIcon_image(R.drawable.a54);
        unitsList.get(53).setMini_image(R.drawable.windranger_a);
        unitsList.get(53).setSkill_image(R.drawable.windranger_s);
        unitsList.get(53).setColor_name(R.color.color_cost_3);

        unitsList.get(54).setFull_image(R.drawable.furion_f);
        unitsList.get(54).setIcon_image(R.drawable.a55);
        unitsList.get(54).setMini_image(R.drawable.furion_a);
        unitsList.get(54).setSkill_image(R.drawable.furion_s);
        unitsList.get(54).setColor_name(R.color.color_cost_2);

        unitsList.get(55).setFull_image(R.drawable.god_f_2);
        unitsList.get(55).setIcon_image(R.drawable.god_a_2);
        unitsList.get(55).setMini_image(R.drawable.god_m_2);
        unitsList.get(55).setSkill_image(R.drawable.god_s_2);
        unitsList.get(55).setColor_name(R.color.color_cost_1);

        unitsList.get(56).setFull_image(R.drawable.god_f_1);
        unitsList.get(56).setIcon_image(R.drawable.god_a_1);
        unitsList.get(56).setMini_image(R.drawable.god_m_1);
        unitsList.get(56).setSkill_image(R.drawable.god_s_1);
        unitsList.get(56).setColor_name(R.color.color_cost_5);

        unitsList.get(57).setFull_image(R.drawable.io_f);
        unitsList.get(57).setIcon_image(R.drawable.io_a);
        unitsList.get(57).setMini_image(R.drawable.io_m);
        unitsList.get(57).setSkill_image(R.drawable.io_s);
        unitsList.get(57).setColor_name(R.color.color_cost_5);

        return unitsList;
    }

    public static List<ClassList> fullClassList(String text){
        text = text.replace("dota_name:","\"dota_convert\":");
        text = text.replace("name:","\"name\":");
        text = text.replace("tier_up:!","\"tier_up\":");
        text = text.replace("tier_down:!","\"tier_down\":");
        text = text.replace("tier:","\"tier\":");
        text = text.replace("effect:","\"effect\":");
        text = text.replace("bonus:","\"bonus\":");
        Gson gson = new Gson();
        Type type = new TypeToken<List<ClassList>>() {}.getType();
        List<ClassList> classLists = gson.fromJson(text, type);
        classLists.get(0).setImgClass(String.valueOf(R.drawable.assassin));
        classLists.get(1).setImgClass(String.valueOf(R.drawable.druid));
        classLists.get(2).setImgClass(String.valueOf(R.drawable.hunter));
        classLists.get(3).setImgClass(String.valueOf(R.drawable.knight));
        classLists.get(4).setImgClass(String.valueOf(R.drawable.mage));
        classLists.get(5).setImgClass(String.valueOf(R.drawable.mech));
        classLists.get(6).setImgClass(String.valueOf(R.drawable.shaman));
        classLists.get(7).setImgClass(String.valueOf(R.drawable.warlock));
        classLists.get(8).setImgClass(String.valueOf(R.drawable.warrior));
        classLists.get(9).setImgClass(String.valueOf(R.drawable.witcher));
        return classLists;
    }

    public static List<RaceList> fullRaceList(String text2){
        text2 = text2.replace("dota_name:","\"dota_convert\":");
        text2 = text2.replace("name:","\"name\":");
        text2 = text2.replace("tier_up:!","\"tier_up\":");
        text2 = text2.replace("tier_down:!","\"tier_down\":");
        text2 = text2.replace("tier:","\"tier\":");
        text2 = text2.replace("effect:","\"effect\":");
        text2 = text2.replace("bonus:","\"bonus\":");
        Gson gson = new Gson();
        Type type = new TypeToken<List<RaceList>>() {}.getType();
        List<RaceList> raceList = gson.fromJson(text2, type);
        raceList.get(0).setImgRace(String.valueOf(R.drawable.beast));
        raceList.get(1).setImgRace(String.valueOf(R.drawable.cave_clan));
        raceList.get(2).setImgRace(String.valueOf(R.drawable.demon));
        raceList.get(3).setImgRace(String.valueOf(R.drawable.dragon));
        raceList.get(4).setImgRace(String.valueOf(R.drawable.dwarf));
        raceList.get(5).setImgRace(String.valueOf(R.drawable.egersis));
        raceList.get(6).setImgRace(String.valueOf(R.drawable.feathered));
        raceList.get(7).setImgRace(String.valueOf(R.drawable.glacier_clan));
        raceList.get(8).setImgRace(String.valueOf(R.drawable.goblin));
        raceList.get(9).setImgRace(String.valueOf(R.drawable.race_god));
        raceList.get(10).setImgRace(String.valueOf(R.drawable.human));
        raceList.get(11).setImgRace(String.valueOf(R.drawable.kira));
        raceList.get(12).setImgRace(String.valueOf(R.drawable.marine));
        raceList.get(13).setImgRace(String.valueOf(R.drawable.spirit));
        return raceList;
    }
    public static List<Item> fullItemList(String text){
        text = text.replace("dota_name:","\"dota_convert\":");
        text = text.replace("dota_combine:","\"dota_convert_cb\":");
        text = text.replace("name:","\"name\":");
        text = text.replace("bonus:","\"bonus\":");
        text = text.replace("combine:","\"combine\":");

        Gson gson = new Gson();
        Type type = new TypeToken<List<Item>>() {}.getType();
        List<Item> itemList = gson.fromJson(text, type);
        itemList.get(0).setImgItem(R.drawable.i1);
        itemList.get(1).setImgItem(R.drawable.i2);
        itemList.get(2).setImgItem(R.drawable.i3);
        itemList.get(3).setImgItem(R.drawable.i4);
        itemList.get(4).setImgItem(R.drawable.i5);
        itemList.get(5).setImgItem(R.drawable.i6);
        itemList.get(6).setImgItem(R.drawable.i7);
        itemList.get(7).setImgItem(R.drawable.i8);
        itemList.get(8).setImgItem(R.drawable.i9);
        itemList.get(9).setImgItem(R.drawable.i10);
        itemList.get(10).setImgItem(R.drawable.i11);
        itemList.get(11).setImgItem(R.drawable.i12);
        itemList.get(12).setImgItem(R.drawable.i13);
        itemList.get(13).setImgItem(R.drawable.i14);
        itemList.get(14).setImgItem(R.drawable.i15);
        itemList.get(15).setImgItem(R.drawable.i16);
        itemList.get(16).setImgItem(R.drawable.i17);
        itemList.get(17).setImgItem(R.drawable.i18);
        itemList.get(18).setImgItem(R.drawable.i19);
        itemList.get(19).setImgItem(R.drawable.i20);
        itemList.get(20).setImgItem(R.drawable.i21);
        itemList.get(21).setImgItem(R.drawable.i22);
        itemList.get(22).setImgItem(R.drawable.i23);
        itemList.get(23).setImgItem(R.drawable.i24);
        itemList.get(24).setImgItem(R.drawable.i25);
        itemList.get(25).setImgItem(R.drawable.i26);
        itemList.get(26).setImgItem(R.drawable.i27);
        itemList.get(27).setImgItem(R.drawable.i28);
        itemList.get(28).setImgItem(R.drawable.i29);
        itemList.get(29).setImgItem(R.drawable.i30);
        itemList.get(30).setImgItem(R.drawable.i31);
        itemList.get(31).setImgItem(R.drawable.i32);
        itemList.get(32).setImgItem(R.drawable.i33);
        itemList.get(33).setImgItem(R.drawable.i34);
        itemList.get(34).setImgItem(R.drawable.i35);
        itemList.get(35).setImgItem(R.drawable.i36);
        itemList.get(36).setImgItem(R.drawable.i37);
        itemList.get(37).setImgItem(R.drawable.i38);
        itemList.get(38).setImgItem(R.drawable.i39);
        itemList.get(39).setImgItem(R.drawable.i40);
        itemList.get(40).setImgItem(R.drawable.i41);
        itemList.get(41).setImgItem(R.drawable.i42);
        itemList.get(42).setImgItem(R.drawable.i43);
        itemList.get(43).setImgItem(R.drawable.i44);
        itemList.get(44).setImgItem(R.drawable.i45);
        itemList.get(45).setImgItem(R.drawable.i46);
        itemList.get(46).setImgItem(R.drawable.i47);
        return itemList;
    }
    public static List<Creep> fullCreepList(String text){
        text = text.replace("round:","\"round\":");
        text = text.replace("name:","\"name\":");
        text = text.replace("creeps:","\"creeps\":");
        Gson gson = new Gson();
        Type type = new TypeToken<List<Creep>>() {}.getType();
        List<Creep> creepLists = gson.fromJson(text, type);
        return creepLists;
    }
}
