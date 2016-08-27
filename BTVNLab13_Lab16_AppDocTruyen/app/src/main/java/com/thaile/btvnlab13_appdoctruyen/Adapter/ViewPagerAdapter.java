package com.thaile.btvnlab13_appdoctruyen.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.thaile.btvnlab13_appdoctruyen.Activity.DBManager;
import com.thaile.btvnlab13_appdoctruyen.R;
/**
 * Created by Le on 7/20/2016.
 */
public class ViewPagerAdapter extends PagerAdapter implements AdapterView.OnItemClickListener {
    private View view;
    public  GridView gridView;
    private Context context;
    private LayoutInflater layoutInflater;
    private StoryAdapter storyAdapter;
    public static int posItem;
    private DBManager dbManager;
    private CallFragmentContent callFragmentContent;

    public ViewPagerAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        dbManager = new DBManager(context);
    }

    @Override
    public int getCount() {
        return dbManager.getStoryVietTopic().size();
    }

    //hien title cua story
    @Override
    public CharSequence getPageTitle(int position) {
        return  dbManager.getStoryVietTopic().get(position).toString();
    }

    @Override
    public boolean isViewFromObject(View view, Object nextObject) {
        return view.equals(nextObject);
    }

    @Override
    public Object instantiateItem(ViewGroup viewPager, int position) {
        view = layoutInflater.inflate(R.layout.activity_gridview_item, viewPager, false);
        gridView = (GridView) view.findViewById(R.id.gridView);
        storyAdapter = new StoryAdapter(dbManager.getStory().get(dbManager.getStoryVietTopic().get(position)),context);
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

    public void setShowContent(CallFragmentContent callFragmentContent){

        this.callFragmentContent = callFragmentContent;
    }


    public interface CallFragmentContent {
        public void showContent();
    }
}
