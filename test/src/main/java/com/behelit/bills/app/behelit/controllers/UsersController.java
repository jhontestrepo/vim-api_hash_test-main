package com.behelit.bills.app.behelit.controllers;

import com.behelit.bills.app.behelit.models.Users;
import com.behelit.bills.app.behelit.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/app/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/createUser")
    public Users createUser(@RequestBody Users user) {
        return usersService.saveUser(user);
    }

    @PutMapping("/updateUser/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users userDetails) {
        return usersService.updateUser(id, userDetails);
    }

    @GetMapping("/getUser/{nameUser}")
    public Map<String, String> getUser(@PathVariable String nameUser) {
        final Map<String, String> result = new HashMap<>();
        final Users userData = usersService.getUser(nameUser);
        final String emailUser = Objects.equals(userData, null)? "Not Exist": userData.getEmailUser();
        result.put("message", "Your email is: " + emailUser);
        return  result;
    }
}
