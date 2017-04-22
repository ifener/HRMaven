package com.ken.service;

import com.ken.entity.Department;
import com.ken.entity.Employee;
import com.ken.util.tag.PageModel;

import java.util.List;

/**
 * Created by it on 08/04/2017.
 */
public interface IDepartmentService {

    Integer removeDepartmentById(Integer id);

    Integer addDepartment(Department department);

    Department findDepartmentById(Integer id);

    void modifyDepartment(Department department);

    List<Department> findDepartment(Department department, PageModel pageModel);

    List<Department> findAllDepartment();

}
