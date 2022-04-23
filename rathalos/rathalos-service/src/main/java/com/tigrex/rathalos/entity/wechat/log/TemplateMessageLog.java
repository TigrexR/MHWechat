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
@TableName(value = "log_template_message")
public class TemplateMessageLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "appid")
    private String appid;
    @TableField(value = "template_id")
    private String templateId;
    @TableField(value = "request_data")
    private String requestData;
    @TableField(value = "response_data")
    private String responseData;
    @TableField(value = "status")
    private Integer status;
}
