package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

class ArticleVenteFlash extends Article {
	
	private  double prixArt;
	private int qteStockArtVF;
	
	
	public void setQteStockArtVF(int qteStockArtVF) {
		super.setQteStockArt(super.getQteStockArt()-qteStockArtVF);
		this.qteStockArtVF = qteStockArtVF;
	}
	
	
}


