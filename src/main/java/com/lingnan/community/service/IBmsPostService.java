package com.lingnan.community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lingnan.community.model.entity.BmsPost;
import com.lingnan.community.model.vo.PostVO;

public interface IBmsPostService extends IService<BmsPost> {
    /**
     * 获取首页话题列表
     *
     * @param page
     * @param tab
     * @return
     */
    Page<PostVO> getList(Page<PostVO> page, String tab);
}
