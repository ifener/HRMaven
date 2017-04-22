package com.ken.service.impl;

import com.ken.entity.User;
import com.ken.mapper.UserMapper;
import com.ken.service.IUserService;
import com.ken.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by it on 08/04/2017.
 */
@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String loginName, String password) {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("loginName",loginName);
        params.put("password",password);
        return userMapper.selectUserByLoginNameAndPassword(params);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public List<User> findUser(User user, PageModel pageModel) {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("user",user);
        Integer recordCount = userMapper.count(params);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            params.put("pageModel",pageModel);
        }
        return userMapper.selectByPage(params);
    }

    @Override
    public Integer removeUserById(Integer id) {
        return null;
    }

    @Override
    public void modifyUser(User user) {

    }

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }
}
