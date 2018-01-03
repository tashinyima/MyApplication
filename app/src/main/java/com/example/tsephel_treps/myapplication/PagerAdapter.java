package com.example.tsephel_treps.myapplication;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tsephel_Treps on 1/2/2018.
 */

public class PagerAdapter extends android.support.v4.view.PagerAdapter {
    private ArrayList<Model> modelslist;
    private Model model;
    private Context context;
    LayoutInflater inflater;
    TextView titletv,desctv;

    public PagerAdapter(Context context,ArrayList<Model> models)
    {
        this.modelslist = models;
        this.context = context;
    }
    @Override
    public int getCount() {
        return modelslist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(object);
    }
    public Object instantiateItem(ViewGroup container,int position){

        model = modelslist.get(position);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview = inflater.inflate(R.layout.fragment_detail,container,false);
        titletv = (TextView) itemview.findViewById(R.id.texttitle);
        desctv = (TextView) itemview.findViewById(R.id.textdes);
        titletv.setText(model.getTitle());
        desctv.setText(model.getDescription());
        ((ViewPager) container).addView(itemview);
        return itemview;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}
