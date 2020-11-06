package es.ostore.web.rest.error;

public class ProductoNotFoundException extends RuntimeException{
	
	public ProductoNotFoundException(Long id) {
		super("No se ha encontrado producto con el ID: " + id);
	}
	
}
