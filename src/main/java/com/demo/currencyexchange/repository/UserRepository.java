package com.demo.currencyexchange.repository;

import com.demo.currencyexchange.model.User;
import com.demo.currencyexchange.repository.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
        UserEntity getUserByUsername(String username);
    }

