package com.iochord.controller;

import com.iochord.entity.UsersEntity;
import com.iochord.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValController {
    @Autowired
    private UsersRepository usersRepository;

    @PostMapping(value="/api/users/add", produces="application/json; charset=utf-8")
    public UsersEntity apiPostUser(@RequestBody UsersEntity usersEntity){
        usersRepository.save(usersEntity);

        return usersEntity;
    }
}
