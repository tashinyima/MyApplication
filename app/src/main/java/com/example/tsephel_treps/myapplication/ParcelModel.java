package com.example.tsephel_treps.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tsephel_Treps on 1/2/2018.
 */

public class ParcelModel extends Model implements Parcelable {

    public ParcelModel(Parcel in) {
        super(in.readString(),in.readString(),in.readInt());


    }

    public ParcelModel(String title,String des,int id){
        super(title,des,id);
    }

    public static final Creator<ParcelModel> CREATOR = new Creator<ParcelModel>() {
        @Override
        public ParcelModel createFromParcel(Parcel in) {
            return new ParcelModel(in);
        }

        @Override
        public ParcelModel[] newArray(int size) {
            return new ParcelModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getDescription());
        dest.writeString(getTitle());
        dest.writeInt(getId());
    }
}
