package com.kodluyoruz.springegitim.dorduncuhafta.cmt.genelbakis.annotations.beansingleton;

import com.kodluyoruz.springegitim.dorduncuhafta.cmt.genelbakis.annotations.BeanAnnotation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanSingleton implements CommandLineRunner {

    private final DoctorService doctorService;
    private final ManagerService managerService;

    public BeanSingleton(DoctorService doctorService, ManagerService managerService) {
        this.doctorService = doctorService;
        this.managerService = managerService;
    }

    @Override
    public void run(String... args) throws Exception {

        doctorService.getEmployeeValue();
        managerService.getEmployeeValue();
    }
}
