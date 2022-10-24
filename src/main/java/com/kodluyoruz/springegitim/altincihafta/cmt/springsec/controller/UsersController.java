package com.kodluyoruz.springegitim.altincihafta.cmt.springsec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    //Spring sec yazılır yazılmaz otomatik devreye girer.


    //homepage'e her türlü erişmek istiyorum ama dashboarda hher zman erişmek istemiyorm.

    @GetMapping("/home")
    public String homePage(){

        return "Home page";

    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "Login başarılı";
    }


    @GetMapping("/addUser")
    public String addUser(){
        return "Admine özel user ekleme sayfası";
    }




}
