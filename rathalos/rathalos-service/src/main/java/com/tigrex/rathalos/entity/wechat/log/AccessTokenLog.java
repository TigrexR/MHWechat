package com.tigrex.rathalos.entity.wechat.log;

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
@TableName(value = "log_access_token")
public class AccessTokenLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "grant_type")
    private String grantType;
    @TableField(value = "appid")
    private String appid;
    @TableField(value = "secret")
    private String secret;
    @TableField(value = "response_data")
    private String responseData;
    @TableField(value = "status")
    private Integer status;
}
