package com.example.tsephel_treps.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tsephel_Treps on 1/1/2018.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Model> models;
    Context context;
    public Adapter(ArrayList<Model> models, Context context)
    {
        this.models= models;
        this.context = context;

    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{

        TextView title;

        public CustomViewHolder(View itemview){
            super(itemview);
            title = (TextView) itemview.findViewById(R.id.textView);


        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Model mod = models.get(position);

        if(holder instanceof CustomViewHolder){

            ((CustomViewHolder) holder).title.setText(mod.title);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Model model = new Model();
                    Intent intent = new Intent(context,detailActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("datas",mod);
                    intent.putExtra("parcemodel",model);
                    context.startActivity(intent);
                }
            });
        }



    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
