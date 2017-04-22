package com.ken.controller;

import com.ken.entity.Department;
import com.ken.entity.Employee;
import com.ken.entity.Position;
import com.ken.service.IDepartmentService;
import com.ken.service.IEmployeeService;
import com.ken.service.IPositionService;
import com.ken.util.tag.PageModel;
import com.ken.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by it on 10/04/2017.
 */
@Controller
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IPositionService positionService;

    @Autowired
    IDepartmentService departmentService;

    @Autowired
    EmployeeValidator employeeValidator;

    @RequestMapping(value = "/employee/employee")
    public ModelAndView selectEmployee(Integer currentPageIndex,Employee employee,ModelAndView modelAndView){
        PageModel pageModel = new PageModel();
        if (currentPageIndex != null) {
            pageModel.setCurrentPageIndex(currentPageIndex);
        }
        List<Employee> employees = employeeService.findEmployee(employee,pageModel);
        modelAndView.addObject("employees",employees);
        modelAndView.addObject("employee",employee);
        modelAndView.setViewName("employee/employee");

        List<Position> positions = positionService.findAllPosition();
        List<Department> departments = departmentService.findAllDepartment();

        modelAndView.addObject("positions",positions);
        modelAndView.addObject("departments",departments);
        modelAndView.addObject("pageModel",pageModel);

        return modelAndView;
    }

    @RequestMapping(value = "/employee/toAddEmployee")
    public ModelAndView toAddEmployee(Employee employee,ModelAndView modelAndView){
        List<Position> positions = positionService.findAllPosition();
        List<Department> departments = departmentService.findAllDepartment();
        modelAndView.addObject("positions",positions);
        modelAndView.addObject("departments",departments);
        modelAndView.setViewName("employee/addEmployee");
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }

    @RequestMapping(value = "/employee/addEmployee")
    public ModelAndView addEmployee(@Valid Employee employee, Errors errors, ModelAndView modelAndView) {
        if (errors.hasErrors()) {
            List<Position> positions = positionService.findAllPosition();
            List<Department> departments = departmentService.findAllDepartment();
            modelAndView.addObject("positions",positions);
            modelAndView.addObject("departments",departments);

            modelAndView.setViewName("employee/addEmployee");
        } else {
            employeeValidator.validate(employee,errors);
            if (errors.hasErrors()) {
                List<Position> positions = positionService.findAllPosition();
                List<Department> departments = departmentService.findAllDepartment();
                modelAndView.addObject("positions",positions);
                modelAndView.addObject("departments",departments);

                modelAndView.setViewName("employee/addEmployee");
            } else{
                employeeService.addEmployee(employee);
                modelAndView.setView(new RedirectView("employee"));
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "/employee/updateEmployee")
    public ModelAndView updateEmployee(String flag,Employee employee,ModelAndView modelAndView){
        if(flag.equals("1")){
            List<Position> positions = positionService.findAllPosition();
            List<Department> departments = departmentService.findAllDepartment();

            modelAndView.addObject("positions",positions);
            modelAndView.addObject("departments",departments);

            employee = employeeService.findEmployeeById(employee.getId());
            modelAndView.addObject("employee",employee);

            modelAndView.setViewName("employee/updateEmployee");
        } else {
            employeeService.modifyEmployee(employee);
            modelAndView.setView(new RedirectView("employee"));
        }
        return modelAndView;
    }
}
