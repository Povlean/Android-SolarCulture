package com.example.android_solar_term.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName tbl_solar
 */
@TableName(value ="tbl_solar")
@Data
public class Solar implements Serializable {
    /**
     * 标识id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 节气名字
     */
    @TableField(value = "solar_name")
    private String solarName;

    /**
     * 农历时间
     */
    @TableField(value = "date")
    private String date;

    /**
     * 时节描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 图片路径
     */
    @TableField(value = "url")
    private String url;

    /**
     * 食物

     */
    @TableField(value = "food")
    private String food;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}