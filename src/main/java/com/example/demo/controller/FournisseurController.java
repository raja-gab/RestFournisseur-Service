package com.example.demo.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Article;
import com.example.demo.service.FournisseurService;


@RestController
public class FournisseurController {
	
		@Autowired
		private FournisseurService fournisseurService ;
		
		
		
		
		@PostMapping("/addarticle")
		public Article addArticle (@RequestBody Article article) {
			Article art = new Article();
			art.setIdArt(article.getIdArt());
			art.setDesigntationArt(article.getDesigntationArt());
			art.setDescriptionArt(article.getDescriptionArt());
			art.setImageName(article.getImageName());
			art.setPrixArt(article.getPrixArt());
			art.setQteStockArt(article.getQteStockArt());
			art.setMarqueArt(article.getMarqueArt());
			art.setSousCategorieArt(article.getSousCategorieArt());
			art.setTauxRemiseArt(article.getTauxRemiseArt());
			art.setFournisseurArt(article.getFournisseurArt());
			fournisseurService.addArticle(art);
			return art ;
			
			
		}
		
		@GetMapping("/getallarticle")
		public List<Article> listArticles()
		{
			return fournisseurService.getAllArticles();
		}
		
		@GetMapping("/getproduct/{id}")
		public Optional< Article> getArticle(@PathVariable ("id") String id )
		{
			return fournisseurService.getArticleById(id);
		}
		
		
		@PutMapping("/modifyarticle/{id}")
		public Article modifyFour(@RequestBody Article article , @PathVariable("id") String id) {
			
					Article art = new Article();
					
					art.setDesigntationArt(article.getDesigntationArt());
					art.setDescriptionArt(article.getDescriptionArt());
					art.setImageName(article.getImageName());
					art.setPrixArt(article.getPrixArt());
					art.setQteStockArt(article.getQteStockArt());
					art.setMarqueArt(article.getMarqueArt());
					art.setSousCategorieArt(article.getSousCategorieArt());
					art.setTauxRemiseArt(article.getTauxRemiseArt());
					art.setFournisseurArt(article.getFournisseurArt());
						
			fournisseurService.updatArticle(art);
			return art;	
		}
		
		@DeleteMapping ("deletearticle/{id}")
		public void deleteArticle (@PathVariable("id") String id)
		{
			fournisseurService.deleteArticle(id);
			
		}
		
		
		
	

		

}
