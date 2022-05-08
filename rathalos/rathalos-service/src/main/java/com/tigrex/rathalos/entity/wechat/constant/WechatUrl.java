package com.tigrex.rathalos.entity.wechat.constant;

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
@Accessors
public class WechatUrl implements Serializable {

    private static final long serialVersionUID = 1L;

    private String host;
    private String token;
    private String messageTemplateSend;
    private String dsUrl;
}
