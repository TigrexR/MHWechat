package com.tigrex.rathalos.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author linus
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "wechat_official_template")
public class WechatOfficialTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    @TableField(value = "appid")
    private String appid;
    @TableField(value = "template_id")
    private String templateId;
    @TableField(value = "title")
    private String title;
    @TableField(value = "primary_industry")
    private String primaryIndustry;
    @TableField(value = "deputy_industry")
    private String deputyIndustry;
}
