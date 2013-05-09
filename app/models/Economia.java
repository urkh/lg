package models;

import play.db.ebean.*;
import play.data.validation.*;
import play.data.format.*;

import java.util.*;
import javax.persistence.*;

@Entity
public class Economia extends Model {
	
	@Id
	public Long id;
	
	@Constraints.Required
	@ManyToOne
	public Persona persona;

	@Constraints.Required
	@Formats.DateTime(pattern="yyyy-mm-dd")
	public Date fecha;

	//empleo, curso o postulacion
	@Constraints.Required
	public String solicitud;

	//empleo o curso a realizar
	@Constraints.Required
	public String tipoSol;

	public String empresa;

	public String turno;

	public String dias;


	
	

}
