package com.behelit.bills.app.behelit.services;

import com.behelit.bills.app.behelit.models.Users;

import java.util.Optional;

public interface UsersService {

    Users saveUser(final Users user);
    Users updateUser(final Long id, final Users userDetails);
    Users getUser(final String nameUser);
}
