package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:VbisoWen
 * @Description:
 * @Date:Create in 22:24 2017/10/1
 * @Modified By:
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String showHome() {
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
