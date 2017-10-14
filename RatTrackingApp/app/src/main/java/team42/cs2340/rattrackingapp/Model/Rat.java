package team42.cs2340.rattrackingapp.Model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

import java.util.Arrays;

/**
 * Created by Beatrice on 10/14/17.
 */

public class Rat implements Parcelable {
    private String uniqueKey = "12345";
    private String city;


    public Rat(String city) {
        this.city = city;
    }

    private Rat(Parcel in) {
        city = in.readString();
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
    }

    public static final Parcelable.Creator<Rat> CREATOR
            = new Parcelable.Creator<Rat>() {
        public Rat createFromParcel(Parcel in) {
            return new Rat(in);
        }

        public Rat[] newArray(int size) {
            return new Rat[size];
        }
    };

//    public String toCsvRow() {
//        String csvRow = "";
//        for (String value : Arrays.asList(uniqueKey, city)) {
//            String processed = value;
//            if (value.contains("\"") || value.contains(",")) {
//                processed = "\"" + value.replaceAll("\"", "\"\"") + "\"";
//            }
//            csvRow += "," + processed;
//        }
//        return csvRow.substring(1);
//    }
}
