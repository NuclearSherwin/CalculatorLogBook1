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
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    private Button btnClear, btnEquals;
    private EditText resultDisplay;

    private String operator;
    double firstNum;
    String operation;

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
                if (!resultDisplay.getText().toString().equals("0")) {
                    resultDisplay.setText(resultDisplay.getText().toString() + b.getText().toString());
                } else {
                    resultDisplay.setText(b.getText().toString());
                }
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
                operation = b.getText().toString();
                resultDisplay.setText("0");
            });
        }

//        btnDelete.setOnClickListener(view -> {
//            String num = txtResult.getText().toString();
//            if (num.length() > 1) {
//                txtResult.setText(num.substring(0, num.length() - 1));
//            } else if (num.length() == 1 && !num.equals("0")) {
//                txtResult.setText("0");
//            }
//        });

        btnClear.setOnClickListener(view -> {
            firstNum= 0;
            txtResult.setText("0");
        });

        btnEquals.setOnClickListener(view -> {
            double secondNum = Double.parseDouble(resultDisplay.getText().toString());
            double result;

            switch (operation) {
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "*":
                    result = firstNum * secondNum;
                    break;
                case "/":
                    result = firstNum / secondNum;
                    break;
                default:
                    result = firstNum + secondNum;
            }
            resultDisplay.setText(String.valueOf(result));
            finalResult.setText(String.valueOf(result));
            firstNum = result;
        });




//        // Set onClick listeners for digit buttons
//        btn0.setOnClickListener(v -> appendNumber(0));
//        btn1.setOnClickListener(v -> appendNumber(1));
//        btn2.setOnClickListener(v -> appendNumber(2));
//        btn3.setOnClickListener(v -> appendNumber(3));
//        btn4.setOnClickListener(v -> appendNumber(4));
//        btn5.setOnClickListener(v -> appendNumber(5));
//        btn6.setOnClickListener(v -> appendNumber(6));
//        btn7.setOnClickListener(v -> appendNumber(7));
//        btn8.setOnClickListener(v -> appendNumber(8));
//        btn9.setOnClickListener(v -> appendNumber(9));
//
//        // Set onClick listeners for other buttons
//
//        // Set onClick listeners for operator buttons
//        btnAdd.setOnClickListener(v -> performOperation("+"));
//        btnAdd.setOnClickListener(v -> performOperation("-"));
//        btnAdd.setOnClickListener(v -> performOperation("*"));
//        btnAdd.setOnClickListener(v -> performOperation("/"));
//
//        // Set onClick listeners for Clear and Equals buttons
//        btnClear.setOnClickListener(v -> clear());
//        btnEquals.setOnClickListener(v -> calculate());
//    }
//
//
//    // Define a method to update the displayed numbers
//    private void appendNumber(int number) {
//        String currentText = resultTextView.getText().toString();
//        currentText += String.valueOf(number);
//        resultTextView.setText(currentText);
//    }
//
//    // Define methods for operators and calculations
//    private void performOperation(String op) {
//        if (!operator.isEmpty()) {
//            operand2 = Integer.parseInt(resultTextView.getText().toString());
//            calculate();
//            operator = op;
//        } else {
//            operator = op;
//            operand1 = Integer.parseInt(resultTextView.getText().toString());
//        }
//        resultTextView.setText("");
//    }
//
//    // Set onClick listeners for operator buttons
//
//
//
//    // Define methods for Clear and Equals buttons
//    private void clear() {
//        operand1 = 0;
//        operand2 = 0;
//        operator = "";
//        resultTextView.setText("");
//    }
//
//    private void calculate() {
//        if (!Double.isNaN(operand1)) {
//            operand2 = Integer.parseInt(resultTextView.getText().toString());
//            switch (operator) {
//                case "+":
//                    operand1 += operand2;
//                    break;
//                case "-":
//                    operand1 -= operand2;
//                    break;
//                case "*":
//                    operand1 *= operand2;
//                    break;
//                case "/":
//                    if (operand2 != 0) {
//                        operand1 /= operand2;
//                    } else {
//                        resultTextView.setText("Error");
//                        return;
//                    }
//                    break;
//            }
//            operator = "";
//            resultTextView.setText(String.valueOf(operand1));
//        }



    }


}


