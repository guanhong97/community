package com.lingnan.community.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: community
 * @description: 前端评论类
 * @author: Mario
 * @create: 2021-04-21 20:56
 **/
@Data
public class CommentDTO implements Serializable {
    private static final long serialVersionUID = -5957433707110390852L;


    private String topic_id;

    /**
     * 内容
     */
    private String content;



}