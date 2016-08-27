package com.thaile.btvnlab06_duoihinhbatchu.Activity;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionManager {
    public ArrayList<QuestionObject> arrayList;

    public QuestionManager(){
        arrayList = new ArrayList<>();
        initObject();
        Collections.shuffle(arrayList);
    }

    public void initObject(){
        QuestionObject questionObject01 = new QuestionObject("tranhthu.jpg", "UJESTARHDNTTUUAH", "TRANHTHU", "TRANHTHỦ");
        arrayList.add(questionObject01);
        QuestionObject questionObject02 = new QuestionObject("aomua.jpg", "EREEALXOOTHHAMAU", "AOMUA", "ÁOMƯA");
        arrayList.add(questionObject02);
        QuestionObject questionObject03 = new QuestionObject("chieutre.jpg", "TTHRLDEUCCHSEIUF", "CHIEUTRE", "CHIẾUTRE");
        arrayList.add(questionObject03);
        QuestionObject questionObject04 = new QuestionObject("hoidong.jpg", "OODNDHGHOEIDJCLG", "HOIDONG", "HỘIĐỒNG");
        arrayList.add(questionObject04);
        QuestionObject questionObject05 = new QuestionObject("canthiep.jpg", "PPSEHFLCJNCAIEHT", "CANTHIEP", "CANTHIỆP");
        arrayList.add(questionObject05);
        QuestionObject questionObject06 = new QuestionObject("giandiep.jpg", "IGIRIDGANPPEIDIS", "GIANDIEP", "GIÁNĐIỆP");
        arrayList.add(questionObject06);
        QuestionObject questionObject07 = new QuestionObject("baocao.jpg", "OERODCFKSABBRSOA", "BAOCAO", "BÁOCÁO");
        arrayList.add(questionObject07);
        QuestionObject questionObject08 = new QuestionObject("danhlua.jpg", "LXSHULDAAANHEDKFIS", "DANHLUA", "ĐÁNHLỪA");
        arrayList.add(questionObject08);
        QuestionObject questionObject09 = new QuestionObject("cattuong.jpg", "TTCHCJDOSATNGDTU", "CATTUONG", "CÁTTƯỜNG");
        arrayList.add(questionObject09);
        QuestionObject questionObject10 = new QuestionObject("danong.jpg", "DJORNFASOFGDNEJD", "DANONG", "ĐÀNÔNG");
        arrayList.add(questionObject10);
        QuestionObject questionObject11 = new QuestionObject("vuonbachthu.jpg", "ATSEHEUVEOUNCHBA", "VUONBACHTHU", "VƯỜNBÁCHTHÚ");
        arrayList.add(questionObject11);
        QuestionObject questionObject12 = new QuestionObject("xakep.jpg", "XSAFSDKSDFEFSDPF", "XAKEP", "XÀKÉP");
        arrayList.add(questionObject12);
        QuestionObject questionObject13 = new QuestionObject("xaphong.jpg", "AAZSXPSLEOHNGCRI","XAPHONG", "XÀPHÒNG");
        arrayList.add(questionObject13);
        QuestionObject questionObject14 = new QuestionObject("khoailang.jpg", "AHIKDAIENSKGLSEO","KHOAILANG", "KHOAILANG");
        arrayList.add(questionObject14);
        QuestionObject questionObject15 = new QuestionObject("xedapdien.jpg", "NEDXWDEWPSADWEIP", "XEDAPDIEN", "XEĐẠPĐIỆN");
        arrayList.add(questionObject15);
        QuestionObject questionObject16 = new QuestionObject("hoga.png", "EHWTSAEOGAEHWGAW", "HOGA", "HOGÀ");
        arrayList.add(questionObject16);
        QuestionObject questionObject17 = new QuestionObject("thattinh.jpg", "HFUSTIXNHSATISNT", "THATTINH", "THẤTTÌNH");
        arrayList.add(questionObject17);
        QuestionObject questionObject18 = new QuestionObject("thuocngu.jpg", "JCHSCHTUWTNSGUOE", "THUOCNGU", "THUỐCNGỦ");
        arrayList.add(questionObject18);
        QuestionObject questionObject19 = new QuestionObject("ngucoc.jpg", "RSHATUXGCSEOSCGN", "NGUCOC", "NGŨCỐC");
        arrayList.add(questionObject19);
        QuestionObject questionObject20 = new QuestionObject("bahoa.gif", "CCBSHANAHEOAHAAB", "BAHOA", "BAHOA");
        arrayList.add(questionObject20);
        QuestionObject questionObject21 = new QuestionObject("dola.jpg", "TAHOYELIDJAALSKA", "DOLA", "ĐÔLA");
        arrayList.add(questionObject21);
        QuestionObject questionObject22 = new QuestionObject("tohoai.jpg", "OAIEHDNSITROAISO", "TOHOAI", "TÔHOÀI");
        arrayList.add(questionObject22);
        QuestionObject questionObject23 = new QuestionObject("thathoc.jpg", "HOEIDLAWRRTTCHAT", "THATHOC", "THẤTHỌC");
        arrayList.add(questionObject23);
    }


    public int getSize(){
        return arrayList.size();
    }

    public void deleteObject(int i){
        arrayList.remove(i);
    }
}
