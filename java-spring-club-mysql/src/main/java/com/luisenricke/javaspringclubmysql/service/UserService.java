package com.luisenricke.javaspringclubmysql.service;

import com.luisenricke.javaspringclubmysql.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User get(Long id);
    User save(User user);
    boolean deleteById(Long id);
}
