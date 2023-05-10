package com.vijay.user.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vijay.user.UserEntity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

}
