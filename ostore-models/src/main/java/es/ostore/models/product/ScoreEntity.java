package es.ostore.models.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SCORES")
public class ScoreEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7236643476708464378L;

	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "SCORE", nullable = false)
	private Short score;
	
	@Column(name = "COMMENTS", nullable = false)
	private String comments;
}
