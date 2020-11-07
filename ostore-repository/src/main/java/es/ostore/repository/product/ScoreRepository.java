package es.ostore.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.ostore.models.product.ScoreEntity;

@RepositoryRestResource(path = "scores", collectionResourceRel="scores")
public interface ScoreRepository extends JpaRepository<ScoreEntity, Long> {

}
