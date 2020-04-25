package com.example.demo.controller;




import java.awt.Image;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.scheduling.annotation.Scheduled;
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
import com.example.demo.entity.VenteFlash;
import com.example.demo.service.FournisseurService;
import com.example.demo.service.RestAdminService;





@RestController
public class FournisseurController {
	
		@Autowired
		private FournisseurService fournisseurService ;
		//@Autowired
		//private RestAdminService restAdminService;
		
		
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
			art.setTauxRemiseArt(article.getTauxRemiseArt());
			Marque m = fournisseurService.findMarqueById(article.getMarqueArt().getIdMarq());
			art.setMarqueArt(m);
			SousCategorie sousCat = fournisseurService.findSousCategorieById(article.getSousCategorieArt().getIdSousCat());
			art.setSousCategorieArt(sousCat);
			Fournisseur f = fournisseurService.findFournisseurById(article.getFournisseurArt().getUsername());
			art.setFournisseurArt(f);
			fournisseurService.addArticle(art);
			return art ;
			
			
		}

		
		 @GetMapping("/listarticle")
		public CollectionModel<Article>  listArticles()
		{
			return fournisseurService.findAllArticle();
		} 
		
		@GetMapping("/getproduct/{id}")
		public  Article getArticle(@PathVariable ("id") String id )
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
					art.setTauxRemiseArt(article.getTauxRemiseArt());
					Marque m = fournisseurService.findMarqueById(article.getMarqueArt().getIdMarq());
					art.setMarqueArt(m);
					SousCategorie sousCat = fournisseurService.findSousCategorieById(article.getSousCategorieArt().getIdSousCat());
					art.setSousCategorieArt(sousCat);
					Fournisseur f = fournisseurService.findFournisseurById(article.getFournisseurArt().getUsername());
					art.setFournisseurArt(f);
					
					
						
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
		public  Marque getMarque (@PathVariable ("id") String id )
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
			Categorie cat = fournisseurService.findCategorieById(sousCategorie.getCategorie().get_id());
			if (cat != null )
			{
				System.err.println(cat);
				sousCat.setCategorie(cat);
			}
	        
			fournisseurService.addSousCategorie(sousCat);
			return sousCat ; 
			
		}
		
		@GetMapping ("/souscategorie/list")
		public CollectionModel<SousCategorie> listSousCategorie ()
		{
			return fournisseurService.findAllSousCategorie();
		}
		
		@GetMapping ("/souscategorie/{id}")
		public SousCategorie getSousCategorie (@PathVariable ("id") String id )
		{
			return fournisseurService.findSousCategorieById(id);
		}
		
		
		
		/* Ajout + Affichage Categorie */ 
		
		@PostMapping("/categorie/add")
		public Categorie addCategorie (@RequestBody Categorie categorie )
		{
			Categorie cat = new Categorie(); 
			cat.set_id(categorie.get_id());
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
		public  Categorie getCategorie (@PathVariable ("id") String id )
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
			four.setAdresse(fournisseur.getAdresse());
			four.setUsername(fournisseur.getUsername());
			four.setPassword(fournisseur.getPassword());
			four.setPrenom(fournisseur.getPrenom());
			four.setPhoneNumber(fournisseur.getPhoneNumber());
			
			fournisseurService.updateFournisseur(four, id);
			return four ; 
		}
		
		/*    Vente Flash      */
		
	/*	@PostMapping("/postventeflash")
		public VenteFlash postVenteFlash (@RequestBody VenteFlash venteFlash)
		{
			VenteFlash v = restAdminService.postVenteFlash(venteFlash);
			
			fournisseurService.addVenteFlash(v);
			return v ; 
			
		}*/
		
		
		
		
		
		
		
		
		/*@PostMapping("/addetatventeflash")
		 EtatArticleVenteFlash addEtatArticleVenteFlash (@RequestBody EtatArticleVenteFlash etat)
		{
			EtatArticleVenteFlash e = new EtatArticleVenteFlash();
			e.setIdAVF(etat.getIdAVF());
			e.setPrixAVF(etat.getPrixAVF());
			e.setQteAVF(etat.getQteAVF());
			Article a = fournisseurService.getArticleById(e.getArticleAVF().getIdArt());
			e.setArticleAVF(a);
			a.setQteStockArt((a.getQteStockArt())-(e.getQteAVF()));
					
			fournisseurService.addEtatArticleVenteFlash(e);
			return e ; 
		}
		
		public void addEtatToVenteFlash ( String idVF , String idEVF ) {
			
			VenteFlash v  = fournisseurService.findVenteFlashById(idVF);
			EtatArticleVenteFlash etat = fournisseurService.findEtatArticleVenteFlashById(idEVF);
			v.getEtatArticleVenteFlashs().add(etat);	
		
		}
		
	        
		
		@PostMapping("/addventeflash")
		public VenteFlash addVenteFlash(@RequestBody VenteFlash venteFlash , @RequestBody String idEtat)
		{
			EtatArticleVenteFlash etat = fournisseurService.findEtatArticleVenteFlash(idEtat); 
			VenteFlash v = new VenteFlash();
			v.setIdVF(venteFlash.getIdVF());
			v.setDateDebVF(venteFlash.getDateDebVF());
			v.setDateFinVF(venteFlash.getDateFinVF());
			//addEtatToVenteFlash(v.getIdVF(), etat.getIdAVF());
			
			fournisseurService.addVenteFlash(v);
			 return v;
		}
		
		
		
		@Scheduled(cron = "1 * * * * *")
		@DeleteMapping("/deleteventeflash/{id}")
		public void  deleteVenteFlash (@PathVariable ("id") String id )
		{
			LocalDateTime date = LocalDateTime.now();
			VenteFlash v = fournisseurService.findVenteFlashById(id);
			if (date.isAfter(v.getDateFinVF()))
			{
				fournisseurService.deleteVenteFlash(id);
			}
		}*/
		
	
	
       
		
		
		
		}
		

		


