package com.thaile.btvnlab13_appdoctruyen.Activity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.thaile.btvnlab13_appdoctruyen.Item.ItemData;
import com.thaile.btvnlab13_appdoctruyen.Item.ItemStory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DBManager {
    private static final String PATH = "/data/data/com.thaile.btvnlab13_appdoctruyen/databases";
    private final static String DATABASE_NAME = "Stories.sqlite";
    private Context context;
    private SQLiteDatabase sqLiteDatabase ;
    private ArrayList<String> arrTableName = new ArrayList<>();;
    public DBManager(Context context) {
        this.context = context;
        copyDatabaseToInternal();

    }

    private void copyDatabaseToInternal() {
        //tạo folder
        (new File(PATH)).mkdir();

        File file = new File(PATH + DATABASE_NAME);
        if (file.exists()){
            return;
        }

        try {

            DataInputStream input = new DataInputStream(context.getAssets().open(DATABASE_NAME));

            DataOutputStream output = new DataOutputStream(new FileOutputStream(PATH+DATABASE_NAME));

            byte[] b = new byte[1024];
            int length;

            while ((length = input.read(b)) != -1){
                output.write(b, 0, length);
            }

            output.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void open() {
        if (sqLiteDatabase == null
                || !sqLiteDatabase.isOpen()) {
            sqLiteDatabase = SQLiteDatabase.openDatabase(PATH + DATABASE_NAME,
                    null, SQLiteDatabase.OPEN_READWRITE);
        }
    }

    private void close() {
        if (sqLiteDatabase != null
                && sqLiteDatabase.isOpen()) {
            sqLiteDatabase.close();
        }
    }

    public ArrayList<ItemData> getStory(){
        ArrayList<ItemData> listStoryItem = new ArrayList<>();
        ArrayList<ItemStory> list = null;
        String name ;
        open();
        ArrayList<String> nameTopicList = getNameTopic();
        int size =  nameTopicList.size();
        for (int i = 0; i < size ; i++) {
            list = rawSQL("SELECT * FROM " +nameTopicList.get(i));
            name = getVietName(nameTopicList.get(i));
            listStoryItem.add(new ItemData(name, list));
        }
        close();
        return listStoryItem;
    }

    public ArrayList<String> getNameTopic() {
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name != 'android_metadata' AND name != 'sqlite_sequence'";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.getCount() == 0) {
            close();
            return null;
        }
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String tName = cursor.getString(cursor.getColumnIndex("name"));
            arrTableName.add(tName);
            cursor.moveToNext();
        }
        cursor.close();

        return arrTableName;
    }

    public String getVietName(String name) {
        String newName = null;
        for (int i = 0; i < arrTableName.size(); i++) {
            if (name.equals("TruyenCuoiConGai")) {
                newName = "Truyện Cười Con Gái";
            } else if (name.equals("TruyenCuoiConTrai")) {
                newName = "Truyện Cười Con Trai";
            } else if (name.equals("TruyenCuoiNgheNghiep")) {
                newName = "Truyện Cười Nghề Nghiệp";
            } else if (name.equals("TruyenCuoiYHoc")) {
                newName = "Truyện Cười Y Học";
            } else if (name.equals("TruyenCuoiDanGian")) {
                newName = "Truyện Cười Dân Gian";
            } else if (name.equals("TruyenCuoiGiaDinh")) {
                newName = "Truyện Cười Gia Đình";
            } else if (name.equals("TruyenCuoiTinhYeu")) {
                newName = "Truyện Cười Tình Yêu";
            } else if (name.equals("TruyenCuoiTheThao")) {
                newName = "Truyện Cười Thể Thao";
            } else if (name.equals("TruyenCuoiKhoaHoc")) {
                newName = "Truyện Cười Khoa Học";
            } else if (name.equals("TruyenCuoiHocDuong")) {
                newName = "Truyện Cười Học Đường";
            } else if (name.equals("TruyenCuoiGiaoThong")) {
                newName = "Truyện Cười Giao Thông";
            } else if (name.equals("TruyenCuoiCongNghe")) {
                newName = "Truyện Cười Công Nghệ";
            } else if (name.equals("TruyenCuoiPhapLuat")) {
                newName = "Truyện Cười Pháp Luật";
            }
        }
        return newName;
    }

    public ArrayList<ItemStory> rawSQL(String sql){
        open();
        ArrayList<ItemStory> listItem = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.getCount() == 0){
            close();
            return null;
        }
        ItemStory itemStory = null;
        cursor.moveToFirst();

        int titleIndex = cursor.getColumnIndex("Title");
        int contentIndex = cursor.getColumnIndex("Content");
        int topicIndex = cursor.getColumnIndex("Topic");
        int imageIndex = cursor.getColumnIndex("NameImage");

        while (!cursor.isAfterLast()){
            String title = cursor.getString(titleIndex);
            String content = cursor.getString(contentIndex);
            String topic = cursor.getString(topicIndex);

            itemStory = new ItemStory(topic, title, content);
            listItem.add(itemStory);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return listItem;
    }

}
