package com.mybatis.day2;

import com.mybatis.day1.Department;
import com.mybatis.day1.Employee;

/**
 * @Classname EmployeeParamMapper
 * @program: mybatiscourse->EmployeeParamMapper
 * @description: 参数和返回值案例
 * @create: 2019-10-24 09:28
 * @Created by frank
 */
public interface DepartmentLazyMapper {

    ;

    //查询Employee的同时查询员工对应的部门
    Department getDeptById(Integer id);

}


