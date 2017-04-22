package com.ken.validator;

import com.ken.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by it on 11/04/2017.
 */
@Repository
public class EmployeeValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Employee employee = (Employee)o;
        ValidationUtils.rejectIfEmpty(errors,"address",null,"地址为能为空");

        System.out.println(employee.getDepartment().getId());

        if(employee.getDepartment().getId()==0){
            ValidationUtils.rejectIfEmpty(errors,"department",null,"请选择部门");
        }
    }
}
