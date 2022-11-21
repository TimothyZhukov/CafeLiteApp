package com.zhukov.cafelite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MakeOrderActivity extends AppCompatActivity {

    RadioButton radioButtonTea;
    RadioButton radioButtonCoffee;
    CheckBox checkBoxSugar;
    CheckBox checkBoxMilk;
    CheckBox checkBoxLemon;
    TextView textViewGreetings;
    TextView textViewAdditives;
    Spinner spinnerTea;
    Spinner spinnerCoffee;
    Button buttonMakeOrder;
    String name;
    String drink;
    String drinkType;
    String additives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        initViews();
        setGreetings();
        chooseTea();
        radioButtonTea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseTea();
            }
        });
        radioButtonCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseCoffee();
            }
        });
        buttonMakeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public static Intent newIntent(Context context, String name) {
        Intent intent = new Intent(context, MakeOrderActivity.class);
        intent.putExtra("name", name);
        return intent;
    }

    private void initViews() {
        textViewGreetings = findViewById(R.id.textViewGreetings);
        textViewAdditives = findViewById(R.id.textViewAdditives);
        radioButtonTea = findViewById(R.id.radioButtonTea);
        radioButtonCoffee = findViewById(R.id.radioButtonCoffee);
        checkBoxSugar = findViewById(R.id.checkBoxSugar);
        checkBoxMilk = findViewById(R.id.checkBoxMilk);
        checkBoxLemon = findViewById(R.id.checkBoxLemon);
        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);
        buttonMakeOrder = findViewById(R.id.buttonMakeOrder);
    }

    private void setGreetings() {
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        String textWithoutName = textViewGreetings.getText().toString();
        textViewGreetings.setText(String.format(textWithoutName, name));
    }

    private void setNameOfDrink(String drinkName) {
        String textWithoutDrinkName = textViewAdditives.getText().toString();
        textViewAdditives.setText(String.format(textWithoutDrinkName, drinkName));
    }

    private void chooseTea() {
        spinnerTea.setVisibility(View.VISIBLE);
        spinnerCoffee.setVisibility(View.INVISIBLE);
        checkBoxLemon.setVisibility(View.VISIBLE);
        setNameOfDrink(getString(R.string.tea));
    }

    private void chooseCoffee() {
        spinnerCoffee.setVisibility(View.VISIBLE);
        spinnerTea.setVisibility(View.INVISIBLE);
        checkBoxLemon.setVisibility(View.INVISIBLE);
        setNameOfDrink(getString(R.string.coffee));
    }

    private void launchNextScreen(String name, String drink, String drinkType, String additives) {
        Intent intent = OrderDetailActivity.newIntent(this, name, drink, drinkType, additives);
    }


}