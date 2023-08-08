package com.shop.onblf.admin.member.mapper;

import com.shop.onblf.admin.member.dto.AdminDTO;
import com.shop.onblf.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMemberMapper {
    static AdminDTO selectAdminLogin(AdminDTO adminDTO){
        return adminDTO;
    }

    List<MemberDTO> selectListMember();
}
