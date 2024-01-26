package com.ieening.learnspringmvc.domain.dto;

import lombok.Data;

@Data
public class PoiDto {
    private Integer id;
    private String name;
    private String description;
    private float longitude;
    private float latitude;
    private String image;
}
