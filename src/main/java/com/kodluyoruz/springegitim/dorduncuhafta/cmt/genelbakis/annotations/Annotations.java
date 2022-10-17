package com.kodluyoruz.springegitim.dorduncuhafta.cmt.genelbakis.annotations;

import com.kodluyoruz.springegitim.dorduncuhafta.cmt.genelbakis.annotations.beansingleton.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Annotations {

    // inject işlemi için mutlaka spring beanı olması gerekir.

    ManagerService managerService;

//    @Autowired
//    public Annotations(ManagerService managerService){
//        this.managerService = managerService;
//
//    }

//    public void test(){
//        managerService.getEmployeeValue();
//    }

    @Autowired
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }
}
