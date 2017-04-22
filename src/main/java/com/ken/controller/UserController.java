package com.ken.controller;

import com.alibaba.fastjson.JSONObject;
import com.ken.entity.User;
import com.ken.service.IUserService;
import com.ken.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by it on 09/04/2017.
 */
@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("loginName") String loginName, @RequestParam("password") String password,
                              HttpSession session, ModelAndView modelAndView){
        User user = userService.login(loginName,password);
        if (user != null) {
            session.setAttribute("user",user);
            modelAndView.setView(new RedirectView("main"));
        } else {
            modelAndView.addObject("msg","登录用户名或者密码不正确");
            modelAndView.setViewName("/loginForm");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/ajaxLogin",method = RequestMethod.POST)
    public void ajaxLogin(@RequestParam("loginName") String loginName, @RequestParam("password") String password,
                              HttpSession session, HttpServletResponse response) throws IOException {
        User user = userService.login(loginName,password);
        if (user != null) {
            session.setAttribute("user",user);
            response.setContentType("application/json");
            response.getWriter().write(JSONObject.toJSONString(user));
        } else {
            response.getWriter().write("{\"code\":100}");
        }
    }

    @RequestMapping(value = "/user/user")
    public String selectUser(Integer currentPageIndex, User user, ModelMap modelMap){
        PageModel pageModel = new PageModel();
        if (currentPageIndex != null) {
            pageModel.setCurrentPageIndex(currentPageIndex);
        }


        List<User> users = userService.findUser(user,pageModel);
        modelMap.addAttribute("users",users);
        modelMap.addAttribute("user",user);
        modelMap.addAttribute("pageModel",pageModel);
        return "user/user";
    }

    @RequestMapping(value = "/user/removeUser")
    public ModelAndView removeUser(String ids,ModelAndView modelAndView){
        String[] idArray = ids.split(",");
        for(String id:idArray){
            userService.removeUserById(Integer.parseInt(id));
        }

        modelAndView.setViewName("redirect:/user/user");
        return modelAndView;
    }

    @RequestMapping(value = "/user/updateUser")
    public ModelAndView updateUser(String flag,User user,ModelAndView modelAndView){
        if (flag.equals("1")) {
            User target = userService.findUserById(user.getId());
            modelAndView.addObject("user",target);
            modelAndView.setViewName("user/ShowUpdateUser");
        } else {
            userService.modifyUser(user);
            modelAndView.setViewName("redirect:/user/user");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/user/addUser")
    public ModelAndView addUser(String flag,User user,ModelAndView modelAndView){
        if (flag.equals("1")){
            modelAndView.addObject("user",user);
            modelAndView.setViewName("/user/showAddUser");
        } else {
            Integer result = userService.addUser(user);
            System.out.println("");
            System.out.println("");
            System.out.println("添加受影响行数："+result+"，ID="+user.getId());
            System.out.println("");
            System.out.println("");
            modelAndView.setViewName("redirect:/user/user");
        }
        return modelAndView;
    }


    @RequestMapping(value = "/jsonUser1")
    @ResponseBody //加入@ResponseBody将对象返回JSON数据
    public Object getJsonUser1(){
        User user = userService.findUserById(1);
        return user;
    }

    @RequestMapping(value = "/jsonUser2")
    public void getJsonUser2(HttpServletResponse response) throws IOException {
        User user = userService.findUserById(1);
        throw new IOException("Manual exception");
        //String json = JSONObject.toJSON(user).toString();
        //response.getWriter().write(json);
    }
}
