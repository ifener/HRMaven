package com.ken.service.impl;

import com.ken.entity.Department;
import com.ken.mapper.DepartmentMapper;
import com.ken.service.IDepartmentService;
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
public class DepartmentServiceImpl implements IDepartmentService {


    @Autowired
    DepartmentMapper departmentMapper;


    @Override
    public Integer addDepartment(Department department) {
        return departmentMapper.add(department);
    }

    @Override
    public Integer removeDepartmentById(Integer id) {
        return departmentMapper.delete(id);
    }


    @Override
    public Department findDepartmentById(Integer id) {
        return departmentMapper.selectById(id);
    }

    @Override
    public void modifyDepartment(Department department) {
        departmentMapper.update(department);
    }

    @Override
    public List<Department> findDepartment(Department department, PageModel pageModel) {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("dept",department);
        Integer recordCount = departmentMapper.count(params);
        pageModel.setRecordCount(recordCount);
        if (recordCount>0){
            params.put("pageModel",pageModel);
        }
        return departmentMapper.selectByPage(params);
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentMapper.selectAll();
    }
}
