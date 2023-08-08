package com.shop.onblf.admin.member.service;

import com.shop.onblf.admin.member.dto.AdminDTO;
import com.shop.onblf.member.dto.MemberDTO;

import java.util.List;

public interface AdminMemberService {
    public boolean adminLogin(AdminDTO adminDTO);


    List<MemberDTO> getMemberList();
}
