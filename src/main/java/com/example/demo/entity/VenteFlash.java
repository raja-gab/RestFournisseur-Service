package com.example.demo.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteFlash {
	

	private String idVF;
	private Date dateDebVF;
	private Date dateFinVF;
	private float promotionVF;
	private int qteVF;

	private Article articleVF;
	private Fournisseur fournisseurVF;

}
