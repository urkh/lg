package models;

import play.db.ebean.*;
import play.data.validation.*;
import play.data.format.*;

import java.util.*;

import javax.persistence.*;
import com.avaje.ebean.Page;


@Entity
public class IgualdadSocial extends Model {

	@Id
	public Long id;

	@Constraints.Required
	@ManyToOne
	public Persona persona;

	@Constraints.Required
	public String tipoAyuda;

	@Constraints.Required
	public String fecha;



	public static Finder<Long, IgualdadSocial> buscar = new Finder<Long, IgualdadSocial>(Long.class, IgualdadSocial.class);


	public static Page<IgualdadSocial> pagina(int pagina, int tamanoPagina, String ordenarPor, String ordenar, String filtrar) {
		return buscar.where().ilike("persona.cedula", "%" + filtrar + "%").orderBy(ordenarPor + " " + ordenar).fetch("persona").findPagingList(tamanoPagina).getPage(pagina);
	}


}