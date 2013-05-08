package modelo;

import play.db.ebean.*;
import play.data.validation.*;
import play.data.format.*;

import javax.persistence.*;

import java.util.*;


@Entity
public class Alimentacion extends Model {

	
	@Id
	public Long id;

	@Constraints.Required
	@ManyToOne
	public Persona persona;

	@Constraints.Required
	public String denuncia;

	@Constraints.Required
	@Formats.DateTime(pattern="yyyy-mm-dd")
	public Date fecha;

	@Constraints.Required
	public String denunciado;


	
	
}
