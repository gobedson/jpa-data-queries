package com.example.oluniyin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oluniyin.domain.Post;
import com.example.oluniyin.repository.PostRepository;

/**
 * 
 * @author gyebadokpo.ext
 *
 */
@Service
public class PostService {

	private PostRepository postRepository;
	
	@Autowired
	public PostService(PostRepository postRepository) {
		
		this.postRepository = postRepository;
	}
	
	public Iterable<Post> list(){
		return postRepository.findAll();
	}

	public List<Post> byAuthor(String first) {
		return postRepository.findByAuthorFirstNameIgnoreCaseOrderByPostedOnDesc(first);
	}

	
	

}
