package com.kodluyoruz.springegitim.dorduncuhafta.pazar.converter;

import com.kodluyoruz.springegitim.dorduncuhafta.pazar.entity.Engineer;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.requestDto.SaveEngineerRequestDto;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.responseDto.EngineerResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class EngineerConverter {

    public Engineer convertEngineerDtoToEngineer(SaveEngineerRequestDto saveEngineerDto){
        Engineer engineer = new Engineer();
        engineer.setName(saveEngineerDto.getAd());
        engineer.setLastName(saveEngineerDto.getSoyad());
        return engineer;

    }

    public List<EngineerResponseDto> convertEngineerListToEngineerResponseDtoLİst(List<Engineer> engineerList){
        List<EngineerResponseDto> engineerResponseDtoList = new ArrayList<>();

        for (Engineer engineer : engineerList) {
            EngineerResponseDto engineerResponseDto = new EngineerResponseDto();
            engineerResponseDto.setAd(engineer.getName());
            engineerResponseDto.setSoyad(engineer.getLastName());
            engineerResponseDtoList.add(engineerResponseDto);

        }

        return engineerResponseDtoList;


    }

}
