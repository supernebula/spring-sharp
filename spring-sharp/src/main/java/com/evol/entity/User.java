package com.evol.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author evol
 * @since 2023-05-13
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("user")
@ApiModel(value = "User对象", description = "用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("密码盐")
    @TableField("salt")
    private String salt;

    @ApiModelProperty("余额（单位：分）")
    @TableField("balance")
    private Integer balance;

    @ApiModelProperty("昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty("openId")
    @TableField("open_id")
    private String openId;

    @ApiModelProperty("Wx Access Token ")
    @TableField("access_token")
    private String accessToken;

    @ApiModelProperty("Wx Access Token 过期时间")
    @TableField("token_expires_in")
    private LocalDateTime tokenExpiresIn;

    @ApiModelProperty("Wx Refresh Token")
    @TableField("refresh_token")
    private String refreshToken;

    @ApiModelProperty("Wx scope")
    @TableField("scope")
    private String scope;

    @ApiModelProperty("用户头像Url")
    @TableField("user_img")
    private String userImg;

    @ApiModelProperty("手机号码")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty("性别,：0未知，1男，2女")
    @TableField("gender")
    private Integer gender;

    @ApiModelProperty("省份")
    @TableField("province")
    private String province;

    @ApiModelProperty("市")
    @TableField("city")
    private String city;

    @ApiModelProperty("区/县")
    @TableField("county")
    private String county;

    @ApiModelProperty("最后登录时间")
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
