package com.luisenricke.javaspringclubmysql.service;

import com.luisenricke.javaspringclubmysql.entity.User;
import com.luisenricke.javaspringclubmysql.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserServiceJPA implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceJPA(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public User get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (IllegalArgumentException ex) {
            log.error(ex.getMessage());
            return false;
        }
    }
}
