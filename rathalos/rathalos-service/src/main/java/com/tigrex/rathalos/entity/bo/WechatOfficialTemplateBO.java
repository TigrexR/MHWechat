package com.tigrex.rathalos.entity.bo;

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
public class WechatOfficialTemplateBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String appid;
    private String templateId;
    private String title;
    private String primaryIndustry;
    private String deputyIndustry;
}
