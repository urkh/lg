package models;


import javax.persistence.*;
import java.util.*;

import play.db.ebean.*;
import play.data.validation.*;
import play.data.format.*;


import com.avaje.ebean.*;

@Entity
public class Cultura extends Model {


	@Id
	public Long id;

	@Constraints.Required
	@ManyToOne
	public Hijos hijos;

	@Constraints.Required
	public String tPantalon;

	@Constraints.Required
	public String tFranelas;

	@Constraints.Required
	public String tZapatos;

	public String utiles;

	@Constraints.Required
	public String fecha;

	public String estado;


	public static Finder<Long, Cultura> buscar = new Finder<Long, Cultura>(Long.class, Cultura.class);


	public static Page<Cultura> pagina(int pagina, int tamanoPagina, String ordenarPor, String ordenar, String filtrar) {
		return buscar.where().ilike("hijos.cedulaH", "%" + filtrar + "%").orderBy(ordenarPor + " " + ordenar).fetch("hijos").findPagingList(tamanoPagina).getPage(pagina);
	}


	public static List<Cultura> listar(){
		List<Cultura> listar = Ebean.find(Cultura.class).fetch("hijos").findList();
		return listar;
	}


}