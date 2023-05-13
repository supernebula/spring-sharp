package com.evol.service;

import com.evol.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author evol
 * @since 2023-05-13
 */
public interface UserService extends IService<User> {

    User findByOpenId(String openId);

    List<User> queryByBalance(Integer minBalance);

}
