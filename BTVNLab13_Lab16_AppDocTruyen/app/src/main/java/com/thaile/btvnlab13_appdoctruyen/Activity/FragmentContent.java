package com.thaile.btvnlab13_appdoctruyen.Activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.thaile.btvnlab13_appdoctruyen.Adapter.ViewPagerAdapter;
import com.thaile.btvnlab13_appdoctruyen.R;

/**
 * Created by Le on 7/28/2016.
 */
public class FragmentContent extends Fragment {

    private TextView title;
    private TextView content;
    private Animation anim, anim2;
    private View rootView;
    private Context context;
    private DBManager dbManager;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity.getApplicationContext();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_content, container, false);
        anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
        anim2 = AnimationUtils.loadAnimation(context, R.anim.alpha_anim);

        int posItem = ViewPagerAdapter.posItem;
        int posArray = FragmentHome.pos;
        dbManager = new DBManager(context);


        title = (TextView) rootView.findViewById(R.id.tv_name);
        content = (TextView) rootView.findViewById(R.id.tv_content);


        Typeface face = Typeface.createFromAsset(getActivity().getAssets(), "fonts/sty.ttf");
        title.setTypeface(face);
        content.setTypeface(face);
        title.setAnimation(anim);
        content.setAnimation(anim2);
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

}
