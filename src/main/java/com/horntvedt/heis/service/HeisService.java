package com.horntvedt.heis.service;

import org.springframework.stereotype.Service;

import com.horntvedt.heis.domain.Heis;


public class HeisService {

    Heis heis;

    public HeisService(int hastighet, String id) {

        //todo: Støtte for flere heiser
        this.heis = new Heis(hastighet, "A");
        System.out.println("Heisen står i " + this.heis.getEtasje());
        System.out.println("Status til heisen " + this.heis.heistilstand());

    }

    public Heis getHeis() {
        return heis;
    }



}