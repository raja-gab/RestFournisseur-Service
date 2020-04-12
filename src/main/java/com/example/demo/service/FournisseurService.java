package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Article;



@FeignClient(name = "CrudApplication" )
public interface FournisseurService {

	
	@GetMapping("/article/{id}")
	public Optional<Article> getArticleById(@PathVariable("id") String id);
	
	@GetMapping("/getallarticle")
	public List<Article> getAllArticles();
	
	@PostMapping("/article")
	public Article addArticle (@RequestBody Article article);	
	
	@PutMapping("/article/{id}")
	public Article  updatArticle (@RequestBody Article article , @PathVariable("id") String id);
	
	@DeleteMapping("/article/{id}")
	public Optional<Article>  deleteArticle (@PathVariable("id") String id);
	
	
	
	
}
