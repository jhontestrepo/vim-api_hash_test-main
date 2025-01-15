package com.behelit.bills.app.behelit.controllers;

import com.behelit.bills.app.behelit.models.Users;
import com.behelit.bills.app.behelit.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class HelloController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/app/helloworld")
    public Map<String, String> getHello(){
        final Map<String, String> result = new HashMap<>();
        final Users user = usersRepository.findByNameUser("test");
        final String nameUser = Objects.equals(user, null)? "Not Exist": user.getNameUser();
        result.put("message", "hello world from API " + nameUser);
        return result;
    }

}
