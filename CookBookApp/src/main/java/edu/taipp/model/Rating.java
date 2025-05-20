package edu.taipp.model;
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
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "recipe_id", nullable = false)
	private Recipe recipe;

}
