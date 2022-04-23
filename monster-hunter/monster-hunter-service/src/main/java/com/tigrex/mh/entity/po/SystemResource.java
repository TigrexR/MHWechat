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
@TableName(value = "system_resource")
public class SystemResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "code", type = IdType.NONE)
    private String code;
    @TableField(value = "name")
    private String name;
    @TableField(value = "parent_code")
    private String parentCode;
    @TableField(value = "type")
    private String type;
    @TableField(value = "url")
    private String url;
    @TableField(value = "mark")
    private String mark;
}
