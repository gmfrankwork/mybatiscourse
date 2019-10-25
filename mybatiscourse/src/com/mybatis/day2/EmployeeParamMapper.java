package com.mybatis.day2;

import com.mybatis.day1.Department;
import com.mybatis.day1.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname EmployeeParamMapper
 * @program: mybatiscourse->EmployeeParamMapper
 * @description: 参数和返回值案例
 * @create: 2019-10-24 09:28
 * @Created by frank
 */
public interface EmployeeParamMapper {

    Employee getEmpByMap(Map<String,Object> map);

    Map getEmpRusetForMap(Integer id);
    @MapKey("last_name")
    Map  getEmpByLikeGender(String gender);

    void insertEmployee(Employee employee);

    //查询Employee的同时查询员工对应的部门
    Employee getEmpWithDept(Integer id);

    Employee getEmpWithDeptByStep(Integer id);


    Department getDeptById(Integer id);

    Department getDeptWithEmpById(Integer id);


    Department getDeptWithEmpStepById(Integer id);

    //根据id查询员工
    Employee getEmpById(Integer id);
}


