package com.iochord.controller;

import com.iochord.entity.UsersEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValController {
    @PostMapping(value="/api/users/add", produces="application/json; charset=utf-8")
    public UsersEntity apiPostUser(@RequestParam(required = true) String userName,
                                   @RequestParam(required = true) String userEmail,
                                   @RequestParam(required = true) String userPhone,
                                   @RequestParam(required = true) int userAge
                                         ){
        UsersEntity userlist = new UsersEntity();
        userlist.setUserName(userName);
        userlist.setUserEmail(userEmail);
        userlist.setUserPhone(userPhone);
        userlist.setUserAge(userAge);
        return userlist;
    }
}
