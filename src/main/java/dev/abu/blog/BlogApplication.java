package dev.abu.blog;

import dev.abu.blog.model.Post;
import dev.abu.blog.repasitory.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PostRepository repository){
		return args -> {
			Post post = new Post();
			post.setTitle("My first post");
			post.setContent("This is the content of my first post");
			post.setSlug("my-first-post");
			Date now = new Date();
			post.setDateCreated(now);
			post.setDateUpdated(now);
			repository.save(post);
			System.out.println("Inserted a post: " + post);
		};
	}
}
