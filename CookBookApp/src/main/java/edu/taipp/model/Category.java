package edu.taipp.model;
import java.util.ArrayList; import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name = "categories") 
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Category {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@Column(nullable = false)
	private String name;
	@JsonBackReference
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Recipe> recipes = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
}