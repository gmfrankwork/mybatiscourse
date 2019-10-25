package com.mybatis.cache;

import com.mybatis.day1.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @Classname CacheEmployeeMapperTest
 * @program: mybatiscourse->CacheEmployeeMapperTest
 * @description:
 * @create: 2019-10-25 14:32
 * @Created by frank
 */
public class CacheEmployeeMapperTest {
    private SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testFirstCache() throws IOException {

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheEmployeeMapper cacheEmployeeMapper = sqlSession1.getMapper(CacheEmployeeMapper.class);
        Employee employee1 = cacheEmployeeMapper.getEmpById(1);
        System.out.println(employee1);
        //sqlSession1.close();


      //  cacheEmployeeMapper.addEmployee(new Employee(88,"testcache","cache@126.com","1"));


        //sqlSession1.clearCache();
        Employee employee2 = cacheEmployeeMapper.getEmpById(1);
        System.out.println(employee2);


       /* SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheEmployeeMapper cacheEmployeeMapper2 = sqlSession2.getMapper(CacheEmployeeMapper.class);
        Employee employee2 = cacheEmployeeMapper2.getEmpById(1);
        System.out.println(employee2);*/

        System.out.println(employee1==employee2);
    }
    @Test
    public void testSecondCache() throws IOException {

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheEmployeeMapper cacheEmployeeMapper = sqlSession1.getMapper(CacheEmployeeMapper.class);
        Employee employee1 = cacheEmployeeMapper.getEmpById(1);
        System.out.println(employee1);
        sqlSession1.close();

        /*cacheEmployeeMapper.addEmployee(new Employee(199,"testcache99","cache99@126.com","1"));
        sqlSession1.close();*/
       SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
       /*sqlSession2.clearCache();*/
        CacheEmployeeMapper cacheEmployeeMapper2 = sqlSession2.getMapper(CacheEmployeeMapper.class);
        Employee employee2 = cacheEmployeeMapper2.getEmpById(1);
        System.out.println(employee2);

        System.out.println(employee1==employee2);
    }
}