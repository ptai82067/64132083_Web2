package edu.taipp.model;
import java.time.LocalDateTime;

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
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "recipe_id", nullable = false)
	private Recipe recipe;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt = LocalDateTime.now();

}
