package com.evol.service.impl;

import com.evol.entity.User;
import com.evol.mapper.UserMapper;
import com.evol.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author evol
 * @since 2023-05-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User findByOpenId(String openId) {
        User user = this.baseMapper.findByOpenId(openId);
        return user;
    }

    public List<User> queryByBalance(Integer minBalance) {
        List<User> users = this.baseMapper.queryByBalance(minBalance);
        return users;
    }
}
