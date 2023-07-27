package luke932.springjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import luke932.springjpa.dao.IPizzaDAO;
import luke932.springjpa.entities.Pizza;
import luke932.springjpa.exceptions.ItemNotFoundException;

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

		// ----------------FIND-ALL---------------------
		try {
			Pizza marinara = new Pizza("Marinara", 9.50, 900);
			pDAO.findByIdAndUpdate((long) 52, marinara);
		} catch (ItemNotFoundException e) {
			log.error(e.getMessage());
		}

		// ----------------DELETE-------------------------
		try {
			pDAO.findByIdAndDelete((long) 2);
		} catch (ItemNotFoundException e) {
			log.error(e.getMessage());
		}

		// ----------------COUNT---------------------------
		log.info("Count --> " + pDAO.count());

		// ----------------FIND BY ID----------------------
		try {
			log.info(pDAO.findById((long) 2).toString());
		} catch (ItemNotFoundException e) {
			log.error(e.getMessage());
		}

		// ---------------FIND ALL-------------------------
		pDAO.findAll().forEach(pizza -> log.info(pizza.toString()));

		// ---------------FIND ALL IGNORE CASE-------------
		pDAO.findByPartialNameIgnoreCase("p").forEach(pizza -> log.info(pizza.toString()));
	}

}
