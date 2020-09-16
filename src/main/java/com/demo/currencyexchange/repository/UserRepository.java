package com.demo.currencyexchange.repository;

import com.demo.currencyexchange.repository.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
        User getUserByUsername(String username);
    }

