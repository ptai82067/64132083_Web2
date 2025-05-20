package edu.taipp.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name = "recipe_ingredients") 
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class RecipeIngredient { 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

	@ManyToOne
	@JoinColumn(name = "recipe_id", nullable = false)
	@JsonBackReference
	private Recipe recipe;
	
	@ManyToOne
	@JoinColumn(name = "ingredient_id", nullable = false)
	@JsonBackReference
	private Ingredient ingredient;
	
	private String quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
