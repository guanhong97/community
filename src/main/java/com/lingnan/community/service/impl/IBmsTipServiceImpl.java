package com.lingnan.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingnan.community.mapper.BmsBillboardMapper;
import com.lingnan.community.mapper.BmsTipMapper;
import com.lingnan.community.model.entity.BmsBillboard;
import com.lingnan.community.model.entity.BmsTip;
import com.lingnan.community.service.IBmsBillboardService;
import com.lingnan.community.service.IBmsTipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @program: community
 * @description: 服务层公告实现类
 * @author: Mario
 * @create: 2021-04-13 20:53
 **/

@Slf4j
@Service
public class IBmsTipServiceImpl extends ServiceImpl<BmsTipMapper
        , BmsTip> implements IBmsTipService {

    @Override
    public BmsTip getRandomTip() {
        BmsTip todayTip = null;
        try {
            todayTip = this.baseMapper.getRandomTip();
        }catch (Exception e){
            log.info("tip转化失败");
        }
        return todayTip;
    }
}
