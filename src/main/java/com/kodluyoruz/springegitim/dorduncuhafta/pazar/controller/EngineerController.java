package com.kodluyoruz.springegitim.dorduncuhafta.pazar.controller;

import com.kodluyoruz.springegitim.dorduncuhafta.pazar.entity.Engineer;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.requestDto.SaveEngineerRequestDto;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.requestDto.UpdateEngineerRequestDto;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.responseDto.EngineerResponseDto;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.service.EngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/engineer")
public class EngineerController {

    @Autowired
    EngineerService engineerService;

    @PostMapping("/saveEngineer")
    public ResponseEntity<String> saveEnginner(@RequestBody SaveEngineerRequestDto saveEngineerRequestDto){
        String engineerId = engineerService.saveEngineer(saveEngineerRequestDto);
        return new ResponseEntity<>(engineerId, HttpStatus.OK);

    }

    @GetMapping("/engineerListByName")
    public ResponseEntity<List<EngineerResponseDto>> getEngineerByName(@RequestParam String name){

        List<EngineerResponseDto> engineerResponseDtoList = null;
        try {
            engineerResponseDtoList = engineerService.getEngineerListByName(name);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(engineerResponseDtoList, HttpStatus.OK);

    }

    @PostMapping("/updateLastNameEngineer")
    public ResponseEntity<String> updateLastNameEngineer(@RequestBody UpdateEngineerRequestDto updateEngineerRequestDto){
        engineerService.updateLastNameEngineer(updateEngineerRequestDto);
        
        return new ResponseEntity<>(null, HttpStatus.OK);

    }
}
