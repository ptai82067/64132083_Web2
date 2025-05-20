package edu.taipp.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name = "ratings") 
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class Rating { 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

	@Column(nullable = false)
	private Integer score;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@JsonBackReference
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "recipe_id", nullable = false)
	@JsonBackReference
	private Recipe recipe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
}
