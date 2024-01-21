package com.ieening.learnspringmvc.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ieening.learnspringmvc.domain.po.Poi;
import com.ieening.learnspringmvc.mapper.PoiMapper;
import com.ieening.learnspringmvc.service.IPoiService;

@Service
public class PoiService extends ServiceImpl<PoiMapper, Poi> implements IPoiService {

}
