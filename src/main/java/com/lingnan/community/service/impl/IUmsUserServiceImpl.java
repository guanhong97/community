package com.lingnan.community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingnan.community.common.exception.ApiAsserts;
import com.lingnan.community.mapper.BmsTipMapper;
import com.lingnan.community.mapper.UmsUserMapper;
import com.lingnan.community.model.dto.RegisterDTO;
import com.lingnan.community.model.entity.BmsTip;
import com.lingnan.community.model.entity.UmsUser;
import com.lingnan.community.service.IBmsTipService;
import com.lingnan.community.service.IUmsUserService;
import com.lingnan.community.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;

/**
 * @program: community
 * @description: 服务层公告实现类
 * @author: Mario
 * @create: 2021-04-13 20:53
 **/

@Slf4j
@Service
public class IUmsUserServiceImpl extends ServiceImpl<UmsUserMapper
        , UmsUser> implements IUmsUserService {


    @Override
    public UmsUser executeRegister(RegisterDTO dto) {
        //查询是否有相同用户名的用户
        LambdaQueryWrapper<UmsUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UmsUser::getUsername, dto.getName()).or().eq(UmsUser::getEmail, dto.getEmail());
        UmsUser umsUser = baseMapper.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(umsUser)) {
            ApiAsserts.fail("账号或邮箱已存在！");
        }
        UmsUser addUser = UmsUser.builder()
                .username(dto.getName())
                .alias(dto.getName())
                .password(MD5Utils.getPwd(dto.getPass()))
                .email(dto.getEmail())
                .createTime(new Date())
                .status(true)
                .build();
        baseMapper.insert(addUser);

        return addUser;
    }

}
