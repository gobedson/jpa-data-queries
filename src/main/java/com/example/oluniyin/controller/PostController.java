package com.example.oluniyin.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oluniyin.domain.Post;
import com.example.oluniyin.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);

	private PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@RequestMapping("/")
	public List<Post> list() {
		List<Post> ps = new ArrayList<>();
		
		Post p1 = new Post("poste 1");
		p1.setSlug("post-1");
		ps.add(p1);
		return ps;
		//return postService.list();
	}

	@RequestMapping("/byAuthor/{first}")
	public List<Post> byAuthor(@PathVariable(value = "first") String first) {
		return postService.byAuthor(first);
	}

}
