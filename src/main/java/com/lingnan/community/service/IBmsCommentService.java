package com.lingnan.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lingnan.community.model.dto.CommentDTO;
import com.lingnan.community.model.entity.BmsComment;
import com.lingnan.community.model.entity.UmsUser;
import com.lingnan.community.model.vo.CommentVO;

import java.util.List;

public interface IBmsCommentService extends IService<BmsComment> {
    /**
     *
     *
     * @param topicid
     * @return {@link BmsComment}
     */
    List<CommentVO> getCommentsByTopicID(String topicid);

    BmsComment create(CommentDTO dto, UmsUser user);
}
