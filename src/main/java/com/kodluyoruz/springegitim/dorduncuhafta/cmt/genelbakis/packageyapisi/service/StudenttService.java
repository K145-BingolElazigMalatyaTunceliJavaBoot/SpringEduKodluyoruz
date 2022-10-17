package com.kodluyoruz.springegitim.dorduncuhafta.cmt.genelbakis.packageyapisi.service;


import com.kodluyoruz.springegitim.dorduncuhafta.cmt.genelbakis.packageyapisi.configuration.GeneralConfiguration;
import com.kodluyoruz.springegitim.dorduncuhafta.cmt.genelbakis.packageyapisi.convert.StudentConverter;
import com.kodluyoruz.springegitim.dorduncuhafta.cmt.genelbakis.packageyapisi.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudenttService {

    @Autowired
    StudentConverter converter;

    public List<Student> getStudenttList() {
        List<Student> studentList = GeneralConfiguration.studentList;
        for (Student student : studentList) {
            converter.studentConvert(student);
        }

        return studentList;

    }

}
