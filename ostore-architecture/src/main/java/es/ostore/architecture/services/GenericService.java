package es.ostore.architecture.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface GenericService<T, ID extends Serializable> {

	T findById(ID id);

	T findByExample(T entity);

	List<T> findAll();
	
	Iterable<T> findAllPage(Integer page, Integer size);

	T insert(final T entity);

	T update(final T entity);

	void delete(final T entity);

	void deleteById(final ID id);

}
