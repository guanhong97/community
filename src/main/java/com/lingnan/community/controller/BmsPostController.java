package com.lingnan.community.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lingnan.community.common.api.ApiResult;
import com.lingnan.community.model.dto.CreateTopicDTO;
import com.lingnan.community.model.entity.BmsPost;
import com.lingnan.community.model.entity.UmsUser;
import com.lingnan.community.model.vo.PostVO;
import com.lingnan.community.service.IBmsPostService;
import com.lingnan.community.service.IUmsUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

import static com.lingnan.community.jwt.JwtUtil.USER_NAME;

/**
 * @program: community
 * @description: 帖子控制类
 * @author: Mario
 * @create: 2021-04-19 22:19
 **/
@RestController
@RequestMapping("/post")
public class BmsPostController extends BaseController {

    @Resource
    private IBmsPostService iBmsPostService;

    @Resource
    private IUmsUserService umsUserService;

    @GetMapping("/list")
    public ApiResult<Page<PostVO>> list(@RequestParam(value = "tab", defaultValue = "latest") String tab,
                                        @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                        @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {
        Page<PostVO> list = iBmsPostService.getList(new Page<>(pageNo, pageSize), tab);
        return ApiResult.success(list);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResult<BmsPost> create(@RequestHeader(value = USER_NAME) String userName
            , @RequestBody CreateTopicDTO dto) {
        UmsUser user = umsUserService.getUserByUsername(userName);
        BmsPost topic = iBmsPostService.create(dto, user);
        return ApiResult.success(topic);
    }

    @GetMapping()
    public ApiResult<Map<String, Object>> view(@RequestParam("id") String id) {
        Map<String, Object> map = iBmsPostService.viewTopic(id);
        return ApiResult.success(map);
    }

}