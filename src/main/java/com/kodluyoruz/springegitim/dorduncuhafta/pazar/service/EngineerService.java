package com.kodluyoruz.springegitim.dorduncuhafta.pazar.service;

import com.kodluyoruz.springegitim.dorduncuhafta.pazar.converter.EngineerConverter;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.entity.Engineer;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.repository.EngineerRepository;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.requestDto.SaveEngineerRequestDto;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.requestDto.UpdateEngineerRequestDto;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.responseDto.EngineerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EngineerService {

    @Autowired
    EngineerRepository engineerRepository;

    @Autowired
    EngineerConverter engineerConverter;

    public String saveEngineer(SaveEngineerRequestDto saveEngineerDto){
        Engineer engineer = engineerConverter.convertEngineerDtoToEngineer(saveEngineerDto);
        engineer = engineerRepository.save(engineer);
        return String.valueOf(engineer.getId());

    }

    public void updateLastNameEngineer(UpdateEngineerRequestDto updateEngineerRequestDto) {
        int idEnginnerRequest = updateEngineerRequestDto.getId();
        String soyadEngineerRequest = updateEngineerRequestDto.getSoyad();

        Optional<Engineer> engineerOptional = engineerRepository.findById(idEnginnerRequest);
        Engineer engineer = engineerOptional.get();
        engineer.setLastName(soyadEngineerRequest);

        engineerRepository.save(engineer);

    }


    public List<EngineerResponseDto> getEngineerListByName(String name) throws Exception {
        List<Engineer> engineerList = engineerRepository.findAllByName(name);

//          Unchecked Exception
        //engineer listesinden ilk elemanı al, ekrana yazdır. bu işlemler sırasında bir hata oluşursa onu sarmalla.
//        try {
//            Engineer engineer = engineerList.get(0);
//            System.out.println(engineer.getName());
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new Exception("bir hata oluştu. Kod akışı devam etmez", e);
//        }

        //engineer listesi eğer boş ise programı kır. Akış devam etmesin.
//        if(engineerList == null || engineerList.size() == 0){
//            throw new Exception("Engineer listesi boş");
//        }

        List<EngineerResponseDto> engineerResponseDtos = engineerConverter.convertEngineerListToEngineerResponseDtoLİst(engineerList);
        return engineerResponseDtos;
    }
}
