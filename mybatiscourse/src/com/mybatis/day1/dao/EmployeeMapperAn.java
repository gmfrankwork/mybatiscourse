package com.mybatis.day1.dao;

import com.mybatis.day1.Employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname EmployeeMapper
 * @program: mybatiscourse->EmployeeMapper
 * @description: 员工接口
 * @create: 2019-10-23 13:39
 * @Created by frank
 */
public interface EmployeeMapperAn {
    @Select("select * from employee where id=#{id}")
    Employee getEmpById(Integer id);

}
