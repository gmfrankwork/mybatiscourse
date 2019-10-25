package com.mybatis.day3;

import com.mybatis.day1.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Classname EmployeeTest
 * @program: mybatiscourse->EmployeeTest
 * @description:
 * @create: 2019-10-25 10:41
 * @Created by frank
 */
public class EmployeeTest {

    private SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }
    @Test
    public void test() throws IOException {
        SqlSession  sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDyMapper employeeDyMapper = sqlSession.getMapper(EmployeeDyMapper.class);

        Employee employee = employeeDyMapper.findById(1);
        System.out.println(employee);
        System.out.println(employee.getDept());
    }
}