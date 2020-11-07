package es.ostore.models.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CATEGORIES")
public class CategoryEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8549742407941525423L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", nullable = false, /* unique = true, */ length = 100)
	@NotNull(message = "El nombre de la categoría es obligatorio")
	@NotBlank(message = "El nombre de la categoría no puede estar vacío")
	@Size(min = 3, max = 100, message = "El nombre del producto debe contener entre 3 y 100 caracteres")
	private String name;
}
