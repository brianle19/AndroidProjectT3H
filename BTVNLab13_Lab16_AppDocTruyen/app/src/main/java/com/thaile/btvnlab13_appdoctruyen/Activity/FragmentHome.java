package com.thaile.btvnlab13_appdoctruyen.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.thaile.btvnlab13_appdoctruyen.Adapter.StoryMenuBarAdapter;
import com.thaile.btvnlab13_appdoctruyen.Adapter.ViewPagerAdapter;
import com.thaile.btvnlab13_appdoctruyen.Adapter.ZoomOutPageTransformer;
import com.thaile.btvnlab13_appdoctruyen.R;

/**
 * Created by Le on 7/28/2016.
 */
public class FragmentHome extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener, DrawerLayout.DrawerListener, AdapterView.OnItemClickListener, ViewPagerAdapter.CallFragmentContent {
    private View rootView;
    private TabLayout tabs;
    public static int pos;
    private DrawerLayout drawerLayout;
    private ViewPager vPager;
    private ImageView img_menu;
    private ListView listDrawer;
    private ViewPagerAdapter viewAdapter;
    private Context context;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //Use the following code to get the context in Fragment
        context = activity.getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        tabs = (TabLayout)rootView.findViewById(R.id.tabs) ;
        vPager = (ViewPager)rootView.findViewById(R.id.pager);
        img_menu = (ImageView) rootView.findViewById(R.id.iv_menu);
        img_menu.setOnClickListener(this);
        drawerLayout = (DrawerLayout) rootView.findViewById(R.id.drawer);
        viewAdapter = new ViewPagerAdapter(context);
        viewAdapter.setShowContent(this);
        vPager.setAdapter(viewAdapter);
        vPager.setPageTransformer(true, new ZoomOutPageTransformer());
        tabs.setupWithViewPager(vPager);
        vPager.setOnPageChangeListener(this);

        StoryMenuBarAdapter storyMenuBarAdapter = new StoryMenuBarAdapter(context);
        listDrawer = (ListView) rootView.findViewById(R.id.lv_nav);
        listDrawer.setAdapter(storyMenuBarAdapter);
        listDrawer.setOnItemClickListener(this);
        drawerLayout.setDrawerListener(this);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onClick(View v) {
        drawerLayout.openDrawer(Gravity.LEFT);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        pos = position;

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawerLayout.closeDrawers();
                TabLayout.Tab tab = tabs.getTabAt(position);
                tab.select();
    }

    @Override
    public void showContent() {
        ((MainActivity)getActivity()).showContent();
    }

}
