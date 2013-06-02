package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.*;
import play.data.format.*;
import com.avaje.ebean.*;

@Entity
public class Tierras extends Model {
	
	@Id
	public Long id;
	
	@Constraints.Required
	@ManyToOne
	public Persona persona;
	
	public String credito;

	public String fundo;

	public String este;

	public String oeste;

	public String norte;

	public String sur;
	
	@Constraints.Required
	public String fecha;

	public String estado;


	public static Finder<Long, Tierras> buscar = new Finder<Long, Tierras>(Long.class, Tierras.class);


	public static Page<Tierras> pagina(int pagina, int tamanoPagina, String ordenarPor, String ordenar, String filtrar) {
		return buscar.where().ilike("persona.cedula", "%" + filtrar + "%").orderBy(ordenarPor + " " + ordenar).fetch("persona").findPagingList(tamanoPagina).getPage(pagina);
	}


	public static List<Tierras> listar(){
		List<Tierras> listar = Ebean.find(Tierras.class).fetch("persona").findList();
		return listar;
	}

}
