package com.mybatis.day1;

import com.mybatis.day1.dao.EmployeeMapper;
import com.mybatis.day1.dao.EmployeeMapperAn;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname EmployeeTest
 * @program: mybatiscourse->EmployeeTest
 * @description:
 * @create: 2019-10-23 10:41
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
        SqlSession sqlSession  = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
             Employee employee = sqlSession.selectOne("com.mybatis.day1.getEmpById", 1);
            System.out.println(employee);
        } finally {
            sqlSession.close();
         }

    }
    @Test
    public void testMapper() throws IOException {
        SqlSession sqlSession  = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmpById(1);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void testEmployeeMapper() throws IOException {
        SqlSession sqlSession  = null;
        try{
           /* sqlSession = sqlSessionFactory.openSession(true);*/
            sqlSession = sqlSessionFactory.openSession();
            System.out.println(sqlSession);
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
         //   employeeMapper.addEmployee(new Employee(4,"cindy","cindy@gmail.com","0"));
            //employeeMapper.delelteEmpById(3);
           // employeeMapper.updateEmp(new Employee(2,"steven","ssteven@outlook.com","1"));
           /* List<Employee> empList = employeeMapper.findAll();
            for(Employee employee:empList){
                System.out.println(employee);
            }*/
            Employee employee = employeeMapper.getEmpById(1);
            System.out.println(employee);
          /*  Employee employee = employeeMapper.findByNameAndEmail("huyang","huyang@gmail.com");
            System.out.println(employee);*/
            sqlSession.commit();
        } catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void testEmployeeNoMapperAn() throws IOException {
        SqlSession sqlSession  = null;
        try{
            sqlSession = sqlSessionFactory.openSession(true);
            EmployeeMapperAn employeeMapperAn = sqlSession.getMapper(EmployeeMapperAn.class);
            Employee employee = employeeMapperAn.getEmpById(1);
            System.out.println(employee);
        } catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
    //测试自增主键
    @Test
    public void testEmployeeNoMapperIdIncrement() throws IOException {
        SqlSession sqlSession  = null;
        try{
            sqlSession = sqlSessionFactory.openSession(true);
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(employeeMapper);
            employeeMapper.addEmpByIncrementId(new Employee(null,"cherry","cherry@sina.com","0"));
        } catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
}