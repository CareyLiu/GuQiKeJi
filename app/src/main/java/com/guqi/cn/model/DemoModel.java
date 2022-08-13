package com.guqi.cn.model;

public class DemoModel {

    private String xingMing;//姓名
    private String nianLing;//年龄
    private String xingBie;//性别


    public String getXingMing() {
        return xingMing;
    }

    public void setXingMing(String xingMing) {
        this.xingMing = xingMing;
    }

    public String getNianLing() {
        return nianLing;
    }

    public void setNianLing(String nianLing) {
        this.nianLing = nianLing;
    }

    public String getXingBie() {
        return xingBie;
    }

    public void setXingBie(String xingBie) {
        this.xingBie = xingBie;
    }


    @Override
    public String toString() {
        return "DemoModel{" +
                "xingMing='" + xingMing + '\'' +
                ", nianLing='" + nianLing + '\'' +
                ", xingBie='" + xingBie + '\'' +
                '}';
    }
}
