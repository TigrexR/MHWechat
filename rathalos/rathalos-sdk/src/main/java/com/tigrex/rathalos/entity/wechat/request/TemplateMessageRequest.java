package com.tigrex.rathalos.entity.wechat.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * @author linus
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TemplateMessageRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String appid;
    private String templateId;
    private String touser;
    private String url;
    private MiniProgram miniprogram;
    private Map<String, MessageData> data;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class MiniProgram implements Serializable {
        private static final long serialVersionUID = 1L;

        private String appid;
        private String pagepath;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class MessageData implements Serializable {
        private static final long serialVersionUID = 1L;

        private String value;
        private String color;
    }
}
