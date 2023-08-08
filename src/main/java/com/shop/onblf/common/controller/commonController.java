package com.shop.onblf.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class commonController {
    @GetMapping("/")
    public ModelAndView home() throws Exception{

        return new ModelAndView("common/page/main");
    }
}
