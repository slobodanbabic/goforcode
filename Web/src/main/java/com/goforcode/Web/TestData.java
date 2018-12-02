package com.goforcode.Web;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goforcode.Web.model.Post;
import com.goforcode.Web.model.User;
import com.goforcode.Web.service.PostService;
import com.goforcode.Web.service.UserService;

@Component
public class TestData {

	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;

	@PostConstruct
	public void createData() {

		User peraUser = new User("Pera", "Peric", "peki", "peki", "peki@gmail.com");
		peraUser = userService.saveUser(peraUser);

		User micaUser = new User("Milica", "Milic", "mica", "mica", "mica@yahoo.com");
		micaUser = userService.saveUser(micaUser);

		User makiUser = new User("Marija", "Djokic", "maki", "maki", "maki@gmail.com");
		makiUser = userService.saveUser(makiUser);

		Post peraPost1 = new Post("Ovo je nekakav post manje vise dugacak", new Date(), peraUser);
		peraPost1 = postService.savePost(peraPost1);

		
		
	}

}
