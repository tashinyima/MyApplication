package com.example.tsephel_treps.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Adapter adapter;
    ArrayList<Model> models = new ArrayList<>();
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(context);
        adapter = new Adapter(models,context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        FetchData();
    }


    private void FetchData() {

        Model model = new Model("first titlte","First Description ",1);
        models.add(model);
        model = new Model("Second title","Second Description",2);
        models.add(model);
        model = new Model("Third Title","Third Description",3);
        models.add(model);
        model = new Model("Fourth title","Fourth Description",4);
        models.add(model);
        model = new Model("Fifth Title","Fifth Description",5);
        models.add(model);
        adapter.notifyDataSetChanged();
    }
}
