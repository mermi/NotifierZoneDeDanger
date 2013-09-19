package com.jetmultimedia.tunistreet.model;

public class ZoneDanger {

	private int idZone;
	private int idCompte;
	private double latitude;
	private double longitude;
	private String adresse;
	private String date;
	private String categorie;
	private String details;
	private int evaluation;
	private String image;

	public ZoneDanger() {
	}

	public ZoneDanger(int idZone, int idCompte, double latitude, double longitude,
			String adresse, String date, String details, String categorie, int evaluation, String image) {
		this.idZone = idZone;
		this.idCompte = idCompte;
		this.latitude = latitude;
		this.longitude = longitude;
		this.adresse = adresse;
		this.date = date;
		this.categorie = categorie;
		this.details = details;
		this.evaluation = evaluation;
		this.image = image;
	}

	
	public int getIdZone() {
		return idZone;
	}

	public void setIdZone(int idZone) {
		this.idZone = idZone;
	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

}
