package com.behelit.bills.app.behelit.services.impl;

import com.behelit.bills.app.behelit.models.Users;
import com.behelit.bills.app.behelit.repositories.UsersRepository;
import com.behelit.bills.app.behelit.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users saveUser(final Users user) {
        return usersRepository.save(user);
    }

    @Override
    public Users updateUser(Long id, Users userDetails) {
        Optional<Users> optionalUser = usersRepository.findById(id);
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            user.setNameUser(userDetails.getNameUser());
            user.setEmailUser(userDetails.getEmailUser());
            user.setPassUser(userDetails.getPassUser());
            return usersRepository.save(user);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    @Override
    public Users getUser(final String nameUser) {
        final Optional<Users> user = Optional.ofNullable(usersRepository.findByNameUser(nameUser));
        return user.orElse(null);
    }
}
