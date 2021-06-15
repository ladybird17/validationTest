package com.iochord.controller;

import com.iochord.entity.UsersEntity;
import com.iochord.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ValController {
    @Autowired
    private UsersRepository usersRepository;

    @PostMapping(value="/api/users/add")
    public UsersEntity apiPostUser(@Valid @RequestBody UsersEntity usersEntity){

        return this.usersRepository.save(usersEntity);
    }
}
