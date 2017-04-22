package com.ken.mapper;

import com.ken.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by it on 13/04/2017.
 */
public interface UserMapper {
    User selectUserById(Integer id);

    User selectUserByLoginNameAndPassword(Map<String, Object> params);

    List<User> selectByPage(Map<String, Object> params);

    Integer count(Map<String, Object> params);

    Integer addUser(User user);

}
