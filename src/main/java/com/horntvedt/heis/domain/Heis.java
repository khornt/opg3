package com.horntvedt.heis.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.horntvedt.heis.state.Heistilstand;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Heis {

    @JsonProperty(value = "tilstand")
    Heistilstand tilstand;

    @JsonProperty(value = "heisId")
    String heisId;

    @JsonProperty(value = "alarm")
    Boolean alarm;

    @JsonProperty(value = "etasje")
    int etasje;

    @JsonProperty(value = "hastighet")
    int sekunderEtasje;

    @JsonProperty(value = "stopper")
    List<Integer> stoppliste;


    public Heis(int hastighet, String id) {

        alarm = false;
        heisId = id;
        tilstand = Heistilstand.LEDIG;
        etasje = 1;
        sekunderEtasje = hastighet; //heisen hastighet
        stoppliste = new ArrayList<>();

    }

    public Heistilstand heistilstand() {

        return tilstand;
    }

    public int nodStop() {
        tilstand = Heistilstand.ERROR;
        alarm = true;
        return etasje;
    }

    public int getEtasje() {
        return etasje;
    }



    public int flyttHeis(int tilEtasje) {


        if (etasje < tilEtasje) {
           tilstand = Heistilstand.OPP;
        } else if (etasje > tilEtasje) {
           tilstand = Heistilstand.NED;
        } else {
           tilstand = Heistilstand.STILLE;
        }

        int tid = tidTilGittEtasje(tilEtasje);
        etasje = tilEtasje;
        return tid;

    }

    public int leggTilStopp(int etasje) {

        if (!stoppliste.contains(etasje)) {
            stoppliste.add(etasje);
        }
        return tidTilGittEtasje(etasje);
    }

    public void alarm() {
        alarm = true;
    }

    private int tidTilGittEtasje(int angittEtasje) {

        //hva med abs-verdi?
        if (angittEtasje > etasje) {
            return (angittEtasje - etasje) * this.sekunderEtasje;

        } else {
            return (etasje - angittEtasje) * this.sekunderEtasje;
        }
    }


}
