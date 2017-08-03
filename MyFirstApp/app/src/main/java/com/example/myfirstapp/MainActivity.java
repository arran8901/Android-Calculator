package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private double number;
    private char operation;
    private DecimalFormat format = new DecimalFormat("0.##########");
    private double memory;
    private boolean clear = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button0Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        if(Double.parseDouble(resultBox.getText().toString()) != 0) {
            setupResultBox();
            resultBox.append("0");
        }
    }

    public void buttonDecPointPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        if(!resultBox.getText().toString().contains(".")) {
            setupResultBox();
            if(resultBox.getText().length() == 0)
                resultBox.append("0");
            resultBox.append(".");
        }
    }

    public void buttonBackspacePressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        if(resultBox.getText().length() == 1)
            resultBox.setText("0");
        else if(!resultBox.getText().equals("0"))
            resultBox.setText(resultBox.getText().toString().substring(0, resultBox.getText().length() - 1));
    }

    public void button1Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        setupResultBox();
        resultBox.append("1");
    }

    public void button2Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        setupResultBox();
        resultBox.append("2");
    }

    public void button3Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        setupResultBox();
        resultBox.append("3");
    }

    public void button4Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        setupResultBox();
        resultBox.append("4");
    }

    public void button5Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        setupResultBox();
        resultBox.append("5");
    }

    public void button6Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        setupResultBox();
        resultBox.append("6");
    }

    public void button7Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        setupResultBox();
        resultBox.append("7");
    }

    public void button8Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        setupResultBox();
        resultBox.append("8");
    }

    public void button9Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        setupResultBox();
        resultBox.append("9");
    }

    public void plusPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton plus = (ToggleButton) findViewById(R.id.toggleButtonPlus);
        revertEquals();
        if(plus.isChecked()) {
            number = Double.parseDouble(resultBox.getText().toString());
            operation = '+';
            clear = true;
        } else {
            resultBox.setText(String.format(format.format(number)));
            operation = '0';
        }
    }

    public void minusPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton minus = (ToggleButton) findViewById(R.id.toggleButtonMinus);
        revertEquals();
        if(minus.isChecked()) {
            number = Double.parseDouble(resultBox.getText().toString());
            operation = '-';
            clear = true;
        } else {
            resultBox.setText(String.format(format.format(number)));
            operation = '0';
        }
    }

    public void timesPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton times = (ToggleButton) findViewById(R.id.toggleButtonTimes);
        revertEquals();
        if(times.isChecked()) {
            number = Double.parseDouble(resultBox.getText().toString());
            operation = '*';
            clear = true;
        } else {
            resultBox.setText(String.format(format.format(number)));
            operation = '0';
        }
    }

    public void dividePressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton divide = (ToggleButton) findViewById(R.id.toggleButtonDivide);
        revertEquals();
        if(divide.isChecked()) {
            number = Double.parseDouble(resultBox.getText().toString());
            operation = '/';
            clear = true;
        } else {
            resultBox.setText(String.format(format.format(number)));
            operation = '0';
        }
    }

    public void powerPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton power = (ToggleButton) findViewById(R.id.toggleButtonPower);
        revertEquals();
        if(power.isChecked()) {
            number = Double.parseDouble(resultBox.getText().toString());
            operation = '^';
            clear = true;
        } else {
            resultBox.setText(String.format(format.format(number)));
            operation = '0';
        }
    }

    public void rootPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton root = (ToggleButton) findViewById(R.id.toggleButtonRoot);
        revertEquals();
        if(root.isChecked()) {
            if(Double.parseDouble(resultBox.getText().toString()) == 0)
                number = 2;
            else
                number = Double.parseDouble(resultBox.getText().toString());
            operation = '√';
            clear = true;
        } else {
            resultBox.setText(String.format(format.format(number)));
            operation = '0';
        }
    }

    public void logPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton log = (ToggleButton) findViewById(R.id.toggleButtonLog);
        revertEquals();
        if(log.isChecked()) {
            if(Double.parseDouble(resultBox.getText().toString()) == 0)
                number = 10;
            else
                number = Double.parseDouble(resultBox.getText().toString());
            operation = 'l';
            clear = true;
        } else {
            resultBox.setText(String.format(format.format(number)));
            operation = '0';
        }
    }

    public void equalsPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        Button equals = (Button) findViewById(R.id.buttonEquals);
        if(equals.getText().equals("AC")) {
            resultBox.setText("0");
            equals.setText("=");
            return;
        }
        switch(operation) {
            case '+':
                resultBox.setText(String.format(format.format(number + Double.parseDouble(resultBox.getText().toString()))));
                ToggleButton plus = (ToggleButton) findViewById(R.id.toggleButtonPlus);
                plus.setChecked(false);
                break;
            case '-':
                resultBox.setText(String.format(format.format(number - Double.parseDouble(resultBox.getText().toString()))));
                ToggleButton minus = (ToggleButton) findViewById(R.id.toggleButtonMinus);
                minus.setChecked(false);
                break;
            case '*':
                resultBox.setText(String.format(format.format(number * Double.parseDouble(resultBox.getText().toString()))));
                ToggleButton times = (ToggleButton) findViewById(R.id.toggleButtonTimes);
                times.setChecked(false);
                break;
            case '/':
                if(Double.parseDouble(resultBox.getText().toString()) == 0)
                    return;
                resultBox.setText(String.format(format.format(number / Double.parseDouble(resultBox.getText().toString()))));
                ToggleButton divide = (ToggleButton) findViewById(R.id.toggleButtonDivide);
                divide.setChecked(false);
                break;
            case '^':
                resultBox.setText(String.format(format.format(Math.pow(number, Double.parseDouble(resultBox.getText().toString())))));
                ToggleButton power = (ToggleButton) findViewById(R.id.toggleButtonPower);
                power.setChecked(false);
                break;
            case '√':
                resultBox.setText(String.format(format.format(Math.pow(Double.parseDouble(resultBox.getText().toString()), 1 / number))));
                ToggleButton root = (ToggleButton) findViewById(R.id.toggleButtonRoot);
                root.setChecked(false);
                break;
            case 'l':
                if(Double.parseDouble(resultBox.getText().toString()) == 0)
                    return;
                resultBox.setText(String.format(format.format(Math.log10(Double.parseDouble(resultBox.getText().toString())) / Math.log10(number))));
                ToggleButton log = (ToggleButton) findViewById(R.id.toggleButtonLog);
                log.setChecked(false);
                break;
        }
        clear = true;
        equals.setText("AC");
    }

    public void memoryPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton memory = (ToggleButton) findViewById(R.id.toggleButtonMemory);
        if(memory.isChecked()) {
            this.memory = Double.parseDouble(resultBox.getText().toString());
        } else {
            resultBox.setText(String.format(format.format(this.memory)));
        }
    }

    public void setupResultBox() {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        if((Double.parseDouble(resultBox.getText().toString()) == 0 && !resultBox.getText().toString().equals("0.")) || clear == true) {
            resultBox.setText("");
            if(clear == true)
                clear = false;
            revertEquals();
        }
    }

    public void revertEquals() {
        Button equals = (Button) findViewById(R.id.buttonEquals);
        if(!equals.getText().equals("="))
            equals.setText("=");
    }
}
