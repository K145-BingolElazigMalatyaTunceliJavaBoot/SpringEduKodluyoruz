package com.kodluyoruz.springegitim.altincihafta.pazar.project.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenerelConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
