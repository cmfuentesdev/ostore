package es.ostore.models.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class ProductEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8140648045806532431L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", nullable = false, /* unique = true, */ length = 100)
	@NotNull(message = "El nombre del producto es obligatorio")
	@NotBlank(message = "El nombre del producto no puede estar vacío")
	@Size(min = 3, max = 100, message = "El nombre del producto debe contener entre 3 y 100 caracteres")
	private String nombre;

	@Lob
	@Column(name = "DESCRIPTION")
	@NotNull(message = "La descripción del producto es obligatoria")
	@NotBlank(message = "La descripción del producto no puede estar vacía")
	private String descripcion;

	@Column(name = "PRICE")
	@NotNull(message = "El precio del producto es obligatorio")
	@Min(0)
	private Float precioReal;

	@Column(name = "DISCOUNT")
	private Integer descuento;

	@URL
	@Column(name = "IMAGE_URL")
	@NotNull(message = "La imagen del producto es obligatoria")
	private String urlImagen;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "ID_CATEGORY", nullable = false)
	private CategoryEntity category;

}
