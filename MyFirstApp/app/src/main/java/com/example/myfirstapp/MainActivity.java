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
    private static final DecimalFormat format = new DecimalFormat("0.##########");
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
        setupResultBox();
        if(!resultBox.getText().toString().contains(".")) {
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
        TextView infoBox = (TextView) findViewById(R.id.infoBox);
        ToggleButton plus = (ToggleButton) findViewById(R.id.toggleButtonPlus);
        if(plus.isChecked()) {
            disableOperations(plus);
            number = Double.parseDouble(resultBox.getText().toString());
            setEquals();
            operation = '+';
            infoBox.setText("+");
            clear = true;
        } else {
            enableOperations();
            setAC();
            operation = '0';
            infoBox.setText("");
        }
    }

    public void minusPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        TextView infoBox = (TextView) findViewById(R.id.infoBox);
        ToggleButton minus = (ToggleButton) findViewById(R.id.toggleButtonMinus);
        if(minus.isChecked()) {
            disableOperations(minus);
            number = Double.parseDouble(resultBox.getText().toString());
            setEquals();
            operation = '-';
            infoBox.setText("-");
            clear = true;
        } else {
            enableOperations();
            setAC();
            operation = '0';
            infoBox.setText("");
        }
    }

    public void timesPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        TextView infoBox = (TextView) findViewById(R.id.infoBox);
        ToggleButton times = (ToggleButton) findViewById(R.id.toggleButtonTimes);
        if(times.isChecked()) {
            disableOperations(times);
            number = Double.parseDouble(resultBox.getText().toString());
            setEquals();
            operation = '*';
            infoBox.setText("x");
            clear = true;
        } else {
            enableOperations();
            setAC();
            operation = '0';
            infoBox.setText("");
        }
    }

    public void dividePressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        TextView infoBox = (TextView) findViewById(R.id.infoBox);
        ToggleButton divide = (ToggleButton) findViewById(R.id.toggleButtonDivide);
        if(divide.isChecked()) {
            disableOperations(divide);
            number = Double.parseDouble(resultBox.getText().toString());
            setEquals();
            operation = '/';
            infoBox.setText("/");
            clear = true;
        } else {
            enableOperations();
            setAC();
            operation = '0';
            infoBox.setText("");
        }
    }

    public void powerPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        TextView infoBox = (TextView) findViewById(R.id.infoBox);
        ToggleButton power = (ToggleButton) findViewById(R.id.toggleButtonPower);
        if(power.isChecked()) {
            disableOperations(power);
            number = Double.parseDouble(resultBox.getText().toString());
            setEquals();
            operation = '^';
            infoBox.setText("xⁿ");
            clear = true;
        } else {
            enableOperations();
            setAC();
            operation = '0';
            infoBox.setText("");
        }
    }

    public void rootPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        TextView infoBox = (TextView) findViewById(R.id.infoBox);
        ToggleButton root = (ToggleButton) findViewById(R.id.toggleButtonRoot);
        if(root.isChecked()) {
            disableOperations(root);
            if(Double.parseDouble(resultBox.getText().toString()) == 0)
                number = 2;
            else
                number = Double.parseDouble(resultBox.getText().toString());
            setEquals();
            operation = '√';
            infoBox.setText(superscript(String.format(format.format(number))) + "√");
            clear = true;
        } else {
            enableOperations();
            setAC();
            operation = '0';
            infoBox.setText("");
        }
    }

    public void logPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        TextView infoBox = (TextView) findViewById(R.id.infoBox);
        ToggleButton log = (ToggleButton) findViewById(R.id.toggleButtonLog);
        if(log.isChecked()) {
            disableOperations(log);
            if(Double.parseDouble(resultBox.getText().toString()) == 0)
                number = 10;
            else
                number = Double.parseDouble(resultBox.getText().toString());
            operation = 'l';
            setEquals();
            infoBox.setText("log" + subscript(String.format(format.format(number))));
            clear = true;
        } else {
            enableOperations();
            setAC();
            operation = '0';
            infoBox.setText("");
        }
    }

    public void equalsPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        TextView infoBox = (TextView) findViewById(R.id.infoBox);
        Button equals = (Button) findViewById(R.id.buttonEquals);
        if(equals.getText().equals("AC") || equals.getText().equals("= / AC")) {
            enableOperations();
            resultBox.setText("0");
            return;
        }
        String result = "";
        switch(operation) {
            case '+':
                result = String.format(format.format(number + Double.parseDouble(resultBox.getText().toString())));
                ToggleButton plus = (ToggleButton) findViewById(R.id.toggleButtonPlus);
                plus.setChecked(false);
                break;
            case '-':
                result = String.format(format.format(number - Double.parseDouble(resultBox.getText().toString())));
                ToggleButton minus = (ToggleButton) findViewById(R.id.toggleButtonMinus);
                minus.setChecked(false);
                break;
            case '*':
                result = String.format(format.format(number * Double.parseDouble(resultBox.getText().toString())));
                ToggleButton times = (ToggleButton) findViewById(R.id.toggleButtonTimes);
                times.setChecked(false);
                break;
            case '/':
                if(Double.parseDouble(resultBox.getText().toString()) == 0)
                    return;
                result = String.format(format.format(number / Double.parseDouble(resultBox.getText().toString())));
                ToggleButton divide = (ToggleButton) findViewById(R.id.toggleButtonDivide);
                divide.setChecked(false);
                break;
            case '^':
                result = String.format(format.format(Math.pow(number, Double.parseDouble(resultBox.getText().toString()))));
                ToggleButton power = (ToggleButton) findViewById(R.id.toggleButtonPower);
                power.setChecked(false);
                break;
            case '√':
                result = String.format(format.format(Math.pow(Double.parseDouble(resultBox.getText().toString()), 1 / number)));
                ToggleButton root = (ToggleButton) findViewById(R.id.toggleButtonRoot);
                root.setChecked(false);
                break;
            case 'l':
                if(Double.parseDouble(resultBox.getText().toString()) == 0)
                    return;
                result = String.format(format.format(Math.log10(Double.parseDouble(resultBox.getText().toString())) / Math.log10(number)));
                ToggleButton log = (ToggleButton) findViewById(R.id.toggleButtonLog);
                log.setChecked(false);
                break;
        }
        if(result.length() > 30)
            result = "∞";
        if(result.equals("∞"))
            disableOperations(null);
        else
            enableOperations();
        resultBox.setText(result);
        infoBox.setText("");
        clear = true;
        setAC();
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
        if(resultBox.getText().toString().equals("∞")) {
            resultBox.setText("0");
            enableOperations();
        }
        if((Double.parseDouble(resultBox.getText().toString()) == 0 && !resultBox.getText().toString().equals("0.")) || clear == true) {
            resultBox.setText("");
            if(clear == true)
                clear = false;
        }
    }

    public void setEquals() {
        Button equals = (Button) findViewById(R.id.buttonEquals);
        if(!equals.getText().equals("="))
            equals.setText("=");
    }

    public void setAC() {
        Button equals = (Button) findViewById(R.id.buttonEquals);
        if(!equals.getText().equals("AC"))
            equals.setText("AC");
    }

    public void enableOperations() {
        ToggleButton[] operations = {(ToggleButton) findViewById(R.id.toggleButtonPlus), (ToggleButton) findViewById(R.id.toggleButtonMinus), (ToggleButton) findViewById(R.id.toggleButtonTimes), (ToggleButton) findViewById(R.id.toggleButtonDivide), (ToggleButton) findViewById(R.id.toggleButtonPower), (ToggleButton) findViewById(R.id.toggleButtonRoot), (ToggleButton) findViewById(R.id.toggleButtonLog)};
        for(ToggleButton button: operations) {
            if(!button.isEnabled())
                button.setEnabled(true);
        }
    }

    public void disableOperations(ToggleButton keep) {
        ToggleButton[] operations = {(ToggleButton) findViewById(R.id.toggleButtonPlus), (ToggleButton) findViewById(R.id.toggleButtonMinus), (ToggleButton) findViewById(R.id.toggleButtonTimes), (ToggleButton) findViewById(R.id.toggleButtonDivide), (ToggleButton) findViewById(R.id.toggleButtonPower), (ToggleButton) findViewById(R.id.toggleButtonRoot), (ToggleButton) findViewById(R.id.toggleButtonLog)};
        for(ToggleButton button: operations) {
            if(button != keep)
                button.setEnabled(false);
        }
    }

    public static String subscript(String s) {
        s = s.replaceAll("0", "₀");
        s = s.replaceAll("1", "₁");
        s = s.replaceAll("2", "₂");
        s = s.replaceAll("3", "₃");
        s = s.replaceAll("4", "₄");
        s = s.replaceAll("5", "₅");
        s = s.replaceAll("6", "₆");
        s = s.replaceAll("7", "₇");
        s = s.replaceAll("8", "₈");
        s = s.replaceAll("9", "₉");
        return s;
    }

    public static String superscript(String s) {
        s = s.replaceAll("0", "⁰");
        s = s.replaceAll("1", "¹");
        s = s.replaceAll("2", "²");
        s = s.replaceAll("3", "³");
        s = s.replaceAll("4", "⁴");
        s = s.replaceAll("5", "⁵");
        s = s.replaceAll("6", "⁶");
        s = s.replaceAll("7", "⁷");
        s = s.replaceAll("8", "⁸");
        s = s.replaceAll("9", "⁹");
        return s;
    }
}
