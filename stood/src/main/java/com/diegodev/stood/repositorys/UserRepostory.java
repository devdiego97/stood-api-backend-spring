package com.diegodev.stood.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegodev.stood.entites.UserEntity;

public interface UserRepostory extends JpaRepository<UserEntity,Long> {
     
}
