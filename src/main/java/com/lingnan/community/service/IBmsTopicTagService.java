package com.lingnan.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lingnan.community.model.entity.BmsTag;
import com.lingnan.community.model.entity.BmsTopicTag;

import java.util.List;

public interface IBmsTopicTagService extends IService<BmsTopicTag> {
    /**
     * 获取Topic Tag 关联记录
     *
     * @param topicId TopicId
     * @return
     */
    List<BmsTopicTag> selectByTopicId(String topicId);

    /**
     * 创建中间关系
     *
     * @param id
     * @param tags
     * @return
     */
    void createTopicTag(String id, List<BmsTag> tags);
}
