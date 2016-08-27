package com.thaile.btvnlab13_appdoctruyen.Item;

import java.io.Serializable;

/**
 * Created by Le on 7/16/2016.
 */
public class ItemStory implements Serializable {
    private String titleName;
    private String topic;
    private String content;

    public ItemStory(String topic, String titleName, String content){
        this.topic = topic;
        this.titleName = titleName;
        this.content = content;
    }

    public String getContent() {
        return content;
    }


    public String getTitleName() {
        return titleName;
    }

    public String getTopic() {
        return topic;
    }
}
