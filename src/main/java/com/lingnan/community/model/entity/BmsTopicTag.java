package com.lingnan.community.model.entity;

/**
 * @program: community
 * @description: 数据库标签帖子联合类
 * @author: Mario
 * @create: 2021-04-18 17:11
 **/
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@TableName("bms_post_tag")
@Accessors(chain = true)
public class BmsTopicTag implements Serializable {
    private static final long serialVersionUID = -5028599844989220715L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("tag_id")
    private String tagId;

    @TableField("topic_id")
    private String topicId;
}