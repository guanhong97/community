package com.lingnan.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lingnan.community.model.entity.BmsTip;

public interface IBmsTipService extends IService<BmsTip> {
    BmsTip getRandomTip();
}
