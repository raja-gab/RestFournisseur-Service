package com.example.demo.controller;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Article;
import com.example.demo.entity.Categorie;
import com.example.demo.entity.Fournisseur;
import com.example.demo.entity.Marque;
import com.example.demo.entity.SousCategorie;
import com.example.demo.service.FournisseurService;




@RestController
public class FournisseurController {
	
		@Autowired
		private FournisseurService fournisseurService ;
		
		
		/* Gestion des Articles  Ajout + Update + Delete + Affichage */
		
		@PostMapping("/addarticle")
		public Article addArticle (@RequestBody Article article) {
			Article art = new Article();
			art.setIdArt(article.getIdArt());
			art.setDesigntationArt(article.getDesigntationArt());
			art.setDescriptionArt(article.getDescriptionArt());
			art.setImageModel(article.getImageModel());
			art.setPrixArt(article.getPrixArt());
			art.setQteStockArt(article.getQteStockArt());
			art.setMarqueArt(article.getMarqueArt());
			art.setSousCategorieArt(article.getSousCategorieArt());
			art.setTauxRemiseArt(article.getTauxRemiseArt());
			art.setFournisseurArt(article.getFournisseurArt());
			fournisseurService.addArticle(art);
			return art ;
			
			
		}
		
		 @GetMapping("/listarticle")
		public CollectionModel<Article>  listArticles()
		{
			return fournisseurService.findAllArticle();
		} 
		
		@GetMapping("/getproduct/{id}")
		public Optional< Article> getArticle(@PathVariable ("id") String id )
		{
			return fournisseurService.getArticleById(id);
		}
		
		
		@PutMapping("/modifyarticle/{id}")
		public Article modifyArticle(@RequestBody Article article , @PathVariable("id") String id) {
			
					Article art = new Article();
					art.setDesigntationArt(article.getDesigntationArt());
					art.setDescriptionArt(article.getDescriptionArt());
					art.setImageModel(article.getImageModel());
					art.setPrixArt(article.getPrixArt());
					art.setQteStockArt(article.getQteStockArt());
					art.setMarqueArt(article.getMarqueArt());
					art.setSousCategorieArt(article.getSousCategorieArt());
					art.setTauxRemiseArt(article.getTauxRemiseArt());
					art.setFournisseurArt(article.getFournisseurArt());
						
			fournisseurService.updatArticle(art,id);
			return art;	
		}
		
		@DeleteMapping ("deletearticle/{id}")
		public void deleteArticle (@PathVariable("id") String id)
		{
			fournisseurService.deleteArticle(id);	
		}
		
		/* Ajout Marque + list Marque */
		
		@PostMapping("/marque/add")
		public Marque addMarque (@RequestBody Marque marque )
		{
			Marque m = new Marque(); 
			m.setIdMarq(marque.getIdMarq());
			m.setLibelleMarq(marque.getLibelleMarq());
			
			fournisseurService.addMarque(m);
			return m ; 
		}
		@GetMapping ("/marque/list")
		public CollectionModel<Marque> listMarque ()
		{
			return fournisseurService.findAllMarque();
		}
		
		@GetMapping ("/marque/{id}")
		public Optional< Marque> getMarque (@PathVariable ("id") String id )
		{
			return fournisseurService.findMarqueById(id);
		}
		
		@PutMapping("/marque/update/{id}")
		public Marque modifyMarque  (@RequestBody Marque marque, @PathVariable ("id")  String id)
		{
			Marque m = new Marque(); 
			m.setLibelleMarq(marque.getLibelleMarq());
			fournisseurService.updateMarque(m, id);
			return m ;
		}
		
	
		
		
		/* Afiichage + Ajout Sous_Cathegorie */
		
		@PostMapping("/souscategorie/add")
		public SousCategorie addSousCategorie (@RequestBody SousCategorie sousCategorie )
		{
			SousCategorie sousCat = new SousCategorie(); 
			sousCat.setIdSousCat(sousCategorie.getIdSousCat());
			sousCat.setLibelleSousCat(sousCategorie.getLibelleSousCat());
			sousCat.setValeur(sousCategorie.getValeur());
			sousCat.setCategorie(sousCategorie.getCategorie());
			
			fournisseurService.addSousCategorie(sousCat);
			return sousCat ; 
		}
		
		@GetMapping ("/souscategorie/list")
		public CollectionModel<SousCategorie> listSousCategorie ()
		{
			return fournisseurService.findAllSousCategorie();
		}
		
		@GetMapping ("/souscategorie/{id}")
		public Optional< SousCategorie> getSousCategorie (@PathVariable ("id") String id )
		{
			return fournisseurService.findSousCategorieById(id);
		}
		
		
		
		/* Ajout + Affichage Categorie */ 
		
		@PostMapping("/categorie/add")
		public Categorie addCategorie (@RequestBody Categorie categorie )
		{
			Categorie cat = new Categorie(); 
			cat.setIdCat(categorie.getIdCat());
			cat.setLibelleCat(categorie.getLibelleCat());
			
			fournisseurService.addCategorie(cat);
			return cat; 
		}
		
		@GetMapping ("/categorie/list")
		public CollectionModel<Categorie> listCategorie ()
		{
			return fournisseurService.findAllCategorie();
		}
		
		@GetMapping ("/categorie/{id}")
		public Optional< Categorie> getCategorie (@PathVariable ("id") String id )
		{
			return fournisseurService.findCategorieById(id);
		}
				
		
		/* Modifier Porfil Fournisseur */
		
		
		@GetMapping ("/getfournisseur/{id}")
		public Fournisseur findFournisseurById (@PathVariable ("id") String id )
		{
			return fournisseurService.findFournisseurById(id);
		}
		
		@PutMapping ("/mofiyfournisseur/{id}")
		public Fournisseur updateFournisseur (@RequestBody Fournisseur fournisseur , @PathVariable ("id") String id )
		{
			Fournisseur four = new Fournisseur();
			four.setNom(fournisseur.getNom());
			four.setAdresseFour(fournisseur.getAdresseFour());
			four.setLogin(fournisseur.getLogin());
			four.setPassword(fournisseur.getPassword());
			four.setPrenom(fournisseur.getPrenom());
			four.setNumTelFour(fournisseur.getNumTelFour());
			
			fournisseurService.updateFournisseur(four, id);
			return four ; 
		}
		
		/*    Vente Flash      */
	

		

}
