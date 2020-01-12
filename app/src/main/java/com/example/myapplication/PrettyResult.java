package com.example.myapplication;

import java.util.ArrayList;

public class PrettyResult {

    static public String convert(ArrayList<Integer> numbersList, ArrayList<String> operationsList) {

        String result = "";
        for (int i = 0; i < numbersList.size(); i++) {
            result += numbersList.get(i);
            if (i < operationsList.size()) {
                result += operationsList.get(i);
            }
        }
        return result;
    }
}
