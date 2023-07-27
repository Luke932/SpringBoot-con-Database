package luke932.springjpa.dao;

import java.util.List;

import luke932.springjpa.entities.Pizza;

public interface IPizzaDAO {
	public void save(Pizza pizza);

	public void findByIdAndUpdate(Long id, Pizza pizza);

	public void findByIdAndDelete(Long id);

	public Pizza findById(Long id);

	public List<Pizza> findAll();

	public long count();

	public List<Pizza> findByPartialNameIgnoreCase(String name);
}
