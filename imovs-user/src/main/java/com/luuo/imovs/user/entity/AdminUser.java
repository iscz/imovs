package com.luuo.imovs.user.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 后台用户表
 * </p>
 *
 * @author luuo
 * @since 2020-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_admin_user")
public class AdminUser implements Serializable {


    /**
     * 主键编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户账号
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户密码
     */
    @TableField("user_pwd")
    private String userPwd;

    /**
     * 用户手机号
     */
    @TableField("user_phone")
    private String userPhone;

}
