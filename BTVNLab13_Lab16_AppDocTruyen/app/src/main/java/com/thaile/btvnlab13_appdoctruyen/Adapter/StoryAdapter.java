package com.thaile.btvnlab13_appdoctruyen.Adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thaile.btvnlab13_appdoctruyen.Item.ItemStory;
import com.thaile.btvnlab13_appdoctruyen.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Le on 7/20/2016.
 */
public class StoryAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<ItemStory> storyData = new ArrayList<>();

    public StoryAdapter (ArrayList<ItemStory> storyData, Context context){
        this.context = context;
        this.storyData = storyData;
        layoutInflater = LayoutInflater.from(context);
    }

    //the nb of item stories that is appeared in the Listview
    @Override
    public int getCount() {
        return storyData.size();
    }

    @Override
    public ItemStory getItem(int position) {
        return storyData.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.activity_item_story, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.nameStory);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.imgStory);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ItemStory itemStory = (ItemStory)storyData.get(position);
        viewHolder.tvTitle.setText(itemStory.getTitleName());
        showImage(viewHolder.img);
        return convertView;
    }

    private class ViewHolder{
        TextView tvTitle;
        ImageView img;
    }

    private void showImage(ImageView img) {
        AssetManager assetManager = context.getAssets();
        try {
            InputStream input = assetManager.open("img/bovaruou.jpg");
            BitmapFactory.decodeStream(input);
            Bitmap src = BitmapFactory.decodeStream(input);
            img.setImageBitmap(src);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
