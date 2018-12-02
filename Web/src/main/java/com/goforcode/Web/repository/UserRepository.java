package com.goforcode.Web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goforcode.Web.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
