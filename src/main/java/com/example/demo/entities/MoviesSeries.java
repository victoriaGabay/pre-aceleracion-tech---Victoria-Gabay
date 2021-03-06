package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "pelicula_serie")

public class MoviesSeries implements Serializable{

	//ENTITY ATRIBUTES
	@Id //SET ID AS PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "titulo")//SPECIFY COLUMN NAME
	private String title;

	@Column(name = "imagen")
	private String imageUrl;
	
	@Column(name = "Fecha_creacion")
	private Date creationDate;
	
	@Column(name = "calificacion")
	private int rate;
	
	//many to many characters/movies
	@JsonIgnore
	@ManyToMany(targetEntity = Characters.class,cascade = CascadeType.MERGE)//TARGET ENTITY IS THE OTHER SIDE OF THE MANYTOMANY
	@JoinTable(name = "pelicula_serie_character", joinColumns = {
    	@JoinColumn(name = "id_peliculas_serie", referencedColumnName = "id",nullable = false,updatable = false)},//linking atribute to column in intermetidate table
    	inverseJoinColumns = {
    	@JoinColumn(name = "id_character", referencedColumnName = "id",nullable = false, updatable = false)})//linking opposite atribute in this case peliculas vs characters
	private Set<Characters> characters;
	
	//many to many genre/movies
	@JsonIgnore
	@ManyToMany(targetEntity = Genre.class,cascade = CascadeType.MERGE)
	@JoinTable(name = "genero_peliculas_series", joinColumns = {
    	@JoinColumn(name = "id_peliculas_series", referencedColumnName = "id",nullable = false,updatable = false)},
    	inverseJoinColumns = {
    	@JoinColumn(name = "id_genre", referencedColumnName = "id",nullable = false, updatable = false)})
	private Set<Genre> genres; 
	
	
	
	
	//GETTERS AND SETTERS

	public Set<Characters> getCharacters() {
		return characters;
	}

	public void setCharacters(Set<Characters> characters) {
		this.characters = characters;
	}



	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public MoviesSeries() {
		// TODO Auto-generated constructor stub
	}

}
