package com.thaile.btvnlab13_appdoctruyen.Activity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.thaile.btvnlab13_appdoctruyen.Item.ItemStory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Le on 8/17/2016.
 */
public class DBManager {
    private static final String PATH = "/data/data/com.thaile.lab21_database/databases";
    private final static String DATABASE_NAME = "Stories.sqlite";
    private Context context;
    private SQLiteDatabase sqLiteDatabase ;
    public static ArrayList<ItemStory> listStoryItem;
    public ArrayList<String> tableVietName;
    public ArrayList<String> keyTableName = new ArrayList<>();
    private ArrayList<String> arrTableName;
    private HashMap<String, ArrayList<ItemStory>> myHashmap;
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
            //mở dữ liệu ra để đọc
            DataInputStream input = new DataInputStream(context.getAssets().open(DATABASE_NAME));

            //ghi dữ liệu vào 1 file
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

    private void open(){
        if (sqLiteDatabase == null || !sqLiteDatabase.isOpen()) {
            //flags: chế độ: đọc/ghi
            sqLiteDatabase = SQLiteDatabase.openDatabase(PATH + DATABASE_NAME, null, SQLiteDatabase.OPEN_READWRITE);
        }

    }

    private void close (){
        if (sqLiteDatabase != null && sqLiteDatabase.isOpen()){
            sqLiteDatabase.close();
        }
    }

    public HashMap<String, ArrayList<ItemStory>> getStory(){
        myHashmap= new HashMap();
        listStoryItem = new ArrayList<>();
        String tName ;
        for (int i = 0; i < arrTableName.size() ; i++) {
            tName = arrTableName.get(i).toString();
            ItemStory itemStory = rawSQL("SELECT * From " +tName);

            if (tableVietName.get(i).equals(itemStory.getTopic())){
                listStoryItem.add(itemStory);
                myHashmap.put(tableVietName.get(i).toString(), listStoryItem);
            }

        }
        return myHashmap;
    }

    public ArrayList<String> getStoryVietTopic(){
        open();
        arrTableName = new ArrayList<>();
        tableVietName = new ArrayList<>();
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name != 'android_metadata' AND name != 'sqlite_sequence'";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.getCount() == 0){
            return null;
        }
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            String tName = cursor.getString(cursor.getColumnIndex("name"));
            arrTableName.add(tName);
            cursor.moveToNext();
        }

        for (int i = 0; i <arrTableName.size() ; i++) {
            String name = arrTableName.get(i).toString();
            if (name.equals("TruyenCuoiConGai")){
                tableVietName.add("Truyện Cười Con Gái");
            } else if (name.equals("TruyenCuoiConTrai")){
                tableVietName.add("Truyện Cười Con Trai");
            }  else if (name.equals("TruyenCuoiNgheNghiep")){
                tableVietName.add("Truyện Cười Nghề Nghiệp");
            }  else if (name.equals("TruyenCuoiYHoc")){
                tableVietName.add("Truyện Cười Y Học");
            }  else if (name.equals("TruyenCuoiDanGian")){
                tableVietName.add("Truyện Cười Dân Gian");
            }  else if (name.equals("TruyenCuoiGiaDinh")){
                tableVietName.add("Truyện Cười Gia Đình");
            }  else if (name.equals("TruyenCuoiTinhYeu")){
                tableVietName.add("Truyện Cười Tình Yêu");
            }  else if (name.equals("TruyenCuoiTheThao")){
                tableVietName.add("Truyện Cười Thể Thao");
            }  else if (name.equals("TruyenCuoiKhoaHoc")){
                tableVietName.add("Truyện Cười Khoa Học");
            }  else if (name.equals("TruyenCuoiHocDuong")){
                tableVietName.add("Truyện Cười Học Đường");
            }  else if (name.equals("TruyenCuoiGiaoThong")){
                tableVietName.add("Truyện Cười Giao Thông");
            }  else if (name.equals("TruyenCuoiCongNghe")){
                tableVietName.add("Truyện Cười Công Nghệ");
            } else if (name.equals("TruyenCuoiPhapLuat")){
                tableVietName.add("Truyện Cười Pháp Luật");
            }
        }
        close();
        return tableVietName;
    }

    public ItemStory rawSQL(String sql){
        open();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.getCount() == 0){
            return null;
        }

        cursor.moveToFirst();
        ItemStory itemStory = null;
        //
        int titleIndex = cursor.getColumnIndex("Title");
        int contentIndex = cursor.getColumnIndex("Content");
        int imgIndex = cursor.getColumnIndex("ImageStory");
        int topicIndex = cursor.getColumnIndex("Topic");

        while (!cursor.isAfterLast()){
            String title = cursor.getString(titleIndex);
            String content = cursor.getString(contentIndex);
            byte img[] = cursor.getBlob(imgIndex);
            String topic = cursor.getString(topicIndex);

            itemStory = new ItemStory(topic, title, content, img);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return itemStory;
    }

}
