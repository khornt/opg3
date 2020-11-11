package com.horntvedt.heis.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.ArrayList;
import java.util.List;

public class HeisTur {


    @JsonProperty(value = "stopper")
    List<Integer> stoppliste;

    private int tilEtasje;

    public List<Integer> getStoppliste() {

        if (stoppliste == null) {
            stoppliste = new ArrayList<>();
        }
        return stoppliste;
    }

    public void setStoppliste(List<Integer> stoppliste) {
        this.stoppliste = stoppliste;
    }


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
