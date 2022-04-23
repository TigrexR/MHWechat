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
@TableName(value = "wechat_official_account")
public class WechatOfficialAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "appid", type = IdType.NONE)
    private String appid;
    @TableField(value = "secret")
    private String secret;
    @TableField(value = "original_id")
    private String originalId;
    @TableField(value = "wechat_code")
    private String wechatCode;
    @TableField(value = "wechat_name")
    private String wechatName;
    @TableField(value = "type")
    private String type;
    @TableField(value = "mark")
    private String mark;
}
