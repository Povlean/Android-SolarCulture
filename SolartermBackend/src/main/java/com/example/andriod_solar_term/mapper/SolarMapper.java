package com.example.andriod_solar_term.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.andriod_solar_term.beans.Solar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
* @author Asphyxia
* @description 针对表【tbl_solar】的数据库操作Mapper
* @createDate 2022-12-23 10:08:29
* @Entity generator.domain.Solar
*/
@Mapper
public interface SolarMapper extends BaseMapper<Solar> {

    List<Solar> searchAll();

    void addSolar(Solar solar);

}




