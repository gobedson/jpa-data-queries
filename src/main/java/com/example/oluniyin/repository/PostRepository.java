package com.example.oluniyin.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.oluniyin.domain.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
	
	//AUTHOR===========================================================
	List<Post>findByAuthorFirstName(String first);
	List<Post> findByAuthorFirstNameIgnoreCase(String first);
	List<Post> findByAuthorFirstNameIgnoreCaseOrderByPostedOnDesc(String first);

}
