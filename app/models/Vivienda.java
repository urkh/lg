package models;

import play.db.ebean.*;
import play.data.validation.*;
import play.data.format.*;

import java.util.*;

import javax.persistence.*;

@Entity
public class Vivienda extends Model {
	
	@Id
	public Long id;
	
	@Constraints.Required
	@ManyToOne
	public Persona persona;

	@Constraints.Required
	public String solicitud;
	
	@Constraints.Required
	public String fechaSol;

	public String rehabilitacion;
}
