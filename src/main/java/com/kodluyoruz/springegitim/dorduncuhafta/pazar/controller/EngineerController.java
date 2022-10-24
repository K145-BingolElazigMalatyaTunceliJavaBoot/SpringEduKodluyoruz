package com.kodluyoruz.springegitim.dorduncuhafta.pazar.controller;

import com.kodluyoruz.springegitim.dorduncuhafta.pazar.entity.Engineer;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.requestDto.SaveEngineerRequestDto;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.requestDto.UpdateEngineerRequestDto;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.responseDto.EngineerResponseDto;
import com.kodluyoruz.springegitim.dorduncuhafta.pazar.service.EngineerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/engineer")
@RequiredArgsConstructor
public class EngineerController {
    private final EngineerService engineerService;

    @PostMapping("/saveEngineer")
    public ResponseEntity<String> saveEnginner(@RequestBody SaveEngineerRequestDto saveEngineerRequestDto) {
        String engineerId = engineerService.saveEngineer(saveEngineerRequestDto);
        return new ResponseEntity<>(engineerId, HttpStatus.CREATED);
    }

    @GetMapping("/engineerListByName")
    public ResponseEntity<List<EngineerResponseDto>> getEngineerByName(@RequestParam String name) {
        List<EngineerResponseDto> engineerListByName = engineerService.getEngineerListByName(name);
        return new ResponseEntity<>(engineerListByName, HttpStatus.OK);
    }

    @PutMapping("/updateLastNameEngineer")
    public ResponseEntity<String> updateLastNameEngineer(@RequestBody UpdateEngineerRequestDto updateEngineerRequestDto) {
        String userReturnMessage = engineerService.updateLastNameEngineer(updateEngineerRequestDto);
        return new ResponseEntity<>(userReturnMessage, HttpStatus.OK);

    }
}
