package com.goforcode.Web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goforcode.Web.model.Post;
import com.goforcode.Web.repository.PostRepository;

@Service
public class PostService {
	
	PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public Post savePost(Post post) {
		return postRepository.save(post);
	}
}
