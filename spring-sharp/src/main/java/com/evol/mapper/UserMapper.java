package com.evol.mapper;

import com.evol.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author evol
 * @since 2023-05-13
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM user WHERE open_id = #{openId} LIMIT 1;")
    User findByOpenId(@Param("openId") String openId);

    List<User> queryByBalance(Integer minBalance);

}
