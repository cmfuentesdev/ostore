package es.ostore.repository.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import es.ostore.models.product.ProductEntity;

@RepositoryRestResource(path = "products", collectionResourceRel = "products")
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	@RestResource(path = "productsByName", rel = "productsByName")
	public Page<ProductEntity> findByNameContains(String name, Pageable p);
	
	@RestResource(path = "productsByCategory", rel = "productsByCategory")
	public Page<ProductEntity> findByCategoryId(Long id, Pageable p);
}
