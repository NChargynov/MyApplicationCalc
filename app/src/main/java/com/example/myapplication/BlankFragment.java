package com.example.myapplication;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    Button zero, one, two, three, four, five, six, seven, eight, nine, subtraction, addition,
            divide, multiply, equal, dot, clear;

    TextView textView;

    String rawOperand = "";
    Double firstOperand;
    Double secondOperand;
    String operation;
    Double result;




    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.resultTV_for_fragments);
        zero = view.findViewById(R.id.btn_zero);
        two = view.findViewById(R.id.btn_two);
        one = view.findViewById(R.id.btn_one);
        three = view.findViewById(R.id.btn_three);
        four = view.findViewById(R.id.btn_four);
        five = view.findViewById(R.id.btn_five);
        six = view.findViewById(R.id.btn_six);
        seven = view.findViewById(R.id.btn_seven);
        eight = view.findViewById(R.id.btn_eight);
        nine = view.findViewById(R.id.btn_nine);
        subtraction = view.findViewById(R.id.btn_subtraction);
        addition = view.findViewById(R.id.btn_addition);
        divide = view.findViewById(R.id.btn_divide);
        multiply = view.findViewById(R.id.btn_multiply);
        equal = view.findViewById(R.id.btn_equal);
        dot = view.findViewById(R.id.btn_dot);
        clear = view.findViewById(R.id.btn_clear);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClickF(zero);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClickF(one);

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClickF(two);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClickF(three);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClickF(four);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClickF(five);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClickF(six);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClickF(seven);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClickF(eight);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClickF(nine);
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClickF(dot);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClickF(clear);
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperationClickF(subtraction);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperationClickF(divide);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperationClickF(multiply);
            }
        });


        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperationClickF(addition);
            }
        });


        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperationClickF(equal);
            }
        });

    }

    public void onNumberClickF(View v) {
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
            case R.id.btn_dot:
                enterNumber(".");
                break;
            case R.id.btn_clear:
                textView.setText("");
                rawOperand = "";
                firstOperand = null;
                secondOperand = null;
                break;
            default:
                break;

        }
    }

    public void enterNumber(String number) {
        textView.append(number);
        rawOperand += number;
    }

    public void onOperationClickF(View v) {
        try {
            if (firstOperand == null) {
                firstOperand = Double.parseDouble(rawOperand);
            } else {
                secondOperand = Double.parseDouble(rawOperand);
            }
            rawOperand = "";
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (v.getId()) {
            case R.id.btn_addition:
                enterOperation("+");
                break;
            case R.id.btn_multiply:
                enterOperation("*");
                break;
            case R.id.btn_divide:
                enterOperation("/");
                break;
            case R.id.btn_subtraction:
                enterOperation("-");
                break;
            case R.id.btn_equal:
                if (operation != null) {
                    switch (operation) {
                        case "+":
                            result = firstOperand + secondOperand;
                            textView.append("=" + result);
                            getValueForArrayList(firstOperand.toString() + " + " + secondOperand.toString()+ " = " + result.toString());
                            break;
                        case "*":
                            result = firstOperand * secondOperand;
                            textView.append("=" + result);
                            getValueForArrayList(firstOperand.toString() + " * " + secondOperand.toString()+ " = " + result.toString());
                            break;
                        case "/":
                            result = firstOperand / secondOperand;
                            textView.append("=" + result);
                            getValueForArrayList(firstOperand.toString() + " / " + secondOperand.toString()+ " = " + result.toString());
                            break;
                        case "-":
                            result = firstOperand - secondOperand;
                            textView.append("=" + result);
                            getValueForArrayList(firstOperand.toString() + " - " + secondOperand.toString()+ " = " + result.toString());
                            break;
                        default:
                            break;
                    }
                }
            default:
                break;
        }

    }

    public void enterOperation(String operation) {
        textView.append(operation);
        this.operation = operation;
    }


    public void getValueForArrayList(String value){
        MainActivity activity = (MainActivity) getActivity();
        activity.inputText(value);
    }
}
