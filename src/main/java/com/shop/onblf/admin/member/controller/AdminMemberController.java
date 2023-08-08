package com.shop.onblf.admin.member.controller;

import com.shop.onblf.admin.member.dto.AdminDTO;
import com.shop.onblf.admin.member.service.AdminMemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/member")
public class AdminMemberController {
    private final AdminMemberService adminMemberService;

    @GetMapping("/adminLogin")
    public ModelAndView adminLogin() throws Exception{
        return new ModelAndView("/admin/member/adminLogin");
    }
    @PostMapping("/adminLogin")
    public ResponseEntity<Object> adminLogin(AdminDTO adminDTO, HttpServletRequest request) throws Exception{
        String message = "";

        if(adminMemberService.adminLogin(adminDTO)) {
            HttpSession session = request.getSession();
            session.setAttribute("adminId", adminDTO.getAdminId());
            session.setAttribute("role", "admin");
            session.setMaxInactiveInterval(60 * 30);

            message = "<script>";
            message += "location.href='" + request.getContextPath() + "/';";
        }
        else {
            message = "<script>";
            message += "alert('아이디와 비밀번호를 확인해주세요.');";
            message += "history.go(-1);";
        }
        message += "</script>";

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=utf-8");

        return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/adminMemberList")
    public ModelAndView adminMemberList(HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("/admin/member/adminMemberList");

        HttpSession session = request.getSession();
        session.setAttribute("sideMenu", "adminMode");

        mv.addObject("memberList", adminMemberService.getMemberList());
        return mv;
    }

}
