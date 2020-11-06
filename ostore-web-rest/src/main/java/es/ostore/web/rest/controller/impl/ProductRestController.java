package es.ostore.web.rest.controller.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ostore.architecture.services.GenericService;
import es.ostore.models.product.ProductEntity;
import es.ostore.services.product.ProductService;
import es.ostore.web.rest.controller.AbstractRESTController;

//@RestController
//@RequestMapping("/rest/products")
public class ProductRestController extends AbstractRESTController<ProductEntity>{
	
	@Autowired
	private ProductService service;

	@Override
	protected GenericService<ProductEntity, Long> getMainService() {
		return service;
	}
	
	@PostMapping
	public ResponseEntity<ProductEntity> restCrear(@RequestBody ProductEntity entity) throws ServiceException {
		return ResponseEntity.ok(service.insert(entity));
	}

}
