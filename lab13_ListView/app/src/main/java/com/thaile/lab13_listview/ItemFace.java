package com.thaile.lab13_listview;

import java.io.Serializable;

/**
 * Created by Le on 7/14/2016.
 */
public class ItemFace implements Serializable {
    private int idFace;
    private String name;

    public ItemFace(int idFace, String name){
        this.idFace = idFace;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdFace() {
        return idFace;
    }

    public void setIdFace(int idFace) {
        this.idFace = idFace;
    }
}
