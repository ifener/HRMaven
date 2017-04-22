package com.ken.controller;

import com.ken.entity.Department;
import com.ken.service.IDepartmentService;
import com.ken.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by it on 10/04/2017.
 */
@Controller
public class DepartmentController {

    @Autowired
    IDepartmentService departmentService;

    @RequestMapping(value = "/department/department")
    public String selectDepartment(Department department, Integer currentPageIndex, ModelMap modelMap){
        PageModel pageModel = new PageModel();
        if (currentPageIndex!=null){
            pageModel.setCurrentPageIndex(currentPageIndex);
        }

        List<Department> departments = departmentService.findDepartment(department,pageModel);
        System.out.println(departments.size());
        modelMap.addAttribute("departments",departments);
        modelMap.addAttribute("pageModel",pageModel);
        modelMap.addAttribute("department",department);
        return "department/department";
    }

    @RequestMapping(value = "/department/removeDepartment")
    public ModelAndView removeDepartment(String ids,ModelAndView modelAndView){
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            departmentService.removeDepartmentById(Integer.parseInt(id));
        }

        modelAndView.setViewName("redirect:/department/department");
        return modelAndView;
    }

    @RequestMapping(value = "/department/addDepartment")
    public ModelAndView addDepartment(String flag,Department department,ModelAndView modelAndView){
        if (flag.equals("1")) {
            modelAndView.setViewName("department/showAddDepartment");
        } else {
            departmentService.addDepartment(department);
            modelAndView.setViewName("redirect:/department/department");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/department/updateDepartment")
    public ModelAndView updateDepartment(String flag,Department department,ModelAndView modelAndView){
        if (flag.equals("1")) {
            department = departmentService.findDepartmentById(department.getId());
            modelAndView.addObject("department",department);
            modelAndView.setViewName("department/showUpdateDepartment");
        } else {
            departmentService.modifyDepartment(department);
            modelAndView.setViewName("redirect:/department/department");
        }
        return modelAndView;
    }
}
