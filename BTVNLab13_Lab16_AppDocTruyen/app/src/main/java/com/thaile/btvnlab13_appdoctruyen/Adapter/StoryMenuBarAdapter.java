package com.thaile.btvnlab13_appdoctruyen.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.thaile.btvnlab13_appdoctruyen.Activity.DBManager;
import com.thaile.btvnlab13_appdoctruyen.Item.ItemData;
import com.thaile.btvnlab13_appdoctruyen.R;

import java.util.ArrayList;

/**
 * Created by Le on 7/23/2016.
 */
public class StoryMenuBarAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private Context context;
    private DBManager dbManager;
    private ArrayList<ItemData> mDataArrayList;
    public StoryMenuBarAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        dbManager = new DBManager(context);
        mDataArrayList=dbManager.getStory();
    }

    @Override
    public int getCount() {
        return mDataArrayList.size();
    }

    @Override
    public String getItem(int position) {
        return mDataArrayList.get(position).getNameData();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder ;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.listview_item_bar, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txt = (TextView) convertView.findViewById(R.id.text_bar);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txt.setText(mDataArrayList.get(position).getNameData());
        return convertView;
    }

    private class ViewHolder{
        TextView txt;
    }

}
