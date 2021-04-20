package com.lingnan.community.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: community
 * @description: 前端建立帖子类
 * @author: Mario
 * @create: 2021-04-20 17:50
 **/
@Data
public class CreateTopicDTO implements Serializable {
    private static final long serialVersionUID = -5957433707110390852L;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签
     */
    private List<String> tags;

}
