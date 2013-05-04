package modelo;

import play.data.validation.*;
import play.db.ebean.*;

import javax.persistence.*;

@Entity
public class Salud extends Model {


	@Id
	public Long id;

	@Constraints.Required
	@ManyToOne
	public Persona persona;


	public String enfermedad;

	public String medicamentos;

	public String tipoOp;

	public String tiempoEnf;




}