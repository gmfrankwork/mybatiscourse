package com.mybatis.day1.dao;

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
public interface EmployeeMapper {
    Employee getEmpById(Integer id);
    void addEmployee(Employee employee);
    void delelteEmpById(Integer id);
    List<Employee> findAll();
    void updateEmp(Employee employee);
    void addEmpByIncrementId(Employee employee);

    Employee findByNameAndEmail(@Param("lastName") String lastName, @Param("email") String email);
}
