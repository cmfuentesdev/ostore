package es.ostore.web.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.common.collect.Lists;

import es.ostore.architecture.services.GenericService;

public abstract class AbstractRESTController<T> {

	protected abstract GenericService<T, Long> getMainService();

	@GetMapping()
	public ResponseEntity<List<T>> restListado() {
		return ResponseEntity.ok(getMainService().findAll());
	}

	@GetMapping(path = "/{page}/{size}")
	public ResponseEntity<List<T>> restListado(@PathVariable Integer page, @PathVariable Integer size) {
		return ResponseEntity.ok(Lists.newArrayList(getMainService().findAllPage(page, size)));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<T> restBuscarId(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(getMainService().findById(id));
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().build();
		}
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping(path = "/{id}")
	public ResponseEntity restEliminar(@PathVariable Long id) {
		try {
			getMainService().findById(id);
			getMainService().deleteById(id);
			return ResponseEntity.ok().build();
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().build();
		}
	}

}
