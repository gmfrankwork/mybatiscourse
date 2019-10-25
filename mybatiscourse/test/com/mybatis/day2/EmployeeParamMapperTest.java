package com.mybatis.day2;

import com.mybatis.day1.Department;
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

/**
 * @Classname EmployeeParamMapperTest
 * @program: mybatiscourse->EmployeeParamMapperTest
 * @description:
 * @create: 2019-10-24 09:32
 * @Created by frank
 */
public class EmployeeParamMapperTest {

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
            EmployeeParamMapper employeeParamMapper = sqlSession.getMapper(EmployeeParamMapper.class);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("tablename","employee");
            map.put("last_name","huyang");
            map.put("gender","1");
            Employee employee= employeeParamMapper.getEmpByMap(map);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void testReturnMap() throws IOException {
        SqlSession sqlSession  = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            EmployeeParamMapper employeeParamMapper = sqlSession.getMapper(EmployeeParamMapper.class);
           /* Map map= employeeParamMapper.getEmpRusetForMap(2);*/
           // Map map= employeeParamMapper.getEmpByLikeGender("1");
            //System.out.println(map);
            Employee employee = new Employee(88,"jack",null,"1");
            employeeParamMapper.insertEmployee(employee);

        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void testEmpwithDept() throws IOException {
        SqlSession sqlSession  = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            EmployeeParamMapper employeeParamMapper = sqlSession.getMapper(EmployeeParamMapper.class);
           //Employee emp= employeeParamMapper.getEmpWithDept(1);
            Employee emp = employeeParamMapper.getEmpWithDeptByStep(1);
            System.out.println(emp);
           //System.out.println(emp.getDept());
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void testDeptWithEmpByDeptId() throws IOException {
        SqlSession sqlSession  = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            EmployeeParamMapper employeeParamMapper = sqlSession.getMapper(EmployeeParamMapper.class);
            //Employee emp= employeeParamMapper.getEmpWithDept(1);
            Department department = employeeParamMapper.getDeptWithEmpById(1);
            System.out.println(department);
            //System.out.println(emp.getDept());
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void testDeptWithEmpByStepDeptId() throws IOException {
        SqlSession sqlSession  = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            EmployeeParamMapper employeeParamMapper = sqlSession.getMapper(EmployeeParamMapper.class);

            Department department = employeeParamMapper.getDeptWithEmpStepById(6);
            System.out.println(department);
            //System.out.println(emp.getDept());
        } finally {
            sqlSession.close();
        }

    }
}