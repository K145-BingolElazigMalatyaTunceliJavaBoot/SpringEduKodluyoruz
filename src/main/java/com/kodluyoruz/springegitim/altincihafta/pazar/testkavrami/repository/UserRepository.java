package com.kodluyoruz.springegitim.altincihafta.pazar.testkavrami.repository;

import com.kodluyoruz.springegitim.altincihafta.pazar.testkavrami.model.Userr;
import com.kodluyoruz.springegitim.altincihafta.pazar.testkavrami.dto.UserSaveRequestDtoo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class UserRepository {

    static final List<Userr> userList = new ArrayList<>();

    public Userr userSave(UserSaveRequestDtoo userSaveRequestDto){
        Userr user = new Userr();
        user.setUserName(userSaveRequestDto.getUserName());
        user.setUserPassword(userSaveRequestDto.getUserPassword());
        user.setId((long) (new Random().nextDouble() * 1234567L + 1));
        userList.add(user);
        return user;
    }

}
