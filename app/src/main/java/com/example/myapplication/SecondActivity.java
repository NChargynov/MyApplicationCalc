package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    static final String TEXT_KEY = "key";
    TextView textView2;
    Button zero, one, two, three, four, five, six, seven, eight, nine, equal, dot;
    ArrayList<Integer> numbersList = new ArrayList<>();
    ArrayList<String> operationsList = new ArrayList<>();
    String numbers = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView2 = findViewById(R.id.resultTV2);

        Intent intent = getIntent();
        if (intent != null) {
            String text = intent.getStringExtra(TEXT_KEY);
            textView2.setText(text);
        }

        ArrayList<Integer> numbersList2 = intent.getIntegerArrayListExtra("numbersList");
        ArrayList<String> operationsList2 = intent.getStringArrayListExtra("operationsList");

        if (numbersList2 != null) {
            numbersList = numbersList2;
        }

        if (operationsList2 != null) {
            operationsList = operationsList2;
        }

        zero = findViewById(R.id.btn_zero);
        one = findViewById(R.id.btn_one);
        two = findViewById(R.id.btn_two);
        three = findViewById(R.id.btn_three);
        four = findViewById(R.id.btn_four);
        five = findViewById(R.id.btn_five);
        six = findViewById(R.id.btn_six);
        seven = findViewById(R.id.btn_seven);
        eight = findViewById(R.id.btn_eight);
        nine = findViewById(R.id.btn_nine);
        equal = findViewById(R.id.btn_equal3);
        dot = findViewById(R.id.btn_dot);

        textView2.setText(PrettyResult.convert(numbersList, operationsList));
    }

    public void onNumberClick(View v) {
        switch (v.getId()) {
            case R.id.btn_zero:
                enterNumber("0");
                break;
            case R.id.btn_one:
                enterNumber("1");
                break;
            case R.id.btn_two:
                enterNumber("2");
                break;
            case R.id.btn_three:
                enterNumber("3");
                break;
            case R.id.btn_four:
                enterNumber("4");
                break;
            case R.id.btn_five:
                enterNumber("5");
                break;
            case R.id.btn_six:
                enterNumber("6");
                break;
            case R.id.btn_seven:
                enterNumber("7");
                break;
            case R.id.btn_eight:
                enterNumber("8");
                break;
            case R.id.btn_nine:
                enterNumber("9");
                break;
            case R.id.btn_clear:
                textView2.setText("");
                break;

        }
    }

    public void onStartThirdActivityClick(View v){
        numbersList.add(Integer.valueOf(numbers));
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("numbersList", numbersList);
        intent.putExtra("operationsList", operationsList);
        startActivity(intent);
    }

    public void onClickEqual(View view){
        numbersList.add(Integer.valueOf(numbers));
        Intent intent = new Intent(this, MainActivityLauncher.class);
        intent.putExtra("numbersList", numbersList);
        intent.putExtra("operationsList", operationsList);
        startActivity(intent);
    }

    public void enterNumber(String number) {
        textView2.append(number);
        numbers += number;
    }
}
