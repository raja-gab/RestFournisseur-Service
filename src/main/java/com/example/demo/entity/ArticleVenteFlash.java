package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ArticleVenteFlash extends Article {
	
	private  double prixArtVF;
	private int qteStockArtVF;
	
	
	public void setQteStockArtVF(int qteStockArtVF) {
		super.setQteStockArt(super.getQteStockArt()-qteStockArtVF);
		this.qteStockArtVF = qteStockArtVF;
	}
	
	
}


