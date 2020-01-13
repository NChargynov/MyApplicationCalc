package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityLauncher extends AppCompatActivity {

    TextView textView1;
    Button calculator1, calculator2, share;
    static private final int ID_FOR_SECOND = 1;
    static private final String KEY_FOR_MAIN_LAUNCHER = "KEY_FOR_MAIN_LAUNCHER";
    static final String TEXT_KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_launcher);

        textView1 = findViewById(R.id.text_view1);
        calculator1 = findViewById(R.id.btn_calculator1);
        calculator2 = findViewById(R.id.btn_calculator2);
        share = findViewById(R.id.btn_share);
        

        Intent intent = getIntent();
        if (intent != null) {
            ArrayList<Integer> numbersList = intent.getIntegerArrayListExtra("numbersList");
            ArrayList<String> operationsList = intent.getStringArrayListExtra("operationsList");

            if(numbersList != null) {
                Integer result = numbersList.get(0);
                for (int i = 0; i < numbersList.size() - 1; i++) {

                    switch (operationsList.get(i)) {
                        case "+":
                            result += numbersList.get(i + 1);
                            break;
                        case "-":
                            result -= numbersList.get(i + 1);
                            break;
                    }
                }
                textView1.setText(PrettyResult.convert(numbersList, operationsList) + "=" + result.toString());
            }
        } else {

        }
    }

    public void onStartSecondActivityClick(View v){
        String text = textView1.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MainActivityLauncher.TEXT_KEY, text);
        startActivity(intent);
    }

    public void onOpenMainActivity(View v){
        Intent intent = new Intent(this , MainActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ID_FOR_SECOND && resultCode == RESULT_OK){
            String s = data.getStringExtra(KEY_FOR_MAIN_LAUNCHER);
            textView1.setText(s);
        } else {
        }
    }

    public void onClickShare(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, textView1.getText());
        intent.setType("text/plain");
        startActivity(intent);
    }
}
