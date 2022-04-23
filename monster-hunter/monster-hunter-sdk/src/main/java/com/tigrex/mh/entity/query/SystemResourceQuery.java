package com.tigrex.mh.entity.query;

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
public class SystemResourceQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private String name;
    private String parentCode;
    private String type;
    private String url;
    private String mark;
}
