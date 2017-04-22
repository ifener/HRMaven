package com.ken.service;

import com.ken.entity.Employee;
import com.ken.util.tag.PageModel;

import java.util.List;

/**
 * Created by it on 08/04/2017.
 */
public interface IEmployeeService {

    List<Employee> findEmployee(Employee employee, PageModel pageModel);

    Integer removeEmployeeById(Integer id);

    Employee findEmployeeById(Integer id);

    void modifyEmployee(Employee employee);

    Integer addEmployee(Employee employee);

}
