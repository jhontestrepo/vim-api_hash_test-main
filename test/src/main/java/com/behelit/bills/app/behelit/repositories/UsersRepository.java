package com.behelit.bills.app.behelit.repositories;

import com.behelit.bills.app.behelit.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByNameUser(final String nameUser);
    Optional<Users> findById(final Long id);
}

