package com.lingnan.community.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lingnan.community.common.api.ApiResult;
import com.lingnan.community.model.entity.BmsBillboard;
import com.lingnan.community.service.IBmsBillboardService;
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
@RequestMapping("/billboard")
public class BmsBillboardController extends BaseController {

    @Resource
    private IBmsBillboardService bmsBillboardService;

    @GetMapping("/show")
    public ApiResult<BmsBillboard> getNotices(){
        List<BmsBillboard> list = bmsBillboardService.list(new
                LambdaQueryWrapper<BmsBillboard>().eq(BmsBillboard::isShow,true));
        return ApiResult.success(list.get(list.size()- 1));
    }
}
