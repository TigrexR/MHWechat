package com.tigrex.mh.entity.po;

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
@TableName(value = "system_menu")
public class SystemMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "code", type = IdType.NONE)
    private String code;
    @TableField(value = "name")
    private String name;
    @TableField(value = "parent_code")
    private String parentCode;
    @TableField(value = "resource_code")
    private String resourceCode;
    @TableField(value = "mark")
    private String mark;
}
