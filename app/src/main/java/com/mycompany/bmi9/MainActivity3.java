package com.mycompany.bmi9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends Activity {



    private EditText txtheight;
    private EditText txtweight;
    private TextView txtresult;
    private Button btncalculate;
    private double bmi = 0;
    private double valueheight = 0;
    private double valueweight = 0;
    private String resulttext;
    TinyDB tinydb;

    public void button1(View view){
        Intent intent=new Intent(MainActivity3.this,MainActivity4.class);
        startActivity(intent);
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);

        tinydb = new TinyDB(getApplicationContext());

        txtheight = (EditText)findViewById(R.id.txtheight);
        txtweight = (EditText)findViewById(R.id.txtweight);
        txtresult = (TextView)findViewById(R.id.txtresult);
        btncalculate = (Button)findViewById(R.id.btncalculate);
        //btnreset = (Button)findViewById(R.id.btnreset);
        /*TextView tv = new TextView(this);
        tv.setText("BMI Calculator");
        setContentView(tv);*/

    }

    public void calculate(View view)    {
        valueheight = Double.parseDouble(txtheight.getText().toString());
        valueweight = Double.parseDouble(txtweight.getText().toString());
        Double valueheightmeters;

        valueheightmeters = valueheight / 100; // Converting to meters.
        bmi = (valueweight / (valueheightmeters * valueheightmeters));

        //txttipamount.setText(Double.toString(bmi));
        if (bmi >= 30) { /* obese */
            resulttext = "Your BMI of " + Double.toString(bmi) + " is OBESE.";
            txtresult.setText(resulttext);
        } else if (bmi >= 25) {
            resulttext = "Your BMI of " + Double.toString(bmi) + " is OVERWEIGHT.";
            txtresult.setText(resulttext);
        } else if (bmi >= 18.5) {
            resulttext = "Your BMI of " + Double.toString(bmi) + " is IDEAL.";
            txtresult.setText(resulttext);
        } else {
            resulttext = "Your BMI of " + Double.toString(bmi) + " is UNDERWEIGHT.";
            txtresult.setText(resulttext);
        }

        tinydb.putDouble("savedBMI", bmi);

//       Double someVariable = tinydb.getDouble("savedBMI");
    }

//    private void calculate()    {
//        valueheight =Double.parseDouble(txtheight.getText().toString());
//        valueweight =Double.parseDouble(txtweight.getText().toString());
//        bmi = (valueweight / (valueheight * valueheight));
//        //txttipamount.setText(Double.toString(bmi));
//        if (bmi >= 30) { /* obese */
//            resulttext = "Your BMI of " + Double.toString(bmi) + " is OBESE.";
//            txtresult.setText(resulttext);
//        } else if (bmi >= 25) {
//            resulttext = "Your BMI of " + Double.toString(bmi) + " is OVERWEIGHT.";
//            txtresult.setText(resulttext);
//        } else if (bmi >= 18.5) {
//            resulttext = "Your BMI of " + Double.toString(bmi) + " is IDEAL.";
//            txtresult.setText(resulttext);
//        } else {
//            resulttext = "Your BMI of " + Double.toString(bmi) + " is UNDERWEIGHT.";
//            txtresult.setText(resulttext);
//        }
}
