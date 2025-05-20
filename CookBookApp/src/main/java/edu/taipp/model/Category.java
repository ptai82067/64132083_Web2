package edu.taipp.model;
import java.util.ArrayList; import java.util.List;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name = "categories") 
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Category {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@Column(nullable = false)
	private String name;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Recipe> recipes = new ArrayList<>();

}