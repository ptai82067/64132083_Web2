package edu.taipp.model;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name = "comments") 
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class Comment { 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@JsonBackReference
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "recipe_id", nullable = false)
	@JsonBackReference
	private Recipe recipe;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt = LocalDateTime.now();

	public Comment() {
	}

	public Comment(String content, User user, Recipe recipe) {
		this.content = content;
		this.user = user;
		this.recipe = recipe;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
