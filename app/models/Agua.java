package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.*;
import play.data.format.*;

@Entity
public class Agua extends Model {
	
	@Id
	public Long id;
	
	@Constraints.Required
	@ManyToOne
	public Persona persona;
	
	@Constraints.Required
	public Double monto;
	
	@Constraints.Required
	public String fechaPago;

	@Constraints.Required
	public String mesCorrespondiente;

	

}
