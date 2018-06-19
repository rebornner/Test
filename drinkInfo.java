package com.intretech.pump;

/**
 * Created by hasee on 2018/3/23.
 */

class drinkInfo {
    private int ProductID;
    private int WaterRate;
    private int ConcentrasteRate;
    public  String name = "init";

    public int getProductID() {
        return this.ProductID;
    }

    public int getWaterRate(){
        return this.WaterRate;
    }
    public int getConcentrasteRate(){
        return this.ConcentrasteRate;
    }
    public String getname(){
        return this.name;
    }
}
