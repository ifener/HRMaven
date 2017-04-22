package com.ken.mapper;

import com.ken.entity.Department;

import java.util.List;
import java.util.Map;

/**
 * Created by it on 13/04/2017.
 */
public interface DepartmentMapper {

    Integer add(Department department);

    Department selectById(Integer id);

    List<Department> selectByPage(Map<String, Object> params);

    List<Department> selectAll();

    Integer count(Map<String, Object> params);

    Integer update(Department department);

    Integer delete(Integer id);

}
