package models;

import play.data.format.*;
import play.data.validation.*;
import play.db.ebean.*;

import java.util.*;

import javax.persistence.*;

import com.avaje.ebean.Page;

@Entity
public class Salud extends Model {

	@Id
	public Long id;

	@Constraints.Required
	@ManyToOne
	public Persona persona;

	@Constraints.Required
	public String fecha;

	public String enfermedad;

	public String medicamentos;

	public String tipoOp;

	public String tiempoEnf;


	public static Finder<Long, Salud> buscar = new Finder<Long, Salud>(Long.class, Salud.class);


	public static Page<Salud> pagina(int pagina, int tamanoPagina, String ordenarPor, String ordenar, String filtrar) {
		return buscar.where().ilike("persona.cedula", "%" + filtrar + "%").orderBy(ordenarPor + " " + ordenar).fetch("persona").findPagingList(tamanoPagina).getPage(pagina);
	}




}