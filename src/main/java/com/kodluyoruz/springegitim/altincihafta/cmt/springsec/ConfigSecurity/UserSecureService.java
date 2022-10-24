package com.kodluyoruz.springegitim.altincihafta.cmt.springsec.ConfigSecurity;

import org.hibernate.boot.archive.scan.internal.NoopEntryHandler;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSecureService {
//        implements UserDetailsService {

    @Autowired
    UserInfoRepository userInfoRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserName("nesrin5");
//        userInfo.setPassword("1234");
//        userInfoRepository.save(userInfo);
//        UserInfo byUserName = userInfoRepository.findByUserName(username);
//        if(byUserName == null){
//            throw new UsernameNotFoundException("User bulunamadı");
//        }
//
//        return  User.withUsername(byUserName.getUserName()).password(byUserName.getPassword()).authorities("USER").build();
//
//
//    }
}
