package com.intretech.pump;

import android.util.Log;

/**
 * Created by hasee on 2018/4/12.
 */

public class serialMcu {

    static {
        System.loadLibrary("intrecom");
    }

    /*native方法*/
    public static native String getVersion();
    public static native void  serialInit(serialMcu info);
    public static native boolean serialSend(byte[] data);
    public static native String getparam(String data);

    public void serialCallBack(String data) {
        System.out.println("##########11111#########"+ data);
    }
}
