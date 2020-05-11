package com.example.demo.entity;




import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	
	@Id
	private String _id;
	
	private String designtationArt;
	private String descriptionArt;
	private  double prixArt;
	private int qteStockArt;
	private double tauxRemiseArt;

	private Marque marqueArt;

	private SousCategorie sousCategorieArt;

	private Fournisseur fournisseurArt;
	
	private ImageModel imageModel ;
	

}
