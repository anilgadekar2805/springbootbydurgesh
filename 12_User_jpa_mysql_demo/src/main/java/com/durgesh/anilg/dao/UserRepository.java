package com.durgesh.anilg.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.durgesh.anilg.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
}
