package com.ieening.learnspringmvc.domain.po;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("`poi_table`")
// @Repository
public class Poi {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private float longitude;
    private float latitude;
    private String coverUrl;
}
