package com.example.android_solar_term.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.android_solar_term.beans.Solar;
import com.example.android_solar_term.mapper.SolarMapper;
import com.example.android_solar_term.service.SolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Asphyxia
* @description 针对表【tbl_solar】的数据库操作Service实现
* @createDate 2022-12-23 10:08:29
*/
@Service
public class SolarServiceImpl extends ServiceImpl<SolarMapper, Solar>
    implements SolarService {

    @Autowired
    private SolarMapper solarMapper;

    @Override
    public List<Solar> searchAll() {
        List<Solar> solarList = this.list();
        return solarList;
    }

    @Override
    public void addSolar(Solar solar) {
        this.save(solar);
    }

    @Override
    public Solar searchByName() {
        return null;
    }
}




