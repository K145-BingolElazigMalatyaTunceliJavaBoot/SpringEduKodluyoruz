package com.kodluyoruz.springegitim.dorduncuhafta.pazar.service;

import com.kodluyoruz.springegitim.dorduncuhafta.pazar.converter.EngineerConverter;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.entity.Engineer;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.repository.EngineerRepository;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.requestDto.SaveEngineerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

    @Autowired
    EngineerConverter engineerConverter;


    @Autowired
    EngineerRepository engineerRepository;

    public void saveEngineerNPE() {
        Engineer engineer = null;
        engineer.setName("");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Engineer getEngineer(SaveEngineerRequestDto saveEngineerDto) {
        Engineer engineer = engineerConverter.convertEngineerDtoToEngineer(saveEngineerDto);
        engineer = engineerRepository.save(engineer);
        return engineer;
    }

}
