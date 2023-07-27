package luke932.springjpa.exceptions;

public class ItemNotFoundException extends RuntimeException {

	public ItemNotFoundException(Long id) {
		super("Item with id " + id + " not found!");
	}

}
