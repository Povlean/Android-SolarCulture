package com.example.andriod_solar_term;

import com.example.andriod_solar_term.beans.Solar;
import com.example.andriod_solar_term.beans.User;
import com.example.andriod_solar_term.service.SolarService;
import com.example.andriod_solar_term.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AndriodSolarTermApplicationTests {

    @Autowired
    private SolarService solarService;

    @Autowired
    private UserService userService;

    @Test
    void testSearchAll() {
        List<Solar> solars = solarService.searchAll();
        for(Solar solar : solars){
            System.out.println(solar.toString());
        }
    }

    @Test
    void testAddSolar() {
        Solar solar = new Solar();
        solar.setSolarName("demo");
        solar.setDate("八月初");
        solar.setFood("康师傅");
        solarService.addSolar(solar);
    }

    @Test
    void testSearchUser() {
        String username = "Povl";
        User user = userService.searchByUsername(username);
        System.out.println(user.toString());
    }

    void testUpdate() {

    }


}
