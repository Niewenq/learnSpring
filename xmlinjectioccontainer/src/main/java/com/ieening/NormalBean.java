package com.ieening;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.Data;

@Data
public class NormalBean {

    private Integer attributeInteger;
    private String attributeString;
    private Date attributeDate;
    private String[] attributeStringArray;
    private Set<String> attributeStringSet;
    private List<String> attributeStringList;
    private Map<String, String> attributeMap;
    private Properties attributeProperties;

    public NormalBean() {

    }

}
