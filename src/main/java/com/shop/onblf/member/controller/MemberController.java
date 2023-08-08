package com.shop.onblf.member.controller;

import com.shop.onblf.member.service.MemberService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/client/member")
public class MemberController {
    private MemberService memberService;

    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("/client/member/register");
    }

}
