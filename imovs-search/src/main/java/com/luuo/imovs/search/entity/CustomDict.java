package com.luuo.imovs.search.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_custom_dict")
public class CustomDict {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("dict_type")
    private Integer dictType;

    @TableField("last_modify_time")
    private Date lastModifyTime;

    @TableField("keyword")
    private String keyword;
}
