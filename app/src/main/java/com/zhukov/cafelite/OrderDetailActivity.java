package com.zhukov.cafelite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class OrderDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
    }

    public static Intent newIntent(Context context, String name, String drink, String drinkType, String additives) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("drink", drink);
        intent.putExtra("drinkType", drinkType);
        intent.putExtra("additives", additives);
        return intent;
    }
}