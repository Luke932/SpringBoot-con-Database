package luke932.springjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import luke932.springjpa.dao.IPizzaDAO;
import luke932.springjpa.entities.Pizza;

@Component
@Slf4j
public class PizzaRunner implements CommandLineRunner {
	@Autowired
	private IPizzaDAO pDAO;

	@Override
	// ---------------SAVE------------------------
	public void run(String... args) throws Exception {
		Pizza margherita = new Pizza("Capricciosa", 8.00, 500);
		log.info(margherita.toString());
		pDAO.save(margherita);

	}

}
