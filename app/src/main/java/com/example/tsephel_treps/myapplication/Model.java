package com.example.tsephel_treps.myapplication;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.Display;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tsephel_Treps on 1/1/2018.
 */

public class Model implements Parcelable {
    String title,description;
    int id;
 public Model()
 {

 }
    public Model(String title,String description,int id){

        this.title=title;
        this.description = description;
        this.id=id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Model(Parcel in) {
        title = in.readString();
        description = in.readString();
        id = in.readInt();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(id);
    }
}
