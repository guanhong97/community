package com.lingnan.community.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lingnan.community.common.api.ApiResult;
import com.lingnan.community.model.entity.BmsBillboard;
import com.lingnan.community.model.entity.BmsPromotion;
import com.lingnan.community.service.IBmsBillboardService;
import com.lingnan.community.service.IBmsPromotionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: community
 * @description: 公告栏控制层
 * @author: Mario
 * @create: 2021-04-13 21:19
 **/

@RestController
@RequestMapping("/promotion")
public class BmsPromotionController extends BaseController {

    @Resource
    private IBmsPromotionService bmsPromotionService;

    @GetMapping("/all")
    public ApiResult<List<BmsPromotion>> list(){
        List<BmsPromotion> list = bmsPromotionService.list();
        return ApiResult.success(list);
    }
}
