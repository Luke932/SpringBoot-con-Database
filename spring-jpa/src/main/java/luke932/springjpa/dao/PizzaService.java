package luke932.springjpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import luke932.springjpa.entities.Pizza;

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
		// TODO Auto-generated method stub

	}

	@Override
	public void findByIdAndDelete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pizza> findAll() {
		return pizzaRep.findAll();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Pizza> findByPartialNameIgnoreCase(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
