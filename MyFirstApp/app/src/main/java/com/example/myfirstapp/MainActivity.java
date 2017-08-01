package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private double number;
    private char operation;
    private DecimalFormat format = new DecimalFormat("0.#");
    private double memory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button0Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        if(!resultBox.getText().toString().equals(""))
            resultBox.append("0");
    }

    public void buttonDecPointPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        if(!resultBox.getText().toString().contains("."))
            resultBox.append(".");
    }

    public void buttonBackspacePressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        if(resultBox.getText() != null && resultBox.getText().length() > 0)
            resultBox.setText(resultBox.getText().toString().substring(0, resultBox.getText().length() - 1));
    }

    public void button1Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        resultBox.append("1");
    }

    public void button2Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        resultBox.append("2");
    }

    public void button3Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        resultBox.append("3");
    }

    public void button4Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        resultBox.append("4");
    }

    public void button5Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        resultBox.append("5");
    }

    public void button6Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        resultBox.append("6");
    }

    public void button7Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        resultBox.append("7");
    }

    public void button8Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        resultBox.append("8");
    }

    public void button9Pressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        resultBox.append("9");
    }

    public void plusPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton plus = (ToggleButton) findViewById(R.id.toggleButtonPlus);
        if(plus.isChecked()) {
            try {
                number = Double.parseDouble(resultBox.getText().toString());
            } catch (Exception e) {
                number = 0;
            }
            resultBox.setText("");
        } else {
            resultBox.setText(String.format(format.format(number)));
        }
        operation = '+';
    }

    public void minusPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton minus = (ToggleButton) findViewById(R.id.toggleButtonMinus);
        if(minus.isChecked()) {
            try {
                number = Double.parseDouble(resultBox.getText().toString());
            } catch (Exception e) {
                number = 0;
            }
            resultBox.setText("");
        } else {
            resultBox.setText(String.format(format.format(number)));
        }
        operation = '-';
    }

    public void timesPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton times = (ToggleButton) findViewById(R.id.toggleButtonTimes);
        if(times.isChecked()) {
            try {
                number = Double.parseDouble(resultBox.getText().toString());
            } catch (Exception e) {
                number = 0;
            }
            resultBox.setText("");
        } else {
            resultBox.setText(String.format(format.format(number)));
        }
        operation = '*';
    }

    public void dividePressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton divide = (ToggleButton) findViewById(R.id.toggleButtonDivide);
        if(divide.isChecked()) {
            try {
                number = Double.parseDouble(resultBox.getText().toString());
            } catch (Exception e) {
                number = 0;
            }
            resultBox.setText("");
        } else {
            resultBox.setText(String.format(format.format(number)));
        }
        operation = '/';
    }

    public void powerPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton power = (ToggleButton) findViewById(R.id.toggleButtonPower);
        if(power.isChecked()) {
            try {
                number = Double.parseDouble(resultBox.getText().toString());
            } catch (Exception e) {
                number = 0;
            }
            resultBox.setText("");
        } else {
            resultBox.setText(String.format(format.format(number)));
        }
        operation = '^';
    }

    public void rootPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton root = (ToggleButton) findViewById(R.id.toggleButtonRoot);
        if(root.isChecked()) {
            try {
                number = Double.parseDouble(resultBox.getText().toString());
            } catch (Exception e) {
                number = 2;
            }
            resultBox.setText("");
        } else {
            resultBox.setText(String.format(format.format(number)));
        }
        operation = '√';
    }

    public void logPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton log = (ToggleButton) findViewById(R.id.toggleButtonLog);
        if(log.isChecked()) {
            try {
                number = Double.parseDouble(resultBox.getText().toString());
            } catch (Exception e) {
                number = 10;
            }
            resultBox.setText("");
        } else {
            resultBox.setText(String.format(format.format(number)));
        }
        operation = 'l';
    }

    public void equalsPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
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
                resultBox.setText(String.format(format.format(Math.log10(Double.parseDouble(resultBox.getText().toString())) / Math.log10(number))));
                ToggleButton log = (ToggleButton) findViewById(R.id.toggleButtonLog);
                log.setChecked(false);
                break;
        }
    }

    public void memoryPressed(View view) {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        ToggleButton memory = (ToggleButton) findViewById(R.id.toggleButtonMemory);
        if(memory.isChecked()) {
            try {
                this.memory = Double.parseDouble(resultBox.getText().toString());
            } catch (Exception e) {
                this.memory = 0;
            }
        } else {
            resultBox.setText(String.format(format.format(this.memory)));
        }
    }

    public void setupResultBox() {
        TextView resultBox = (TextView) findViewById(R.id.resultBox);
        if((resultBox.getText().toString().length() > 0 && Double.parseDouble(resultBox.getText().toString()) == 0) || number == 0)
            resultBox.setText("");
    }
}