package models;

import java.util.Date;

import javax.persistence.*;

import play.data.validation.*;
import play.data.format.*;

import play.db.ebean.*;

@Entity
public class Persona extends Model {

	@Id
	public Long id;
	
	@Constraints.Required
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
	
	@Constraints.Required
	public String direccion;
	
	public String telefono;

	@Constraints.Required
	public String gradoInstruccion;
	
	@Constraints.Required
	public Double ingresoMensual;
	
	@Constraints.Required
	public String estadoCivil;
	
	@Constraints.Required
	public Character tipoVivienda;
	

	
	
	
	
	
	
	
	
	
}
