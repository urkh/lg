package models;

import java.util.*;

import play.data.format.*;
import play.data.validation.*;
import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class HijosPersonas extends Model {
	
	@Id
	public Long id;
	
	@Constraints.Required
	@ManyToOne
	public Persona persona;
	
	public Integer cedula;
	
	@Constraints.Required
	public String nombre;
	
	@Constraints.Required
	public String apellido;
	
	@Constraints.Required
	@Formats.DateTime(pattern = "yyyy-mm-dd")
	public Date fechaNac;
	
	@Constraints.Required
	public Character sexo;

	public String discapacidad;
	
	@Constraints.Required
	public String grado;
	

}
