package es.ostore.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.ostore.models.product.ProductEntity;

@RepositoryRestResource(path = "products", collectionResourceRel="products")
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
