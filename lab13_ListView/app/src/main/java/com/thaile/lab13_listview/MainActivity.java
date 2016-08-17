package com.thaile.lab13_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String KEY_ITEM_FACE = "KEY_ITEM_FACE";
    //private ListView listView;
    private GridView listView;
    private FaceAdapter faceAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
//        listView = (ListView) findViewById(R.id.lvFace);
        listView = (GridView) findViewById(R.id.lvFace);
        faceAdapter = new FaceAdapter(this);
        listView.setAdapter(faceAdapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        ItemFace items = (ItemFace) parent.getItemAtPosition(position);
//
//        Intent intent = new Intent(MainActivity.this, FaceAct.class);
//        //items trở thành đối tượng có thể truyền đi => ItemFace implement Serilazable
//        intent.putExtra(KEY_ITEM_FACE, items);
//        startActivity(intent);

        faceAdapter.deleteItem(position);

    }
}
