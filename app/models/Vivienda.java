package models;

import play.db.ebean.*;
import play.data.validation.*;
import play.data.format.*;

import java.util.*;

import javax.persistence.*;
import com.avaje.ebean.Page;

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


	public static Finder<Long, Vivienda> buscar = new Finder<Long, Vivienda>(Long.class, Vivienda.class);


	public static Page<Vivienda> pagina(int pagina, int tamanoPagina, String ordenarPor, String ordenar, String filtrar) {
		return buscar.where().ilike("persona.cedula", "%" + filtrar + "%").orderBy(ordenarPor + " " + ordenar).fetch("persona").findPagingList(tamanoPagina).getPage(pagina);
	}


}
