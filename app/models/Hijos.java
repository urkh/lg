package models;

import java.util.*;

import play.data.format.*;
import play.data.validation.*;
import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class Hijos extends Model {
	
	@Id
	public Long id;
	
	@Constraints.Required
	@ManyToOne
	public Persona persona;
	
	public Integer cedulaH;
	
	@Constraints.Required
	public String nombreH;
	
	@Constraints.Required
	public String apellidoH;
	
	@Constraints.Required
	public String fechaNac;
	
	@Constraints.Required
	public String sexo;

	public String discapacidad;
	
	@Constraints.Required
	public String grado;
	

}
