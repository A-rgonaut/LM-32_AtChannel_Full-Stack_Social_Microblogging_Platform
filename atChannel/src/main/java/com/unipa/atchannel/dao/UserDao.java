package com.unipa.atchannel.dao;

import com.unipa.atchannel.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
}