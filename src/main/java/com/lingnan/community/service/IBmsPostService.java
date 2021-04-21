package com.lingnan.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lingnan.community.model.dto.CreateTopicDTO;
import com.lingnan.community.model.entity.BmsPost;
import com.lingnan.community.model.entity.UmsUser;
import com.lingnan.community.model.vo.PostVO;

import java.util.Map;

public interface IBmsPostService extends IService<BmsPost> {
    /**
     * 获取首页话题列表
     *
     * @param page
     * @param tab
     * @return
     */
    Page<PostVO> getList(Page<PostVO> page, String tab);

    /**
     * 发布
     *
     * @param dto
     * @param principal
     * @return
     */
    BmsPost create(CreateTopicDTO dto, UmsUser principal);

    /**
     * 查看话题详情
     *
     * @param id
     * @return
     */
    Map<String, Object> viewTopic(String id);
}
