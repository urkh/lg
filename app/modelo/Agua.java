package modelo;

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
	@Formats.DateTime(pattern="yyyy-mm-dd")
	public Date fechaPago;

	@Constraints.Required
	@Formats.DateTime(pattern="yyyy-mm-dd")
	public Date mesCorrespondiente;

	

}
