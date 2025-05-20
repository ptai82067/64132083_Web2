package edu.taipp.model;
import java.util.ArrayList; import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name = "ingredients") 
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class Ingredient { 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

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

	public List<RecipeIngredient> getRecipeIngredients() {
		return recipeIngredients;
	}

	public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}
}