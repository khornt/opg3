package com.horntvedt.heis.service;

public class HeisTur {

    private int tilEtasje;

    private String retning; //enum

    public String getRetning() {
        return retning;
    }

    public void setRetning(String retning) {
        this.retning = retning;
    }

    public int getTilEtasje() {
        return tilEtasje;
    }

    public void setTilEtasje(int tilEtasje) {
        tilEtasje = tilEtasje;
    }


}
