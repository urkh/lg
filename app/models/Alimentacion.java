package models;

import play.db.ebean.*;
import play.data.validation.*;
import play.data.format.*;

import javax.persistence.*;

import java.util.*;
import com.avaje.ebean.Page;


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
	public String fecha;

	@Constraints.Required
	public String denunciado;


	public static Finder<Long, Alimentacion> buscar = new Finder<Long, Alimentacion>(Long.class, Alimentacion.class);


	public static Page<Alimentacion> pagina(int pagina, int tamanoPagina, String ordenarPor, String ordenar, String filtrar) {
		return buscar.where().ilike("persona.cedula", "%" + filtrar + "%").orderBy(ordenarPor + " " + ordenar).fetch("persona").findPagingList(tamanoPagina).getPage(pagina);
	}

	


	
	
}
