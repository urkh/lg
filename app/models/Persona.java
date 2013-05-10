package models;

import java.util.Date;

import javax.persistence.*;

import play.data.validation.*;

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
	public String fechaNac;
	
	@Constraints.Required
	public String sexo;
	
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
	public String tipoVivienda;
	

	
	
	
	
	
	
	
	
	
}
