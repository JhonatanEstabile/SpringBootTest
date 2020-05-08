package br.fib.SpringBoot.services;

import br.fib.SpringBoot.models.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    List<User> findAll();

}