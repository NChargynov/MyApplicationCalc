package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    Button addition, substraction, nextActivity;
    TextView textView;
    static final String TEXT_KEY = "key";
    ArrayList<Integer> numbersList = new ArrayList<>();
    ArrayList<String> operationsList = new ArrayList<>();
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        addition = findViewById(R.id.btn_addition3);
        substraction = findViewById(R.id.btn_subtraction3);
        nextActivity = findViewById(R.id.btn_next_activity3);
        textView = findViewById(R.id.resultTV3);

        Intent intent = getIntent();
        if (intent != null){
            String text = intent.getStringExtra(TEXT_KEY);
            textView.setText(text);
        }

        ArrayList<Integer> numbersList2 = intent.getIntegerArrayListExtra("numbersList");
        ArrayList<String> operationsList2 = intent.getStringArrayListExtra("operationsList");

        if (numbersList2 != null) {
            numbersList = numbersList2;
        }

        if (operationsList2 != null) {
            operationsList = operationsList2;
        }

        textView.setText(PrettyResult.convert(numbersList, operationsList));

    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_addition3:
                operation = "+";
                setTextView3();
                break;
            case R.id.btn_subtraction3:
                operation = "-";
                setTextView3();
                break;
        }
    }

    public void onStartSecondActivityClick(View v){
        operationsList.add(operation);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("numbersList", numbersList);
        intent.putExtra("operationsList", operationsList);
        startActivity(intent);
    }

    public void setTextView3(){
        textView.append(operation);
    }
}
