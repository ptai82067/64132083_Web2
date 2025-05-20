package edu.taipp.model;
import java.util.ArrayList; import java.util.List;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name = "ingredients") 
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class Ingredient { 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
	private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

}