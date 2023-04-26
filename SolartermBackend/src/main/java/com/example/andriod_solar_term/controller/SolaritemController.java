package com.example.andriod_solar_term.controller;

import com.example.andriod_solar_term.beans.Solar;
import com.example.andriod_solar_term.beans.Solaritem;
import com.example.andriod_solar_term.service.SolaritemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:TODO
 * @author:Povlean
 */
@RestController
@RequestMapping("/solaritem")
public class SolaritemController {

    @Autowired
    private SolaritemService solaritemService;

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public List<Solaritem> searchAllItems() {
        return solaritemService.searchAllItems();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addSolaritem(@RequestBody Solaritem solaritem) {
        if(solaritem == null) {
            return;
        }
        solaritemService.save(solaritem);
    }

    @RequestMapping(value = "/delete/{solarName}",method = RequestMethod.GET)
    public void deleteSolaritem(@PathVariable String solarName) {
        if (solarName == null){
            return;
        }
        solaritemService.deleteSolaritem(solarName);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void updateSolaritem(@RequestBody Solaritem solaritem) {
        if(solaritem == null) {
            return;
        }
        solaritemService.updateSolaritem(solaritem);
    }

}
