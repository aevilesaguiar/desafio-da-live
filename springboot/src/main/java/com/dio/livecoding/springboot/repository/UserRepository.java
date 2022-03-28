package com.dio.livecoding.springboot.repository;

import com.dio.livecoding.springboot.model.UserModel;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long>{
    
    
}
