package com.example.tsephel_treps.myapplication;


import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
public class detailActivity extends AppCompatActivity {
    ArrayList<Model> list = new ArrayList<>();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.context = getApplicationContext();
        getModel();
        try {

            Model model = (Model) getIntent().getParcelableExtra("parcemodel");
            list = getIntent().getParcelableArrayListExtra("parcemodel");

            Log.d("List", String.valueOf(list.size()));

            int selecteditemid = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).id == model.id) {
                    selecteditemid = i;
                    break;
                }
            }

            ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
            PagerAdapter pagerAdapter = new PagerAdapter(context, list);
            viewPager.setAdapter(pagerAdapter);
            viewPager.setCurrentItem(selecteditemid);
            viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
                @Override
                public void transformPage(View page, float position) {
                    page.setRotation(position * -30);
                }
            });

        } catch (Exception ex) {

            ex.fillInStackTrace();

        }

    }

    private void getModel() {
    }

}
