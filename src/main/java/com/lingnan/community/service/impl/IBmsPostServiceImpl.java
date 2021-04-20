package com.lingnan.community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingnan.community.mapper.BmsTagMapper;
import com.lingnan.community.mapper.BmsTopicMapper;
import com.lingnan.community.mapper.UmsUserMapper;
import com.lingnan.community.model.dto.CreateTopicDTO;
import com.lingnan.community.model.entity.BmsPost;
import com.lingnan.community.model.entity.BmsTag;
import com.lingnan.community.model.entity.BmsTopicTag;
import com.lingnan.community.model.entity.UmsUser;
import com.lingnan.community.model.vo.PostVO;
import com.lingnan.community.service.IBmsPostService;
import com.lingnan.community.service.IBmsTagService;
import com.vdurmont.emoji.EmojiParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class IBmsPostServiceImpl extends ServiceImpl<BmsTopicMapper, BmsPost> implements IBmsPostService {
    @Resource
    private BmsTagMapper bmsTagMapper;

    @Resource
    private UmsUserMapper umsUserMapper;

    @Autowired
    @Lazy
    private IBmsTagService iBmsTagService;

    @Autowired
    private com.lingnan.community.service.IBmsTopicTagService IBmsTopicTagService;
    @Override
    public Page<PostVO> getList(Page<PostVO> page, String tab) {
        // 查询话题
        Page<PostVO> iPage = this.baseMapper.selectListAndPage(page, tab);
        // 查询话题的标签
        iPage.getRecords().forEach(topic -> {
            List<BmsTopicTag> topicTags = IBmsTopicTagService.selectByTopicId(topic.getId());
            if (!topicTags.isEmpty()) {
                List<String> tagIds = topicTags.stream().map(BmsTopicTag::getTagId).collect(Collectors.toList());
                List<BmsTag> tags = bmsTagMapper.selectBatchIds(tagIds);
                topic.setTags(tags);
            }
        });
        return iPage;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public BmsPost create(CreateTopicDTO dto, UmsUser user) {
        BmsPost topic1 = this.baseMapper.selectOne(new LambdaQueryWrapper<BmsPost>().eq(BmsPost::getTitle, dto.getTitle()));
        Assert.isNull(topic1, "话题已存在，请修改");

        // 封装
        BmsPost topic = BmsPost.builder()
                .userId(user.getId())
                .title(dto.getTitle())
                .content(EmojiParser.parseToAliases(dto.getContent()))
                .createTime(new Date())
                .build();
        this.baseMapper.insert(topic);

        // 用户积分增加
        int newScore = user.getScore() + 1;
        umsUserMapper.updateById(user.setScore(newScore));

        // 标签
        if (!ObjectUtils.isEmpty(dto.getTags())) {
            // 保存标签
            List<BmsTag> tags = iBmsTagService.insertTags(dto.getTags());
            // 处理标签与话题的关联
            IBmsTopicTagService.createTopicTag(topic.getId(), tags);
        }

        return topic;
    }
}