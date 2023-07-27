package luke932.springjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import luke932.springjpa.entities.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
	List<Pizza> findByNameStartingWithIgnoreCase(String name);
}
