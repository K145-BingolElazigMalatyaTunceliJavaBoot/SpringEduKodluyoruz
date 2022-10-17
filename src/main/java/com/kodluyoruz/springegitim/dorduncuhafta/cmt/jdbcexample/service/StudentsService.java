package com.kodluyoruz.springegitim.dorduncuhafta.cmt.jdbcexample.service;

import com.kodluyoruz.springegitim.dorduncuhafta.cmt.jdbcexample.mapper.StudentMapper;
import com.kodluyoruz.springegitim.dorduncuhafta.cmt.jdbcexample.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> getStudentsList() {

        String sql = "select * from student";

        return jdbcTemplate.query(sql, new StudentMapper());

    }

    //SQL injection'a açık bir kod bloğu
//    public List<Student> getStudentsList(String name){
//
//        String sql = "select * from student s where s.NAME=" + "'"+name+"'" ;
//
//        return jdbcTemplate.query(sql, new StudentMapper());
//
//    }

    public List<Student> getStudentsList(String name) {

        String sql = "select * from student s where s.name = ?";

        return jdbcTemplate.query(sql,new Object[]{name}, new StudentMapper());

    }

//    public List<Student> getStudentsList(String name, String lastName) {
////
////        String sql = "select * from student s where s.name = ? and s.lastName = ?";
////
////        return jdbcTemplate.query(sql,new Object[]{name, lastName}, new StudentMapper());
////
////    }

}
