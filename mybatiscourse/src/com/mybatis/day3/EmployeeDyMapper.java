package com.mybatis.day3;

import com.mybatis.day1.Department;
import com.mybatis.day1.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Classname EmployeeParamMapper
 * @program: mybatiscourse->EmployeeParamMapper
 * @description: 参数和返回值案例
 * @create: 2019-10-24 09:28
 * @Created by frank
 */
public interface EmployeeDyMapper {


    List<Employee> findByIf(Employee employee);

    List<Employee> findByTrim(Employee employee);

    List<Employee> findByChoose(Employee employee);

    void updateEmp(Employee employee);

    List<Employee> findByIds(@Param("ids") List ids);

    void  addEmpBatch(@Param("emps") List<Employee> emps);


    List<Employee> findByLikeLastName(Employee employee);


    Employee findById(Integer id);

}


