package com.thaile.btvnlab13_appdoctruyen.Item;

import java.util.ArrayList;

/**
 * Created by Le on 8/20/2016.
 */
public class ItemData {
    private String nameData;
    private ArrayList<ItemStory> data;

    public ItemData(String nameData, ArrayList<ItemStory> data){
        this.data = data;
        this.nameData = nameData;
    }

    public String getNameData() {
        return nameData;
    }

    public ArrayList<ItemStory> getData() {
        return data;
    }

}
