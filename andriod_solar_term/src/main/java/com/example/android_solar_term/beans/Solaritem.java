package com.example.android_solar_term.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName tbl_solaritem
 */
@TableName(value ="tbl_solaritem")
@Data
public class Solaritem implements Serializable {
    /**
     * 
     */
    @TableField(value = "solarname")
    private String solarname;

    /**
     * 
     */
    @TableField(value = "solarimg")
    private Integer solarimg;

    /**
     * 
     */
    @TableField(value = "description")
    private String description;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Solaritem(String solarname, Integer solarimg) {
        this.solarname = solarname;
        this.solarimg = solarimg;
    }

    public Solaritem() {
    }

}