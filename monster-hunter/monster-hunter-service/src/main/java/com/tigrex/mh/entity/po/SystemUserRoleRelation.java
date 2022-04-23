package com.tigrex.mh.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName(value = "system_user_role_relation")
public class SystemUserRoleRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField(value = "user_code")
    private String userCode;
    @TableField(value = "role_code")
    private String roleCode;
}
