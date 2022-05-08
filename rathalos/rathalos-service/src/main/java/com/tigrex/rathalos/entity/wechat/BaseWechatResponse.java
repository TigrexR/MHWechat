package com.tigrex.rathalos.entity.wechat;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class BaseWechatResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "errcode")
    private Integer errCode;
    @JsonProperty(value = "errmsg")
    private String errMsg;
    @JsonProperty(value = "msgid")
    private Long msgId;
}
