package com.thaile.lab13_listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Le on 7/14/2016.
 */
public class FaceAct extends AppCompatActivity {
    private ImageView img;
    private TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face);
        initView();
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);

        Intent data = getIntent();
        ItemFace item = (ItemFace) data.getSerializableExtra(MainActivity.KEY_ITEM_FACE);
        img.setImageResource(item.getIdFace());
        name.setText(item.getName());
    }


}
