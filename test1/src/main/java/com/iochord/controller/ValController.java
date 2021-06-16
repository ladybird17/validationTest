package com.iochord.controller;

import com.iochord.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class ValController {

    @PostMapping(value="/api/users/add")
    public Users apiPostUser(@Valid @RequestBody Users users){

        return users;
    }
}
