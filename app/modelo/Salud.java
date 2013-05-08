package modelo;

import play.data.format.*;
import play.data.validation.*;
import play.db.ebean.*;

import java.util.*;

import javax.persistence.*;

@Entity
public class Salud extends Model {

	@Id
	public Long id;

	@Constraints.Required
	@ManyToOne
	public Persona persona;

	@Constraints.Required
	@Formats.DateTime(pattern="yyyy-mm-dd")
	public Date fecha;

	public String enfermedad;

	public String medicamentos;

	public String tipoOp;

	public String tiempoEnf;




}