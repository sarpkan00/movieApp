package com.sarpkansavaskan.movieApp.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name = "name", nullable = false, length = 20)
	private String name;
	
	@Column(name = "description", length = 100)
	private String description;
	
	@Column(name = "media")
	private String media;
	
	@NotNull
	@Column(name = "realese_year")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date realeseYear;
	
	@ManyToMany
	@JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie_id"), 
	inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<Genre> genres;
	
	@ManyToMany
	@JoinTable(name = "movie_language", joinColumns = @JoinColumn(name = "movie_id"), 
	inverseJoinColumns = @JoinColumn(name = "language_id"))
	private List<Language> languages;
	
	@ManyToMany
	@JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "movie_id"),
					inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private List<Actor> actors;

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", description=" + description + ", media=" + media
				+ ", realeseYear=" + realeseYear + ", genres=" + genres + ", languages=" + languages + ", actors="
				+ actors + "]";
	}

	
	

}
