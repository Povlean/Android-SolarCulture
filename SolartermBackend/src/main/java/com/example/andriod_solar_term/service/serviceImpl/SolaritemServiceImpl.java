package com.example.andriod_solar_term.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.andriod_solar_term.beans.Solar;
import com.example.andriod_solar_term.beans.Solaritem;
import com.example.andriod_solar_term.mapper.SolaritemMapper;
import com.example.andriod_solar_term.service.SolaritemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Asphyxia
* @description 针对表【tbl_solaritem】的数据库操作Service实现
* @createDate 2022-12-29 10:09:21
*/
@Service
public class SolaritemServiceImpl extends ServiceImpl<SolaritemMapper, Solaritem>
    implements SolaritemService {

    @Autowired
    private SolaritemMapper solaritemMapper;

    @Override
    public List<Solaritem> searchAllItems() {
        List<Solaritem> solarList = this.list();
        return solarList;
    }

    @Override
    public void addSolaritem(Solaritem solaritem) {
        if(solaritem == null) {
            return;
        }
        this.save(solaritem);
    }

    @Override
    public void deleteSolaritem(String solarName) {
        if(solarName == null) {
            return;
        }
        LambdaQueryWrapper<Solaritem> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Solaritem::getSolarname,solarName);
        this.remove(queryWrapper);
    }

    @Override
    public void updateSolaritem(Solaritem solaritem) {
        if(solaritem == null) {
            return;
        }
        LambdaQueryWrapper<Solaritem> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Solaritem::getSolarname,solaritem.getSolarname());
        this.update(solaritem,queryWrapper);
    }

}




