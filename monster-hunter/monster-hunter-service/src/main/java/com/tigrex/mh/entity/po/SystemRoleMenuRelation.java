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
@TableName(value = "system_role_menu_relation")
public class SystemRoleMenuRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField(value = "role_code")
    private String roleCode;
    @TableField(value = "menu_code")
    private String menuCode;
}
