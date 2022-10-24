package com.kodluyoruz.springegitim.dorduncuhafta.pazar.service;

import com.kodluyoruz.springegitim.dorduncuhafta.pazar.converter.EngineerConverter;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.entity.Engineer;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.repository.EngineerRepository;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.requestDto.SaveEngineerRequestDto;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.requestDto.UpdateEngineerRequestDto;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.responseDto.EngineerResponseDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EngineerService {

    private final EngineerRepository engineerRepository;

    private final EngineerConverter engineerConverter;

    private final ModelMapper modelMapper;

    //    public EngineerService(EngineerRepository engineerRepository, EngineerConverter engineerConverter, ModelMapper modelMapper){
//        this.engineerRepository = engineerRepository;
//        this.engineerConverter = engineerConverter;
//        this.modelMapper = modelMapper;
//
//    }
    public String saveEngineer(SaveEngineerRequestDto saveEngineerRequestDto) {
        Engineer engineer = convertToEngineerFromEngineerRequestDto2(saveEngineerRequestDto);
        engineer = engineerRepository.save(engineer);

        return String.valueOf(engineer.getId());
    }

//    private Engineer convertToEngineerFromEngineerRequestDto(SaveEngineerRequestDto saveEngineerRequestDto) {
//        Engineer engineer = new Engineer();
//        engineer.setName(saveEngineerRequestDto.getName());
//        engineer.setLastName(saveEngineerRequestDto.getLastName());
//        engineer.setTckn(saveEngineerRequestDto.getTckn());
//        return engineer;
//    }

    private Engineer convertToEngineerFromEngineerRequestDto2(SaveEngineerRequestDto saveEngineerRequestDto) {
        ModelMapper modelMapper1 = new ModelMapper();
        Engineer engineer = modelMapper.map(saveEngineerRequestDto, Engineer.class);
        return engineer;
    }


//    public List<EngineerResponseDto> getEngineerListByName(String name) throws Exception {
//        List<Engineer> engineerList = engineerRepository.findAllByName(name);
//
////          Unchecked Exception
//        //engineer listesinden ilk elemanı al, ekrana yazdır. bu işlemler sırasında bir hata oluşursa onu sarmalla.
////        try {
////            Engineer engineer = engineerList.get(0);
////            System.out.println(engineer.getName());
////        }catch (Exception e){
////            e.printStackTrace();
////            throw new Exception("bir hata oluştu. Kod akışı devam etmez", e);
////        }
//
//        //engineer listesi eğer boş ise programı kır. Akış devam etmesin.
////        if(engineerList == null || engineerList.size() == 0){
////            throw new Exception("Engineer listesi boş");
////        }
//
//        List<EngineerResponseDto> engineerResponseDtos = engineerConverter.convertEngineerListToEngineerResponseDtoLİst(engineerList);
//        return engineerResponseDtos;
//    }

    public String updateLastNameEngineer(UpdateEngineerRequestDto updateEngineerRequestDto) {
        int id = updateEngineerRequestDto.getId();
        String soyad = updateEngineerRequestDto.getSoyad();//guncel soyadı

        try {
            Optional<Engineer> engineerRepositoryById = engineerRepository.findById(id);
            if (engineerRepositoryById.isPresent()) {
                Engineer engineer = engineerRepositoryById.get();
                engineer.setLastName(soyad);
                engineerRepository.save(engineer);
                return "Kullanıcı bilgileri başarılı bir şekilde güncellendi.";

            }
            return "İçeride böyle bir kullanıcı bulunmamaktadır";
        } catch (Exception e) {
            e.printStackTrace();
            return "Bir hata ile karşılaşıldı. lütfen tekrar deneyiniz.";
        }
    }

    //1.yöntem.
//    public List<Engineer>  getEngineerListByName(String name) {
//        List<Engineer> engineerListFilteredByName = new ArrayList<>();
//        Iterable<Engineer> engineers = engineerRepository.findAll();
//        for (Engineer engineer : engineers) {
//            if(engineer.getName().equals(name)){
//                engineerListFilteredByName.add(engineer);
//
//            }
//        }
//        return  engineerListFilteredByName;
//
//    }

    //2. yöntem
    public List<EngineerResponseDto> getEngineerListByName(String name) {
        List<EngineerResponseDto> engineerResponseDtoList = new ArrayList<>();
        List<Engineer> engineerListByName = engineerRepository.findAllByName(name);
        for (Engineer engineer : engineerListByName) {
            EngineerResponseDto engineerResponseDto = modelMapper.map(engineer, EngineerResponseDto.class);
            engineerResponseDtoList.add(engineerResponseDto);
        }
        return engineerResponseDtoList;
    }

}
