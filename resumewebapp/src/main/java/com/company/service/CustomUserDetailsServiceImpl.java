package com.company.service;


import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import  org.springframework.security.core.userdetails.User.UserBuilder;


@Service("CustomImpl")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

   private final UserRepositoryCustom userRepo;

    public CustomUserDetailsServiceImpl(@Qualifier("userDaoImpl") UserRepositoryCustom userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepo.findByEmail(email);
        UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(email);

        if(user!=null){
            builder.disabled(false);
            builder.password(user.getPassword());

            String[] authoritiesArr= new String[]{"USER","ADMIN"};
            builder.authorities(authoritiesArr);

            return builder.build();

        }else {
            throw new UsernameNotFoundException("User not found");
        }

    }
}
