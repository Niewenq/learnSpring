package com.ieening.learnspringmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ieening.learnspringmvc.service.IPoiService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/poi")
public class PoiController {
    @Autowired
    private IPoiService poiService;

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
        map.addAttribute("actionPath", request.getContextPath() + "/poi/helloworld");
        map.addAttribute("method", "get");
        return "addPoi";
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
