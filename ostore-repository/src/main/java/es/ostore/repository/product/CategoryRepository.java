package es.ostore.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.ostore.models.product.CategoryEntity;

@RepositoryRestResource(path = "categories", collectionResourceRel="categories")
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
