package com.example.calculator;

import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Spliterators;

public class MainActivity extends AppCompatActivity {

    TextView res;
    boolean isNewnum=true;
    String yunsuan="";
    String oldnum="";
    String newnum="";
    private Integer yunsuancishu=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = (TextView) findViewById(R.id.result);
    }

    public void numberEvent (View view){
        if(isNewnum){
            res.setText("");
        }
        isNewnum=false;
        String num=res.getText().toString();
        switch (view.getId()){
            case R.id.btn1:
                num += "1";
                break;
            case R.id.btn2:
                num += "2";
                break;
            case R.id.btn3:
                num += "3";
                break;
            case R.id.btn4:
                num += "4";
                break;
            case R.id.btn5:
                num += "5";
                break;
            case R.id.btn6:
                num += "6";
                break;
            case R.id.btn7:
                num += "7";
                break;
            case  R.id.btn8:
                num += "8";
                break;
            case  R.id.btn9:
                num += "9";
                break;
            case  R.id.btn0:
                num += "0";
                break;
            case  R.id.btndian:
                if(!num.contains(".")){
                    num += ".";
                }
                break;
            case  R.id.btnzhengfu:
                if(Double.parseDouble(num)>0){
                    num ="-"+num;
                }
                if(Double.parseDouble(num)<0){
                    num.replace("-","");
                }
                break;
        }
        res.setText(num);
    }

    public void yunsuanEvent (View view){
        yunsuancishu++;
        isNewnum=true;
        newnum=res.getText().toString();
        double result = 0.0;
        switch (view.getId()){
            case R.id.btnjia:
                if(yunsuancishu==1){
                    oldnum=newnum;
                }
                else{
                    switch (yunsuan) {
                        case "+": {
                            result = Double.parseDouble(oldnum) + Double.parseDouble(newnum);
                            oldnum=result+"";
                            break;
                        }
                        case "-": {
                            result = Double.parseDouble(oldnum) - Double.parseDouble(newnum);
                            oldnum=result+"";
                            break;
                        }
                        case "*": {
                            result = Double.parseDouble(oldnum) * Double.parseDouble(newnum);
                            oldnum=result+"";
                            break;
                        }
                        case "/": {
                            if (Double.parseDouble(newnum)>0 || Double.parseDouble(newnum)<0) {
                                result = Double.parseDouble(oldnum) / Double.parseDouble(newnum);
                                oldnum=result+"";
                                break;
                            }
                        }
                    }
                    fmt(result);
                    res.setText(result + "");
            }
                yunsuan="+";
                break;
            case R.id.btnjian:
                if(yunsuancishu==1){
                    oldnum=newnum;
                }
                else{
                    switch (yunsuan) {
                        case "+": {
                            result = Double.parseDouble(oldnum) + Double.parseDouble(newnum);
                            oldnum=result+"";
                            break;
                        }
                        case "-": {
                            result = Double.parseDouble(oldnum) - Double.parseDouble(newnum);
                            oldnum=result+"";
                            break;
                        }
                        case "*": {
                            result = Double.parseDouble(oldnum) * Double.parseDouble(newnum);
                            oldnum=result+"";
                            break;
                        }
                        case "/": {
                            if (Double.parseDouble(newnum)>0 || Double.parseDouble(newnum)<0) {
                                result = Double.parseDouble(oldnum) / Double.parseDouble(newnum);
                                oldnum=result+"";
                                break;
                            }
                        }
                    }
                    fmt(result);
                    res.setText(result + "");
                }
                yunsuan="-";
                break;
            case R.id.btncheng:
                if(yunsuancishu==1){
                    oldnum=newnum;
                }
                else{
                    switch (yunsuan) {
                        case "+": {
                            result = Double.parseDouble(oldnum) + Double.parseDouble(newnum);
                            oldnum=result+"";
                            break;
                        }
                        case "-": {
                            result = Double.parseDouble(oldnum) - Double.parseDouble(newnum);
                            oldnum=result+"";
                            break;
                        }
                        case "*": {
                            result = Double.parseDouble(oldnum) * Double.parseDouble(newnum);
                            oldnum=result+"";
                            break;
                        }
                        case "/": {
                            if (Double.parseDouble(newnum)>0 || Double.parseDouble(newnum)<0) {
                                result = Double.parseDouble(oldnum) / Double.parseDouble(newnum);
                                oldnum=result+"";
                                break;
                            }
                        }
                    }
                    fmt(result);
                    res.setText(result + "");
                }
                yunsuan="*";
                break;
            case R.id.btnChu:
                if(yunsuancishu<=1){
                    oldnum=newnum;
                }
                else{
                    switch (yunsuan) {
                        case "+": {
                            result = Double.parseDouble(oldnum) + Double.parseDouble(newnum);
                            oldnum=result+"";
                            break;
                        }
                        case "-": {
                            result = Double.parseDouble(oldnum) - Double.parseDouble(newnum);
                            oldnum=result+"";
                            break;
                        }
                        case "*": {
                            result = Double.parseDouble(oldnum) * Double.parseDouble(newnum);
                            oldnum=result+"";
                            break;
                        }
                        case "/": {
                            if (Double.parseDouble(newnum)>0 || Double.parseDouble(newnum)<0) {
                                result = Double.parseDouble(oldnum) / Double.parseDouble(newnum);
                                oldnum=result+"";
                                break;
                            }
                        }
                    }
                    fmt(result);
                    res.setText(result + "");
                }
                yunsuan="/";
                break;
        }
    }

    public void equalEvent(View view) {
        String newnum = res.getText().toString();
        double result = 0.0;
        switch (yunsuan) {
            case "+": {
                result = Double.parseDouble(oldnum) + Double.parseDouble(newnum);
                break;
            }
            case "-": {
                result = Double.parseDouble(oldnum) - Double.parseDouble(newnum);
                break;
            }
            case "*": {
                result = Double.parseDouble(oldnum) * Double.parseDouble(newnum);
                break;
            }
            case "/": {
                if (newnum != "0") {
                    result = Double.parseDouble(oldnum) / Double.parseDouble(newnum);
                    break;
                }
            }
        }
        fmt(result);
        res.setText(result + "");
        yunsuan="";
        yunsuancishu=0;
    }


    public void acEvent(View view) {
        res.setText("0");
        isNewnum=true;
        yunsuancishu=0;
    }

    public void perEvent(View view) {
        double num=Double.parseDouble(res.getText().toString())/100;
        fmt(num);
        res.setText(num+"");
        isNewnum=true;
    }

    public static String fmt(double d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }
}