package com.example.myapplication;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView1, textView2;
    Button calculator1, calculator2, share, changeFragmentsbtn;
    static private final int ID_FOR_SECOND = 1;
    static private final String KEY_FOR_MAIN_LAUNCHER = "KEY_FOR_MAIN_LAUNCHER";
    static final String TEXT_KEY = "key";
    RecyclerFragments recyclerFragments;
    boolean isButtonFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.text_view1);
        calculator1 = findViewById(R.id.btn_calculator1);
        calculator2 = findViewById(R.id.btn_calculator2);
        share = findViewById(R.id.btn_share);
        changeFragmentsbtn = findViewById(R.id.btn_change_fragments);
        textView2 = findViewById(R.id.resultTV_for_fragments);


        Intent intent = getIntent();
        if (intent != null) {
            ArrayList<Integer> numbersList = intent.getIntegerArrayListExtra("numbersList");
            ArrayList<String> operationsList = intent.getStringArrayListExtra("operationsList");

            if (numbersList != null) {
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

        recyclerFragments = new RecyclerFragments();
        changeFragment(recyclerFragments);
        isButtonFragment = true;
    }

    public void onStartSecondActivityClick(View v) {
        String text = textView1.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MainActivity.TEXT_KEY, text);
        startActivity(intent);
    }

    public void onOpenFirstCalculator(View v) {
        Intent intent = new Intent(this, FirstCalculator.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ID_FOR_SECOND && resultCode == RESULT_OK) {
            String s = data.getStringExtra(KEY_FOR_MAIN_LAUNCHER);
            textView1.setText(s);
        } else {
        }
    }

    public void onClickShare(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, textView1.getText());
        intent.setType("text/plain");
        startActivity(intent);
    }

    public void onClickFragments(View view) {
        if (isButtonFragment) {
            changeFragment(new BlankFragment());
            isButtonFragment = false;
        } else {
            changeFragment(recyclerFragments);
            isButtonFragment = true;
        }
    }

    public void inputText(String s) {
        recyclerFragments.addResult(s);
    }

    public void changeFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}
