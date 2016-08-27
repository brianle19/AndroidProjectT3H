package com.thaile.btvnlab13_appdoctruyen.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.thaile.btvnlab13_appdoctruyen.Activity.DBManager;
import com.thaile.btvnlab13_appdoctruyen.Item.ItemData;
import com.thaile.btvnlab13_appdoctruyen.Item.ItemStory;
import com.thaile.btvnlab13_appdoctruyen.R;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter implements AdapterView.OnItemClickListener {
    private View view;
    public  GridView gridView;
    private Context context;
    private LayoutInflater layoutInflater;
    private StoryAdapter storyAdapter;
    public static int posItem;
    private DBManager dbManager;
    private ArrayList<ItemStory> itemStories;
    private ArrayList<ItemData> mDataArrayList;
    private CallFragmentContent callFragmentContent;

    public ViewPagerAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        dbManager = new DBManager(context);
        mDataArrayList=dbManager.getStory();
    }

    @Override
    public int getCount() {
        return mDataArrayList.size();
    }

    //hien title cua story
    @Override
    public CharSequence getPageTitle(int position) {
        return  mDataArrayList.get(position).getNameData();
    }

    @Override
    public boolean isViewFromObject(View view, Object nextObject) {
        return view.equals(nextObject);
    }

    @Override
    public Object instantiateItem(ViewGroup viewPager, int position) {
        view = layoutInflater.inflate(R.layout.activity_gridview_item, viewPager, false);
        gridView = (GridView) view.findViewById(R.id.gridView);
//        itemStories = new ArrayList<>();
        ItemData itemData = getItem(position);
        storyAdapter = new StoryAdapter(itemData.getData(), context);
        gridView.setAdapter(storyAdapter);
        gridView.setOnItemClickListener(this);
        viewPager.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup viewPager, int position, Object oldView) {
        viewPager.removeView((View) oldView);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        posItem = (int) parent.getItemIdAtPosition(position);
        if(callFragmentContent != null){
            callFragmentContent.showContent();
        }
    }
    private ItemData getItem(int position){
        return mDataArrayList.get(position);
    }
    public void setShowContent(CallFragmentContent callFragmentContent){

        this.callFragmentContent = callFragmentContent;
    }


    public interface CallFragmentContent {
        public void showContent();
    }
}
