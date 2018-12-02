package com.goforcode.Web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goforcode.Web.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
