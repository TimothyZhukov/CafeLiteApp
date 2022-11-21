package com.zhukov.cafelite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MakeOrderActivity extends AppCompatActivity {

    private static final String EXTRA_NAME = "name";

    RadioButton radioButtonTea;
    RadioButton radioButtonCoffee;
    RadioGroup radioGroupDrinks;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        initViews();
        setGreetings();

        radioGroupDrinks.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radioButtonTea.getId()) {
                    chooseTea();
                } else if (checkedId == radioButtonCoffee.getId()) {
                    chooseCoffee();
                }
            }
        });

        radioButtonTea.setChecked(true);

        buttonMakeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeOrder();
            }
        });
    }

    public static Intent newIntent(Context context, String name) {
        Intent intent = new Intent(context, MakeOrderActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        return intent;
    }

    private void initViews() {
        textViewGreetings = findViewById(R.id.textViewGreetings);
        textViewAdditives = findViewById(R.id.textViewAdditives);
        radioButtonTea = findViewById(R.id.radioButtonTea);
        radioButtonCoffee = findViewById(R.id.radioButtonCoffee);
        radioGroupDrinks = findViewById(R.id.radioGroupDrinks);
        checkBoxSugar = findViewById(R.id.checkBoxSugar);
        checkBoxMilk = findViewById(R.id.checkBoxMilk);
        checkBoxLemon = findViewById(R.id.checkBoxLemon);
        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);
        buttonMakeOrder = findViewById(R.id.buttonMakeOrder);
    }

    private void setGreetings() {
        Intent intent = getIntent();
        name = intent.getStringExtra(EXTRA_NAME);
        String greetings = getString(R.string.greetings, name);
        textViewGreetings.setText(greetings);
    }

    private void setNameOfDrink(String drinkName) {
        textViewAdditives.setText(getString(R.string.additives, drinkName));
    }

    private void chooseTea() {
        drink = getString(R.string.tea);
        setNameOfDrink(drink);
        spinnerTea.setVisibility(View.VISIBLE);
        spinnerCoffee.setVisibility(View.INVISIBLE);
        checkBoxLemon.setVisibility(View.VISIBLE);
    }

    private void chooseCoffee() {
        drink = getString(R.string.coffee);
        setNameOfDrink(drink);
        spinnerCoffee.setVisibility(View.VISIBLE);
        spinnerTea.setVisibility(View.INVISIBLE);
        checkBoxLemon.setVisibility(View.INVISIBLE);
    }

    private void launchNextScreen(String name, String drink, String drinkType, String additives) {
        Intent intent = OrderDetailActivity.newIntent(this,
                name,
                drink,
                drinkType,
                additives);
        startActivity(intent);
    }

    private void makeOrder() {
        ArrayList<String> additives = new ArrayList<>();
        if (checkBoxSugar.isChecked()) {
            additives.add(checkBoxSugar.getText().toString());
        }
        if (checkBoxMilk.isChecked()) {
            additives.add(checkBoxMilk.getText().toString());
        }
        if (radioButtonTea.isChecked() && checkBoxLemon.isChecked()) {
            additives.add(checkBoxLemon.getText().toString());
        }
        String drinkType = "";
        if (radioButtonTea.isChecked()) {
            drinkType = spinnerTea.getSelectedItem().toString();
        }
        if (radioButtonCoffee.isChecked()) {
            drinkType = spinnerCoffee.getSelectedItem().toString();
        }
        launchNextScreen(name, drink, drinkType, additives.toString());
    }

}