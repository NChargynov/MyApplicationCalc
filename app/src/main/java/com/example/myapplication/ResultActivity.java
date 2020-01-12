package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = findViewById(R.id.text_view_result);

        Intent intent = getIntent();
        ArrayList<Integer> numbersList = intent.getIntegerArrayListExtra("numbersList");
        ArrayList<String> operationsList = intent.getStringArrayListExtra("operationsList");

        Integer result = numbersList.get(0);
        for (int i = 0; i < numbersList.size() - 1; i++) {

            switch (operationsList.get(i)){
                case "+":
                    result += numbersList.get(i + 1);
                    break;
                case "-":
                    result -= numbersList.get(i + 1);
                    break;
            }
        }
        textView.setText(PrettyResult.convert(numbersList, operationsList) + " = " + result.toString());
    }
}
