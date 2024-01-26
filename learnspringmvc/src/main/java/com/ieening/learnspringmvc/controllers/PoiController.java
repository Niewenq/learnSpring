package com.ieening.learnspringmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ieening.learnspringmvc.domain.dto.PoiDto;
import com.ieening.learnspringmvc.service.IPoiService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/poi")
public class PoiController {
    @Autowired
    private IPoiService poiService;

    /**
     * get hello world
     * ResponseBody 注解，表示，返回的数据放在 reponse body 中
     * 
     * @return
     */
    @GetMapping("/helloworld")
    @ResponseBody
    public String helloString() {
        return "hello world";
    }

    /**
     * 传递 get 方法参数
     * 
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public String getPoiList(@RequestParam int pageNum, @RequestParam int pageSize) {
        return "getPoiList, pageNum=" + pageNum + " pageSIze= " + pageSize;
    }

    @GetMapping("/add")
    public String getAdd(HttpServletRequest request, ModelMap map) {
        map.addAttribute("actionPath", request.getContextPath() + "/poi/add");
        map.addAttribute("method", "post");
        return "addPoi";
    }

    @PostMapping("/add")
    @ResponseBody
    public String postAdd(HttpServletRequest request, PoiDto poiDto) {
        System.out.println(poiDto);
        return "success";
    }

    /**
     * 使用路径参数传递 get 方法参数
     * 
     * @param id
     * @return
     */
    @GetMapping("/detail/{id}")
    @ResponseBody
    public String getPoiDetail(@PathVariable int id) {
        System.out.println(id);
        return "getPoiList, id=" + id;
    }

}
