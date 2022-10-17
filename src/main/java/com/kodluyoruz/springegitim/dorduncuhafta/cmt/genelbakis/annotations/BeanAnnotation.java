package com.kodluyoruz.springegitim.dorduncuhafta.cmt.genelbakis.annotations;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanAnnotation {

    //methodlar bean annotation ile işaretlenir. Classın da bir spring beanı olması gerekir.
    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Ogrenci getOgrenci(){
        return new Ogrenci();
    }


}
