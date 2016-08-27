package com.thaile.btvnlab13_appdoctruyen.Activity;

import android.app.Activity;
import android.os.Bundle;

import com.thaile.btvnlab13_appdoctruyen.Adapter.ViewPagerAdapter.CallFragmentContent;
import com.thaile.btvnlab13_appdoctruyen.R;

public class MainActivity extends Activity implements CallFragmentContent {
    private FragmentHome fragmentHome;
    private FragmentContent fragmentContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        fragmentHome = new FragmentHome();
        fragmentContent = new FragmentContent();
        showHome();
    }


    private void showHome() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.mainscreen, fragmentHome)
                .commit();
    }

    @Override
    public void showContent() {
        getFragmentManager()
                .beginTransaction()
                .add(R.id.mainscreen, fragmentContent)
                .hide(fragmentHome)
                .addToBackStack("Hello")
                .commit();
    }
}
