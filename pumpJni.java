package com.intretech.pump;

import java.util.Objects;

/**
 * Created by hasee on 2018/3/18.
 */

public class pumpJni {
    static {
        System.loadLibrary("jnipumpcurve");
        //pumpThreadInit();
    }
    public drinkInfo info;
/*    native方法*/
    public static native String getVersion();
    public static native void pumpCurveInit(String src);
    public static native float pumpCurve_get(int id, float rate);
    public static native float pumpCurve_set(drinkInfo info);
    public static native int[][] pumpGetArray(int num);
    public static native void pumpThreadInit(pumpJni ss);
    public void pumpcallback(String fromNative) {
        System.out.println("##########11111#########"+ fromNative);
    }

    public void printfDrinkInfo(){
        System.out.println("###################"+this.info.getname());
    }
    pumpJni() {
        info = new drinkInfo();
    }
}
