package com.lingnan.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingnan.community.mapper.BmsBillboardMapper;
import com.lingnan.community.model.entity.BmsBillboard;
import com.lingnan.community.service.IBmsBillboardService;
import org.springframework.stereotype.Service;

/**
 * @program: community
 * @description: 服务层公告实现类
 * @author: Mario
 * @create: 2021-04-13 20:53
 **/

@Service
public class IBmsBillboardServiceImpl extends ServiceImpl<BmsBillboardMapper
        , BmsBillboard> implements IBmsBillboardService {
}
