package com.mybatis.day1;

import java.util.List;

/**
 * @Classname Department
 * @program: mybatiscourse->Department
 * @description: 部门
 * @create: 2019-10-24 10:12
 * @Created by frank
 */
public class Department {

    private Integer id;
    private String  dname;
    private List<Employee> emps;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dname='" + dname + '\'' +

                '}';
    }
}
