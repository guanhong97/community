package com.lingnan.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lingnan.community.model.dto.LoginDTO;
import com.lingnan.community.model.dto.RegisterDTO;
import com.lingnan.community.model.entity.BmsTip;
import com.lingnan.community.model.entity.UmsUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UmsUserMapper extends BaseMapper<UmsUser> {
    /**
     * 注册功能
     *
     * @param dto
     * @return 注册对象
     */
    UmsUser executeRegister(RegisterDTO dto);

    /**
     * 获取用户信息
     *
     * @param username
     * @return dbUser
     */
    UmsUser getUserByUsername(String username);
    /**
     * 用户登录
     *
     * @param dto
     * @return 生成的JWT的token
     */
    String executeLogin(LoginDTO dto);
}
