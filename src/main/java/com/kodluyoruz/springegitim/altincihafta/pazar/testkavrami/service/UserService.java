package com.kodluyoruz.springegitim.altincihafta.pazar.testkavrami.service;

import com.kodluyoruz.springegitim.altincihafta.pazar.testkavrami.model.Userr;
import com.kodluyoruz.springegitim.altincihafta.pazar.testkavrami.dto.UserSaveRequestDtoo;
import com.kodluyoruz.springegitim.altincihafta.pazar.testkavrami.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepositories;

    @Autowired
    UserTurkcellService userTurkcellService;

    @Autowired
    NonTurkcellInfoService nonTurkcellInfoService;

    public boolean userSaveByRequestDto(UserSaveRequestDtoo userSaveRequestDto) {
        String phoneNumber = userSaveRequestDto.getPhoneNumber();
        if (!checkPhoneNumberFormat(phoneNumber)) {
            return false;
        }
        try {
            boolean isTurkcell = isTurkcell(phoneNumber);
            Userr user = null;
            user = userRepositories.userSave(userSaveRequestDto);

            if (!isTurkcell) {
                nonTurkcellInfoService.nonTurkcellInfoService(user);
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkPhoneNumberFormat(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        if (!org.apache.commons.lang3.StringUtils.isNumeric(phoneNumber)) {
            return false;
        }
        if (phoneNumber.trim().length() == 0) {
            return false;
        }
        if (phoneNumber.length() == 10 && phoneNumber.startsWith("0")) {
            return false;
        }
        if (phoneNumber.length() == 11 && !phoneNumber.startsWith("0")) {
            return false;
        }
        if (phoneNumber.length() != 11 && phoneNumber.length() != 10) {
            return false;
        }
        return true;
    }

    public boolean isTurkcell(String phoneNumber) {
        boolean turkcell = false;

        Userr user = userTurkcellService.getUserByMsisdn(phoneNumber);
        if (user.getTurkcell()) { // null kontrolü yapılmadığı için isTurkcell null gelirse null pointer exception fırlatır, unit test yazarken farkedilebilir, düzeltelim mi yoksa örnek olması açısından böyle mi kalsın?
            turkcell = true;

        }else{
            nonTurkcellInfoService.nonTurkcellInfoService(user);
        }

        return turkcell;
    }

}
