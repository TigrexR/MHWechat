package com.tigrex.rathalos.entity.dto;

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
public class WechatOfficialAccountDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String appid;
    private String secret;
    private String originalId;
    private String wechatCode;
    private String wechatName;
    private String type;
    private String mark;
}
