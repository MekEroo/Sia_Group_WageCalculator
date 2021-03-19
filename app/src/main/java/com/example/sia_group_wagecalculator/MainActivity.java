package com.example.sia_group_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculate;

        calculate = findViewById(R.id.btnCalculate);

        calculate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        EditText workHours;
        TextView result, result2;


        workHours = findViewById(R.id.totalWorkHrsTxt);
        result = findViewById(R.id.resultTxt);
        result2 = findViewById(R.id.resultTxt2);

        double inputHours = 0;
        double regularWage = 150;
        double overtimeWage = 175;
        double standardHours = 8;
        double overtimeHours = 0;
        double totalHours = 0;
        double totalOvertimeWage = 0;
        double totalWage = 0;


        inputHours = Double.parseDouble((workHours.getText().toString()));

        switch (v.getId()) {
            case R.id.btnCalculate:
                if (inputHours > 8) {
                    overtimeHours = inputHours - standardHours;
                    totalHours = standardHours + overtimeHours;
                    totalWage = (standardHours * regularWage) + (overtimeHours * overtimeWage);
                    totalOvertimeWage = overtimeHours * overtimeWage;

                    result.setText("Your Total Salary is " + "$" + String.valueOf(totalWage) + "\n after" + String.valueOf(totalHours) + " Hours of work.");
                    result2.setText("You have accumulated " + "$" + String.valueOf(totalOvertimeWage) + "\n after " + String.valueOf(overtimeHours) + " Hours in overtime");
                } else {
                    totalWage = inputHours * regularWage;
                    result.setText("Your Total Salary is" + "$" + String.valueOf(totalWage) + " after" + String.valueOf(inputHours) + " Hours of work.");
                    result2.setText(" ");


                }
        }
    }
}