package com.example.ESEG.repository;

import com.example.ESEG.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
