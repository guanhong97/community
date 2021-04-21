package com.lingnan.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingnan.community.mapper.BmsFollowMapper;
import com.lingnan.community.model.entity.BmsFollow;
import com.lingnan.community.service.IBmsFollowService;
import org.springframework.stereotype.Service;

/**
 * @program: community
 * @description: 服务层公告实现类
 * @author: Mario
 * @create: 2021-04-13 20:53
 **/

@Service
public class IBmsFollowServiceImpl extends ServiceImpl<BmsFollowMapper
        , BmsFollow> implements IBmsFollowService {
}
