package com.lingnan.community.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lingnan.community.common.api.ApiResult;
import com.lingnan.community.model.entity.BmsBillboard;
import com.lingnan.community.model.entity.BmsTip;
import com.lingnan.community.service.IBmsBillboardService;
import com.lingnan.community.service.IBmsTipService;
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
@RequestMapping("/tip")
public class BmsTipController extends BaseController {

    @Resource
    private IBmsTipService bmsTipService;

    @GetMapping("/today")
    public ApiResult<BmsTip> getNotices(){
        BmsTip tip = bmsTipService.getRandomTip();
        return ApiResult.success(tip);
    }
}
