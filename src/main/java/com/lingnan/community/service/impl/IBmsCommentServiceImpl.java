package com.lingnan.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingnan.community.mapper.BmsCommentMapper;
import com.lingnan.community.model.dto.CommentDTO;
import com.lingnan.community.model.entity.BmsComment;
import com.lingnan.community.model.entity.UmsUser;
import com.lingnan.community.model.vo.CommentVO;
import com.lingnan.community.service.IBmsCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: community
 * @description: 服务层公告实现类
 * @author: Mario
 * @create: 2021-04-13 20:53
 **/

@Slf4j
@Service
public class IBmsCommentServiceImpl extends ServiceImpl<BmsCommentMapper
        , BmsComment> implements IBmsCommentService {

    @Override
    public List<CommentVO> getCommentsByTopicID(String topicid) {
        List<CommentVO> lstBmsComment = new ArrayList<CommentVO>();
        try {
            lstBmsComment = this.baseMapper.getCommentsByTopicID(topicid);
        } catch (Exception e) {
            log.info("lstBmsComment失败");
        }
        return lstBmsComment;
    }

    @Override
    public BmsComment create(CommentDTO dto, UmsUser user) {
        BmsComment comment = BmsComment.builder()
                .userId(user.getId())
                .content(dto.getContent())
                .topicId(dto.getTopic_id())
                .createTime(new Date())
                .build();
        this.baseMapper.insert(comment);
        return comment;
    }
}
