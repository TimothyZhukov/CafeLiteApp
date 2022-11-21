package com.zhukov.cafelite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPassword;
    private Button buttonSingIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buttonSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                if (name.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            R.string.error_fields_empty,
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    launchNextScreen(name);
                }
            }
        });
    }

    private void launchNextScreen(String name) {
        Intent intent = MakeOrderActivity.newIntent(this, name);
        startActivity(intent);
    }

    private void initViews() {
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSingIn = findViewById(R.id.buttonSingIn);
    }
}