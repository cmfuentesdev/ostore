package es.ostore.services.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ostore.architecture.services.impl.GenericServiceImpl;
import es.ostore.models.product.ProductEntity;
import es.ostore.repository.product.ProductRepository;
import es.ostore.services.product.ProductService;

@Service
public class ProductServiceImpl extends GenericServiceImpl<ProductEntity, Long> implements ProductService {

	@Autowired
	protected ProductRepository productRepository;
	
	@Override
	protected ProductRepository getRepository() {
		return productRepository;
	}

	@Override
	public ProductEntity findByExample(ProductEntity entity) {
		return null;
	}
}
