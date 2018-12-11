package com.example.tarunamakkysatyan.fmcs;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Transaction implements Parcelable{
    String name, category,date, hour;
    boolean expenses;
    int money;

    public Transaction(String name, String category, String date, String hour, boolean expenses, int money) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.hour = hour;
        this.expenses = expenses;
        this.money = money;
    }


    protected Transaction(Parcel in) {
        name = in.readString();
        category = in.readString();
        date = in.readString();
        hour = in.readString();
        expenses = in.readByte() != 0;
        money = in.readInt();
    }

    public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
        @Override
        public Transaction createFromParcel(Parcel in) {
            return new Transaction(in);
        }

        @Override
        public Transaction[] newArray(int size) {
            return new Transaction[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(category);
        parcel.writeString(date);
        parcel.writeString(hour);
        parcel.writeByte((byte) (expenses ? 1 : 0));
        parcel.writeInt(money);
    }
}
