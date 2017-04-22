package com.ken.service.impl;

import com.ken.entity.Employee;
import com.ken.mapper.EmployeeMapper;
import com.ken.service.IEmployeeService;
import com.ken.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by it on 08/04/2017.
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findEmployee(Employee employee, PageModel pageModel) {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("employee",employee);
        Integer recordCount = employeeMapper.count(params);
        pageModel.setRecordCount(recordCount);
        if (recordCount>0){
            params.put("pageModel",pageModel);
        }
        return employeeMapper.selectByPage(params);
    }

    @Override
    public Integer removeEmployeeById(Integer id) {
        return employeeMapper.delete(id);
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeMapper.selectById(id);
    }

    @Override
    public void modifyEmployee(Employee employee) {
        employeeMapper.update(employee);
    }

    @Override
    public Integer addEmployee(Employee employee) {
        return employeeMapper.add(employee);
    }
}
