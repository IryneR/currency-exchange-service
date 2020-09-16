package com.demo.currencyexchange.service;


import com.demo.currencyexchange.model.CurrencyUserDetails;
import com.demo.currencyexchange.model.Roles;
import com.demo.currencyexchange.model.User;
import com.demo.currencyexchange.repository.UserRepository;


import com.demo.currencyexchange.repository.entity.RolesEntity;
import com.demo.currencyexchange.repository.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.getUserByUsername(userName);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found.");
        }
        log.info("loadUserByName() : {}", userName);


        User user = new User();

            user.setId(userEntity.getId());
            user.setUsername(userEntity.getUsername());
            user.setPassword(userEntity.getPassword());
            user.setDateCreated(userEntity.getDateCreated());



        /*  boolean enabled = userEntity.isActive();
        boolean accountNonExpired = userEntity.isActive();
        boolean credentialsNonExpired = userEntity.isActive();
        boolean accountNonLocked = userEntity.isActive();*/

        Set<Roles> roles = new HashSet<>();
        for (RolesEntity roleEntity : userEntity.getRoles()) {
            Roles role = new Roles();
            role.setId(roleEntity.getId());
            role.setName(roleEntity.getName());
            roles.add(role);
        }
        user.setRoles(roles);
        return new CurrencyUserDetails(user);
    }
}

