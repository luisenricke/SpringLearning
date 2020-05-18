package com.luisenricke.javaspringclubmysql.repository;

import com.luisenricke.javaspringclubmysql.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
