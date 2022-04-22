package com.apgs.backend.service.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apgs.backend.service.database.model.User;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Integer> {

}
