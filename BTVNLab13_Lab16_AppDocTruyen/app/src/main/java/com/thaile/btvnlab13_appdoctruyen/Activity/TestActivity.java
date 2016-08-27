package com.thaile.btvnlab13_appdoctruyen.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.thaile.btvnlab13_appdoctruyen.Item.ItemData;
import com.thaile.btvnlab13_appdoctruyen.R;

import java.util.ArrayList;

/**
 * Created by Le on 8/20/2016.
 */
public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        DBManager dbManager = new DBManager(this);

        ArrayList<ItemData> item = dbManager.getStory();
        Log.i("SIZE", item.size()+"-");
        for (int i = 0; i < item.size() ; i++) {
           Log.i("TAG", item.get(i).getNameData());
        }
    }
}
