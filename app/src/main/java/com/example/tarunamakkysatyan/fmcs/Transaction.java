package com.example.tarunamakkysatyan.fmcs;

import java.util.Date;

public class Transaction {
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
}
