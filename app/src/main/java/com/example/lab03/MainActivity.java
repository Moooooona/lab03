package com.example.lab03;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView resultTv,solutionTv;
    MaterialButton btnC,btnopenbrack,btnclosebrack,btndevid;
    MaterialButton btnmult,btnadd,btnmin,btnequal,btnpower,btndot;
    MaterialButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv=findViewById(R.id.result_tv);
        solutionTv=findViewById(R.id.solution_tv);

        assignId(btnC,R.id.btn_c);
        assignId(btnopenbrack,R.id.btn_open_bracket);
        assignId(btnclosebrack,R.id.btn_close_bracket);
        assignId(btndevid,R.id.btn_devid);
        assignId(btnmult,R.id.btn_multy);
        assignId(btnadd,R.id.btn_add);
        assignId(btnmin,R.id.btn_min);
        assignId(btnpower,R.id.btn_power);
        assignId(btnequal,R.id.btn_equal);
        assignId(btndot,R.id.btn_dot);
        assignId(btn0,R.id.btn_0);
        assignId(btn1,R.id.btn_1);
        assignId(btn2,R.id.btn_2);
        assignId(btn3,R.id.btn_3);
        assignId(btn4,R.id.btn_4);
        assignId(btn5,R.id.btn_5);
        assignId(btn6,R.id.btn_6);
        assignId(btn7,R.id.btn_7);
        assignId(btn8,R.id.btn_8);
        assignId(btn9,R.id.btn_9);
    }
    void assignId(MaterialButton btn, int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
MaterialButton button=(MaterialButton) v;
String buttonText= button.getText().toString();
String dataToCalculate=solutionTv.getText().toString();


if (buttonText.equals("=")){
    solutionTv.setText(resultTv.getText());
    return;
}
if(buttonText.equals("C")) {
    dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
}else{
    dataToCalculate = dataToCalculate + buttonText;
}
        solutionTv.setText(dataToCalculate);
String finalResult = getResult(dataToCalculate);
if(!finalResult.equals("Err")){
    resultTv.setText(finalResult);
}
    }
    String getResult(String data){
    try {
        Context context=Context.enter();
        context.setOptimizationLevel(-1);
        Scriptable scriptable=context.initSafeStandardObjects();
        String finalResalt = context.evaluateString(scriptable,data,"javascript",1,null). toString();
        return finalResalt;
    } catch (Exception e){
        return "Err";
    }

    }
}