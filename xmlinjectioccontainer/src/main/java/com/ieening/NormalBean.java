package com.ieening;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NormalBean {

    private Integer attributeInteger;
    private String attributeString;
    private Date attributeDate;
    private String[] attributeStringArray;
    private Set<String> attributeStringSet;
    private List<String> attributeStringList;
    private Map<String, String> attributeMap;
    private Properties attributeProperties;

    private CustomBean customBean;

    public NormalBean(CustomBean customBean) {
        this.customBean = customBean;
    }

    public static NormalBean createInstance(CustomBean customBean) {
        return new NormalBean(customBean);
    }
}
