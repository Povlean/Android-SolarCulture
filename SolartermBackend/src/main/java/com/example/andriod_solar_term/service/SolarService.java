package com.example.andriod_solar_term.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.andriod_solar_term.beans.Solar;

import java.util.List;

/**
* @author Asphyxia
* @description 针对表【tbl_solar】的数据库操作Service
* @createDate 2022-12-23 10:08:29
*/
public interface SolarService extends IService<Solar> {
    List<Solar> searchAll();

    void addSolar(Solar solar);

    Solar searchByName();
}
