package com.example.android_solar_term.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.android_solar_term.beans.Solaritem;

import java.util.List;


/**
* @author Asphyxia
* @description 针对表【tbl_solaritem】的数据库操作Service
* @createDate 2022-12-29 10:09:21
*/
public interface SolaritemService extends IService<Solaritem> {
    List<Solaritem> searchAllItems();

    void addSolaritem(Solaritem solaritem);

    void deleteSolaritem(String solarName);

    void updateSolaritem(Solaritem solaritem);
}
