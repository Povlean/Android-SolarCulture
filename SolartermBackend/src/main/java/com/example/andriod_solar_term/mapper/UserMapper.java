package com.example.andriod_solar_term.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.andriod_solar_term.beans.User;
import org.apache.ibatis.annotations.Mapper;


/**
* @author Asphyxia
* @description 针对表【tbl_user】的数据库操作Mapper
* @createDate 2022-12-23 22:41:26
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




