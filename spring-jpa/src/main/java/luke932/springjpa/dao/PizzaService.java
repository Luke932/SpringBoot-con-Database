package luke932.springjpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import luke932.springjpa.entities.Pizza;
import luke932.springjpa.exceptions.ItemNotFoundException;

@Service
@Slf4j
public class PizzaService implements IPizzaDAO {
	@Autowired
	private PizzaRepository pizzaRep;

	public void save(Pizza pizza) {
		pizzaRep.save(pizza);
		log.info(pizza.toString());
	}

	@Override
	public void findByIdAndUpdate(Long id, Pizza pizza) {
		Pizza found = this.findById(id);

		found.setId(id);
		found.setName(pizza.getName());
		found.setCalories(pizza.getCalories());
		found.setPrice(pizza.getPrice());

		pizzaRep.save(found);
	}

	@Override
	public void findByIdAndDelete(Long id) throws ItemNotFoundException {
		Pizza found = this.findById(id);
		pizzaRep.delete(found);
	}

	@Override
	public Pizza findById(Long id) throws ItemNotFoundException {
		return pizzaRep.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}

	@Override
	public List<Pizza> findAll() {
		return pizzaRep.findAll();
	}

	@Override
	public long count() {
		return pizzaRep.count();
	}

	@Override
	public List<Pizza> findByPartialNameIgnoreCase(String name) {
		return pizzaRep.findByNameStartingWithIgnoreCase(name);
	}

}
