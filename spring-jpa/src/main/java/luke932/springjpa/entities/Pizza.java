package luke932.springjpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "pizze")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Pizza {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private double price;
	private int calories;

	public Pizza(String name, double price, int calories) {
		super();
		this.name = name;
		this.price = price;
		this.calories = calories;
	}

}
