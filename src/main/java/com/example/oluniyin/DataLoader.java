package com.example.oluniyin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.oluniyin.domain.Author;
import com.example.oluniyin.domain.Post;
import com.example.oluniyin.repository.AuthorRepository;
import com.example.oluniyin.repository.PostRepository;

@Component
public class DataLoader {
	private PostRepository postRepository;
	private AuthorRepository authorRepository;

	@Autowired
	public DataLoader(PostRepository postRepository, AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
		this.postRepository = postRepository;
	}

	@PostConstruct
	private void loadData() {
		postRepository.deleteAll();
		authorRepository.deleteAll();

		// create an author
		Author gy = new Author("Godson", "YEbadokpo", "godson.yebadokpo@gmail.com");
		authorRepository.save(gy);

		createPosts(gy);
	}

	private void createPosts(Author gy) {
		Date yesterday = null;
		try {
			yesterday = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").parse("17/01/2017 12:00:00 PM");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Post post = new Post("Spring data Rocks");
		post.setSlug("spring-data-rocks");
		post.setTeaser(getTeaser());
		post.setBody(getBody());
		post.setPostedOn(yesterday);
		post.setKeywords(getSpringKeywords());
		post.setActive(false);
		post.setAuthor(gy);
		postRepository.save(post);

		Post grails = new Post("Grails is awesome");
		grails.setSlug("grails-is-awesome");
		grails.setTeaser(getTeaser());
		grails.setBody(getBody());
		grails.setPostedOn(new Date());
		grails.setKeywords(getSpringKeywords());
		grails.setActive(true);
		grails.setAuthor(gy);
		postRepository.save(grails);
	}

	private List<String> getSpringKeywords() {
		List<String> keywords = new ArrayList<String>();
		keywords.add("Spring");
		keywords.add("Spring Data");
		return keywords;
	}

	private String getBody() {
		return "<p>Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l''imprimerie depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n''a pas fait que survivre cinq siècles, mais s''est aussi adapté à la bureautique informatique, sans que son contenu n''en soit modifié. Il a été popularisé dans les années 1960 grâce à la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus récemment, par son inclusion dans des applications de mise en page de texte, comme Aldus PageMaker.</p>";
	}

	private String getTeaser() {
		return "<p>Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression.</p>";
	}

}
