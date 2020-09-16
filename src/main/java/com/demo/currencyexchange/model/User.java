package com.demo.currencyexchange.model;

import com.demo.currencyexchange.repository.entity.RolesEntity;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User {

        private Integer id;
        private String username;
        private String password;
        private Date dateCreated;
        private Set<Roles> roles = new HashSet<>();

    }
