package com.lingnan.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingnan.community.mapper.BmsBillboardMapper;
import com.lingnan.community.mapper.BmsPromotionMapper;
import com.lingnan.community.model.entity.BmsBillboard;
import com.lingnan.community.model.entity.BmsPromotion;
import com.lingnan.community.service.IBmsBillboardService;
import com.lingnan.community.service.IBmsPromotionService;
import org.springframework.stereotype.Service;

/**
 * @program: community
 * @description: 服务层公告实现类
 * @author: Mario
 * @create: 2021-04-13 20:53
 **/

@Service
public class IBmsPromotionServiceImpl extends ServiceImpl<BmsPromotionMapper
        , BmsPromotion> implements IBmsPromotionService {
}
