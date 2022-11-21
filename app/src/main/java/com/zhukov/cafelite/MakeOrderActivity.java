package com.zhukov.cafelite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MakeOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        TextView textViewGreetings = findViewById(R.id.textViewGreetings);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        textViewGreetings.setText(String.format(textViewGreetings.getText().toString(), name));
    }

    public static Intent newIntent(Context context, String name) {
        Intent intent = new Intent(context, MakeOrderActivity.class);
        intent.putExtra("name", name);
        return intent;
    }
}