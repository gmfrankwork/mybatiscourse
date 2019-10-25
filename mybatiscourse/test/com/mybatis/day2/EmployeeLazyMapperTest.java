package com.mybatis.day2;

import com.mybatis.day1.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Classname EmployeeLazyMapperTest
 * @program: mybatiscourse->EmployeeLazyMapperTest
 * @description:
 * @create: 2019-10-25 11:41
 * @Created by frank
 */
public class EmployeeLazyMapperTest {
    private SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }
    @Test
    public void test() throws IOException {
        SqlSession sqlSession  = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            EmployeeLazyMapper employeeLazyMapper = sqlSession.getMapper(EmployeeLazyMapper.class);
            Employee employee= employeeLazyMapper.getEmpWithDeptWithLazy(1);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }

    }
}