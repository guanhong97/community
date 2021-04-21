package com.lingnan.community.controller;

import com.lingnan.community.common.api.ApiResult;
import com.lingnan.community.model.dto.CommentDTO;
import com.lingnan.community.model.entity.BmsComment;
import com.lingnan.community.model.entity.UmsUser;
import com.lingnan.community.model.vo.CommentVO;
import com.lingnan.community.service.IBmsCommentService;
import com.lingnan.community.service.IUmsUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.lingnan.community.jwt.JwtUtil.USER_NAME;

/**
 * @program: community
 * @description: 评论控制类
 * @author: Mario
 * @create: 2021-04-21 17:30
 **/
@RestController
@RequestMapping("/comment")
public class BmsCommentController extends BaseController {

    @Resource
    private IBmsCommentService bmsCommentService;
    @Resource
    private IUmsUserService umsUserService;

    @GetMapping("/get_comments")
    public ApiResult<List<CommentVO>> getCommentsByTopicID(@RequestParam(value = "topicid", defaultValue = "1") String topicid) {
        List<CommentVO> lstBmsComment = bmsCommentService.getCommentsByTopicID(topicid);
        return ApiResult.success(lstBmsComment);
    }

    @PostMapping("/add_comment")
    public ApiResult<BmsComment> add_comment(@RequestHeader(value = USER_NAME) String userName,
                                             @RequestBody CommentDTO dto) {
        UmsUser user = umsUserService.getUserByUsername(userName);
        BmsComment comment = bmsCommentService.create(dto, user);
        return ApiResult.success(comment);
    }
}
