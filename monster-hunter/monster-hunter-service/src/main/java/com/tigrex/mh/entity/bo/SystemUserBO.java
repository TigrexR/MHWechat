package com.tigrex.mh.entity.bo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author linus
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SystemUserBO implements Serializable{

    private static final long serialVersionUID = 1L;

    private String code;
    private String name;
    private String password;
    private String phone;
    private String email;
    private String idCode;
    private Integer status;
}
