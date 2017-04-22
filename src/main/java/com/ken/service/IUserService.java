package com.ken.service;

import com.ken.entity.User;
import com.ken.util.tag.PageModel;

import java.util.List;

/**
 * Created by it on 08/04/2017.
 */
public interface IUserService {

    User login(String loginName, String password);

    User findUserById(Integer id);

    List<User> findUser(User user, PageModel pageModel);

    Integer removeUserById(Integer id);

    void modifyUser(User user);

    Integer addUser(User user);
}
