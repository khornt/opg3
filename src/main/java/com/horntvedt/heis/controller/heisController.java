package com.horntvedt.heis.controller;

import com.horntvedt.heis.domain.Heis;
import com.horntvedt.heis.service.HeisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heis")
public class heisController {

    private final HeisService heisService;

    @Autowired
    public heisController(@Qualifier("heiskontroller") HeisService heisService) {
        this.heisService = heisService;
    }

    @RequestMapping(value="/tilkallheis/{fraEtasje}")
    public int tilkallHeis(@PathVariable int fraEtasje) {

        Heis heisen = heisService.getHeis();
        int i = heisen.flyttHeis(fraEtasje);

        return heisen.getEtasje();
    }

    @RequestMapping(value="/velgEtasje/{tilEtasje}")
    public String velgEtasje(@PathVariable int tilEtasje) {

        Heis heisen = heisService.getHeis();

        int i = heisen.leggTilStopp(tilEtasje);

        return "Heisen er fremme om " + i + " sekunder";

    }

    @RequestMapping(value="/status")
    public Heis heisstatus() {
        Heis heis = heisService.getHeis();
        return heis;
    }

    @RequestMapping(value="/alarm/")
    public Heis alarm() {
        Heis heis = heisService.getHeis();
        heis.alarm();
        return heis;
    }

}
