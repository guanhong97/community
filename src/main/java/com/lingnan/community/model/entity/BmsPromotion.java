package com.lingnan.community.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: community
 * @description: 推送类
 * @author: Mario
 * @create: 2021-04-14 18:14
 **/

@Data
@Builder
@Accessors(chain = true)
@TableName("bms_promotion")
@NoArgsConstructor
@AllArgsConstructor
public class BmsPromotion implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 广告标题
     */
    @TableField("title")
    private String title;

    /**
     * 链接
     */
    @TableField("link")
    private String link;

    /**
     * 描述
     */
    @TableField("description")
    private String description;



}
