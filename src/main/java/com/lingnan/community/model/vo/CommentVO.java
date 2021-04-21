package com.lingnan.community.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @program: community
 * @description: 前端评论类
 * @author: Mario
 * @create: 2021-04-21 17:23
 **/
@Data
public class CommentVO {

    private String id;

    private String content;

    private String topicId;

    private String userId;

    private String username;

    private Date createTime;

}