package com.thaile.btvnlab13_appdoctruyen.Item;

import java.io.Serializable;

/**
 * Created by Le on 7/16/2016.
 */
public class ItemStory implements Serializable {
    private String titleName;
    private String topic;
    private String content;
    private byte imgStory[];

    public ItemStory(String topic, String titleName, String content, byte imgStory[]){
        this.topic = topic;
        this.titleName = titleName;
        this.content = content;
        this.imgStory = imgStory;
    }

    public String getContent() {
        return content;
    }

    public byte[] getImgStory() {
        return imgStory;
    }

    public String getTitleName() {
        return titleName;
    }

    public String getTopic() {
        return topic;
    }
}
