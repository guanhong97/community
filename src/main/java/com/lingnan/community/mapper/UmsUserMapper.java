package com.lingnan.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lingnan.community.model.dto.LoginDTO;
import com.lingnan.community.model.dto.RegisterDTO;
import com.lingnan.community.model.entity.BmsTip;
import com.lingnan.community.model.entity.UmsUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UmsUserMapper extends BaseMapper<UmsUser> {
}
