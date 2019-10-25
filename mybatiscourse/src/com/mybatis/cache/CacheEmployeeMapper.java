package com.mybatis.cache;

import com.mybatis.day1.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname EmployeeMapper
 * @program: mybatiscourse->EmployeeMapper
 * @description: 员工接口
 * @create: 2019-10-23 13:39
 * @Created by frank
 */
public interface CacheEmployeeMapper {
    Employee getEmpById(Integer id);

    void addEmployee(Employee employee);
}
