package com.example.logbookcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView labelResult, txtResult;


    private TextView finalResult;
    private TextView dynamicResult;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    private Button btnClear, btnEquals;
    private EditText resultDisplay;

    private String operator;
    double firstNum;

    double firstNumDynamic;
    String operation;

    private boolean operatorClicked = false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        // Initialize other buttons
        btnAdd = findViewById(R.id.btnPlus);
        btnSubtract = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        // results
        dynamicResult = findViewById(R.id.dynamicResult);
        resultDisplay = findViewById(R.id.resultDisplay);
        finalResult = findViewById(R.id.finalResult);


        btnClear = findViewById(R.id.btnDelete);
        btnEquals = findViewById(R.id.btnEquals);


        ArrayList<Button> nums = new ArrayList<>();
        nums.add(btn0);
        nums.add(btn1);
        nums.add(btn2);
        nums.add(btn3);
        nums.add(btn4);
        nums.add(btn5);
        nums.add(btn6);
        nums.add(btn7);
        nums.add(btn8);
        nums.add(btn9);

        for (Button b : nums) {
            b.setOnClickListener(view -> {
                if (operatorClicked) {
                    // Append the number to the resultDisplay without clearing it
                    resultDisplay.append(b.getText().toString());
                    dynamicResult.setText(dynamicResult.getText().toString() + b.getText().toString());
                } else {
                    // Replace the text in resultDisplay with the number
                    resultDisplay.setText(b.getText().toString());
                    dynamicResult.setText(b.getText().toString());
                }
                operatorClicked = false; // Reset the operatorClicked flag
            });
        }

        ArrayList<Button> operators = new ArrayList<>();
        operators.add(btnAdd);
        operators.add(btnSubtract);
        operators.add(btnMultiply);
        operators.add(btnDivide);

        for (Button b : operators) {
            b.setOnClickListener(view -> {
                firstNum = Double.parseDouble(resultDisplay.getText().toString());
                firstNumDynamic = Double.parseDouble(dynamicResult.getText().toString());
                operation = b.getText().toString();

                // Append the operator to the resultDisplay
                resultDisplay.append(operation);
                dynamicResult.setText("0");
                operatorClicked = true; // Set the operatorClicked flag to true
            });
        }


        btnClear.setOnClickListener(view -> {
            firstNum= 0;
            firstNumDynamic = 0;
            resultDisplay.setText("0");
            dynamicResult.setText("0");
            finalResult.setText("0");
        });

        btnEquals.setOnClickListener(view -> {
            double secondNumDynamic = Double.parseDouble(dynamicResult.getText().toString());
            double result;

            switch (operation) {
                case "+":
                    result = firstNumDynamic + secondNumDynamic;
                    break;
                case "-":
                    result = firstNumDynamic - secondNumDynamic;
                    break;
                case "*":
                    result = firstNumDynamic * secondNumDynamic;
                    break;
                case "/":
                    result = firstNumDynamic / secondNumDynamic;
                    break;
                default:
                    result = firstNumDynamic + secondNumDynamic;
            }



            // Check if the result is a valid number
            if (!Double.isNaN(result) && !Double.isInfinite(result)) {
                int integerResult = (int) result; // Convert to an integer
                dynamicResult.setText(String.valueOf(integerResult));
                finalResult.setText(String.valueOf(integerResult));
            } else {
                dynamicResult.setText(String.valueOf(result));
                finalResult.setText(String.valueOf(result));
            }
            result = firstNum;
        });

    }


}


