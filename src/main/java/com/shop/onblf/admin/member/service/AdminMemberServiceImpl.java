package com.shop.onblf.admin.member.service;

import com.shop.onblf.admin.member.dto.AdminDTO;
import com.shop.onblf.admin.member.mapper.AdminMemberMapper;
import com.shop.onblf.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminMemberServiceImpl implements AdminMemberService {
    private final AdminMemberMapper adminMemberMapper;

    @Override
    public boolean adminLogin(AdminDTO adminDTO){
        if(AdminMemberMapper.selectAdminLogin(adminDTO) != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<MemberDTO> getMemberList() {
        return adminMemberMapper.selectListMember();
    }

}
