package es.ostore.architecture.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import es.ostore.architecture.services.GenericService;

public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

	protected abstract PagingAndSortingRepository<T, ID> getRepository();

	@Override
	public T findById(ID id) {
		return getRepository().findById(id).orElse(null);
	}

	@Override
	public List<T> findAll() {
		return (List<T>) getRepository().findAll();
	}
	
	
	public Iterable<T> findAllPage(Integer page, Integer size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		return (Iterable<T>) getRepository().findAll(pageRequest);
	}

	@Override
	public T insert(T entity) {
		return getRepository().save(entity);
	}

	@Override
	public T update(T entity) {
		return getRepository().save(entity);
	}

	@Override
	public void delete(T entity) {
		getRepository().delete(entity);

	}

	@Override
	public void deleteById(ID id) {
		getRepository().deleteById(id);
	}

}
