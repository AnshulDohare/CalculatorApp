package com.example.calculatorapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textInput,textResult;
    private static String currentInput = "";
    private static String currentOperation = "";
    private static String currentInput2="";
    private static double operand1 ;
    private static double operand2 ;
    private static double res;
    private static boolean decimal = true;

    DecimalFormat df = new DecimalFormat("#.###");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInput = findViewById(R.id.input);
        textResult = findViewById(R.id.result);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_percentage).setOnClickListener(this);
        findViewById(R.id.btn_undo).setOnClickListener(this);
        findViewById(R.id.btn_divide).setOnClickListener(this);
        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
        findViewById(R.id.btn_four).setOnClickListener(this);
        findViewById(R.id.btn_five).setOnClickListener(this);
        findViewById(R.id.btn_six).setOnClickListener(this);
        findViewById(R.id.btn_seven).setOnClickListener(this);
        findViewById(R.id.btn_eight).setOnClickListener(this);
        findViewById(R.id.btn_nine).setOnClickListener(this);
        findViewById(R.id.btn_zero).setOnClickListener(this);
        findViewById(R.id.btn_double_zero).setOnClickListener(this);
        findViewById(R.id.btn_decimal_point).setOnClickListener(this);
        findViewById(R.id.btn_multiply).setOnClickListener(this);
        findViewById(R.id.btn_subtract).setOnClickListener(this);
        findViewById(R.id.btn_addition).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if((res+"").equals("Infinity")){
            clearAll();
        }
        else if(id==R.id.btn_one){
            appendInput("1");
        }
        else if(id==R.id.btn_two){
            appendInput("2");
        }
        else if(id==R.id.btn_three){
            appendInput("3");
        }
        else if(id==R.id.btn_four){
            appendInput("4");
        }
        else if(id==R.id.btn_five){
            appendInput("5");
        }
        else if(id==R.id.btn_six){
            appendInput("6");
        }
        else if(id==R.id.btn_seven){
            appendInput("7");
        }
        else if(id==R.id.btn_eight){
            appendInput("8");
        }
        else if(id==R.id.btn_nine){
            appendInput("9");
        }
        else if(id==R.id.btn_zero){
            if(!currentInput.isEmpty()) {
                appendInput("0");
            }
        }
        else if(id==R.id.btn_clear){
            clearAll();
        }
        else if(id==R.id.btn_percentage){
            if(!currentInput.isEmpty()){
                currentInput2+="%";
                textInput.setText(currentInput2);
                res = operand1/100;
                textResult.setText(res+"");
                currentOperation = "%";
                currentInput = "";
                operand1 = res;

            }
            else if(!currentOperation.isEmpty()){
                currentOperation = "%";
                String temp = currentInput2;
                String sub = temp.substring(0,temp.length()-1);
                currentInput2 = sub+"%";
                textInput.setText(currentInput2);
                res = operand1/100;
                textResult.setText(res+"");
                currentOperation = "%";
                currentInput = "";
                operand1 = res;
            }

        }
        else if(id==R.id.btn_undo){
            Toast.makeText(this, "Unable To UNDO,Please Clear All and Calculate Again", Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.btn_divide){
            if(!currentInput.isEmpty()){
                operations("/");
            }
            else if(currentOperation.equals("%")){
                currentOperation = "/";
                String temp = currentInput2;
                String sub = temp.substring(0,temp.length()-1);
                currentInput2 = sub+"/";
                textInput.setText(currentInput2);
                double tempRes = res * 100;
                operand1 = tempRes;
                textResult.setText(tempRes+"");
            }
            else if(!currentOperation.isEmpty()){
                currentOperation = "/";
                String temp = currentInput2;
                String sub = temp.substring(0,temp.length()-1);
                currentInput2 = sub+"/";
                textInput.setText(currentInput2);
            }
        }
        else if(id==R.id.btn_multiply){
            if(!currentInput.isEmpty()){
                operations("X");
            }
            else if(currentOperation.equals("%")){
                currentOperation = "X";
                String temp = currentInput2;
                String sub = temp.substring(0,temp.length()-1);
                currentInput2 = sub+"X";
                textInput.setText(currentInput2);
                double tempRes = res * 100;
                operand1 = tempRes;
                textResult.setText(tempRes+"");
            }
            else if(!currentOperation.isEmpty()){
                currentOperation = "X";
                String temp = currentInput2;
                String sub = temp.substring(0,temp.length()-1);
                currentInput2 = sub+"X";
                textInput.setText(currentInput2);
            }
        }
        else if(id==R.id.btn_subtract){
            if(!currentInput.isEmpty()){
                operations("-");
            }
            else if(currentOperation.equals("%")){
                currentOperation = "-";
                String temp = currentInput2;
                String sub = temp.substring(0,temp.length()-1);
                currentInput2 = sub+"-";
                textInput.setText(currentInput2);
                double tempRes = res * 100;
                operand1 = tempRes;
                textResult.setText(tempRes+"");
            }
            else if(!currentOperation.isEmpty()){
                currentOperation = "-";
                String temp = currentInput2;
                String sub = temp.substring(0,temp.length()-1);
                currentInput2 = sub+"-";
                textInput.setText(currentInput2);
            }
        }
        else if(id==R.id.btn_addition){
            if(!currentInput.isEmpty()){
                operations("+");
            }
            else if(currentOperation.equals("%")){
                currentOperation = "+";
                String temp = currentInput2;
                String sub = temp.substring(0,temp.length()-1);
                currentInput2 = sub+"+";
                textInput.setText(currentInput2);
                double tempRes = res * 100;
                operand1 = tempRes;
                textResult.setText(tempRes+"");
            }
            else if(!currentOperation.isEmpty()){
                currentOperation = "+";
                String temp = currentInput2;
                String sub = temp.substring(0,temp.length()-1);
                currentInput2 = sub+"+";
                textInput.setText(currentInput2);
            }
        }
        else if(id==R.id.btn_equal){
            if(!currentInput.isEmpty()){
                equalResult();
            }
            else if(currentOperation.equals("%")){
                String temp = currentInput2;
                currentInput2 = temp.substring(0,temp.length()-1);
                textInput.setText(currentInput2);
                currentOperation = "";
                double tempRes = res * 100;
                currentInput = tempRes+"";
                textResult.setText(tempRes+"");
            }
            else if(!currentOperation.isEmpty()){
                String temp = currentInput2;
                currentInput2 = temp.substring(0,temp.length()-1);
                textInput.setText(currentInput2);
                currentOperation = "";
                currentInput = res+"";
            }
        }
        else if(id==R.id.btn_decimal_point){
            if(currentInput.isEmpty()&&decimal){
                currentInput+="0.";
                currentInput2 = currentInput2+"0.";
                textInput.setText(currentInput2);
                decimal = false;
            }
            else if(decimal){
                appendInput(".");
                decimal = false;
            }
        }

        else if(id==R.id.btn_double_zero){
            if(!(currentInput.isEmpty())){
                appendInput("00");
            }

        }
    }

    private void appendInput(String input){

        currentInput +=input;
        currentInput2+=input;
        textInput.setText(currentInput2);
        if(currentOperation.isEmpty()){
            try {
                operand1 = Double.parseDouble(currentInput);
            }
            catch (Exception e){
                textResult.setText(e.getMessage());
                clearAll();
            }
        }
        else {
            try {
                operand2 = Double.parseDouble(currentInput);
            }
            catch (Exception e){
                textResult.setText(e.getMessage());
                clearAll();
            }
        }
    }

    private void operations(String input){
        if(!currentOperation.isEmpty()){
            currentInput2+=input;
            textInput.setText(currentInput2);
            decimal = true;
            getResult(input);
        }
        else {
            currentOperation = input;
            currentInput2+=input;
            textInput.setText(currentInput2);
            currentInput = "";
            decimal = true;
        }
    }

    @SuppressLint("SetTextI18n")
    private void getResult(String input){
        switch (currentOperation){
            case "+":try {
                res = operand1 + operand2;
                textResult.setText(res + "");
                currentInput = "";
                operand1 = res;
                currentOperation = input;
            }
            catch (Exception e){
                textResult.setText("Unable to Calculate");
                clearAll();
            }
            break;
            case "-": try{
                res = operand1-operand2;
                textResult.setText(res+"");
                currentInput = "";
                operand1 = res;
                currentOperation = input;
            }
            catch (Exception e){
                textResult.setText("Unable to Calculate");
                clearAll();
            }
                break;
            case "X":
            case "%":
                try{
                res = operand1*operand2;
                textResult.setText(res+"");
                currentInput = "";
                operand1 = res;
                currentOperation = input;
            }
            catch (Exception e){
                textResult.setText("Unable to Calculate");
                clearAll();
            }
                break;
            case "/":
                if(operand2==0){
                    textResult.setText("Cannot be divided by 0");
                    clearAll();
                    break;
                }
                try{
                res = operand1/operand2;
                textResult.setText(res+"");
                currentInput = "";
                operand1 = res;
                currentOperation = input;
                }
                catch (Exception e){
                    textResult.setText("Unable to Calculate");
                    clearAll();
                }
                break;
        }
    }

    private void clearAll(){
        textResult.setText("");
        textResult.setHint("Result");
        textInput.setText("0");
        currentInput = "";
        currentOperation = "";
        currentInput2="";
        operand1 = 0;
        operand2 = 0;
        decimal = true;
    }

    @SuppressLint("SetTextI18n")
    private void equalResult(){
        decimal = true;
        switch (currentOperation){
            case "+": try{
                res = operand1+operand2;
                textResult.setText(res+"");
                currentInput = res+"";
                currentInput2 = df.format(res)+"";
                currentOperation = "";
                operand1 = res;
                operand2 = 0;
            }
            catch (Exception e){
                textResult.setText("Unable to Calculate");
                clearAll();
            }
                break;
            case "-": try{
                res = operand1-operand2;
                textResult.setText(res+"");
                currentInput =res+"";
                currentInput2 = df.format(res)+"";
                currentOperation = "";
                operand1 = res;
                operand2 = 0;
            }
            catch (Exception e){
                textResult.setText("Unable to Calculate");
                clearAll();
            }
                break;
            case "%":
            case "X":try{
                res =operand1*operand2;
                textResult.setText(res+"");
                currentInput = res+"";
                currentInput2 = df.format(res)+"";
                currentOperation = "";
                operand1 = res;
                operand2 = 0;
            }
            catch (Exception e){
                textResult.setText("Unable to Calculate");
                clearAll();
            }
                break;
            case "/":
                if(operand2==0){
                    textResult.setText("Cannot be divided by 0");

                    clearAll();
                    break;
                }
                try{
                    res = operand1/operand2;
                textResult.setText(res+"");
                currentInput =res+"";
                currentInput2 = df.format(res)+"";
                currentOperation = "";
                operand1 = res;
                operand2 = 0;
                }
                catch (Exception e){
                    textResult.setText("Unable to Calculate");
                    clearAll();
                }
                break;

        }
    }
}