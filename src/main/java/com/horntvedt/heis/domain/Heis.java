package com.horntvedt.heis.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.horntvedt.heis.state.Heistilstand;

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

    @JsonProperty(value = "heistur")
    HeisTur heisTur;

    public Heis(int hastighet, String id) {

        alarm = false;
        heisId = id;
        tilstand = Heistilstand.LEDIG;
        etasje = 1;
        sekunderEtasje = hastighet; //heisen hastighet
        heisTur = new HeisTur();

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

    private void turUtfoert(int etasje) {

        List<Integer> stoppliste  = this.heisTur.getStoppliste();
        stoppliste.remove(stoppliste.indexOf(etasje));

    }

    public int leggTilStopp(int etasje) {

        List<Integer> stoppliste  = this.heisTur.getStoppliste();


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
