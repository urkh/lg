package models;

import play.data.format.*;
import play.data.validation.*;
import play.db.ebean.*;

import javax.persistence.*;

import java.util.*;
import com.avaje.ebean.Page;


@Entity
public class Transporte extends Model {

	@Id
	public Long id;


	@Constraints.Required
	@ManyToOne
	public Hijos hijos;

	@Constraints.Required
	public Double monto;

	@Constraints.Required
	public String fechaPago;

	@Constraints.Required
	public String mesCorrespondiente;

	public static Finder<Long, Transporte> buscar = new Finder<Long, Transporte>(Long.class, Transporte.class);


	public static Page<Transporte> pagina(int pagina, int tamanoPagina, String ordenarPor, String ordenar, String filtrar) {
		return buscar.where().ilike("hijos.cedulaH", "%" + filtrar + "%").orderBy(ordenarPor + " " + ordenar).fetch("hijos").findPagingList(tamanoPagina).getPage(pagina);
	}



}