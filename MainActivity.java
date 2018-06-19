package com.intretech.pump;
import android.content.Intent;
import android.provider.Settings;
import android.view.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    private TextView test;
    private Button test_button, pump_button, setButton, calback,drink_start;

    private pumpJni myJNI = new pumpJni();
    private serialMcu mcu = new serialMcu();
    private  drinkInfo driv = new drinkInfo();
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mcu.serialInit(mcu);
        setContentView(R.layout.activity_main);
        test_button = (Button)findViewById((R.id.pump_init));
        pump_button = (Button)findViewById((R.id.pumpRate));
        setButton = (Button)findViewById((R.id.name));
        calback = (Button)findViewById((R.id.callback));
        drink_start = (Button)findViewById((R.id.serial_start));
        test = (TextView)findViewById(R.id.test0);
        test_button.setOnClickListener(this);
        pump_button.setOnClickListener(this);
        setButton.setOnClickListener(this);
        calback.setOnClickListener(this);
        drink_start.setOnClickListener(this);
//        test.setText();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pump_init:
               // String ddd ="/sdcard/Movies/ACDC_FlowRate.csv"; ///sdcard/Movies
               // myJNI.pumpCurveInit(ddd);
//                test.setText(myJNI.pumpCurve_init(ddd));
                break;
            case R.id.pumpRate:
                float dd = 7.31F;
                String sss = "sss:" + myJNI.pumpCurve_get(28, dd);
                test.setText(sss);
                break;
            case R.id.name:
                myJNI.printfDrinkInfo();
                myJNI.pumpCurve_set(myJNI.info);
                myJNI.printfDrinkInfo();
                break;
            case R.id.callback:
                myJNI.pumpThreadInit(myJNI);
                break;
            case R.id.serial_start:
                /*String mstrStart = "05 AA 09 00 00 3C 09 C4 00 3C 03 11";
                byte[] mbyteStart = utilFunc.HexCommandtoByte(mstrStart.getBytes());
                mcu.serialSend(mbyteStart);*/
                String buf ;
                buf = mcu.getparam("{\n" +
                        "\"command\":\"1\"\n" +
                        "}\n");
                System.out.println(buf);
                break;
        }
    }
}
