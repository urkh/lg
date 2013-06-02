package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import com.avaje.ebean.Page;

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


	public static Finder<Long, Agua> buscar = new Finder<Long, Agua>(Long.class, Agua.class);


	public static Page<Agua> pagina(int pagina, int tamanoPagina, String ordenarPor, String ordenar, String filtrar) {
		return buscar.where().ilike("persona.cedula", "%" + filtrar + "%").orderBy(ordenarPor + " " + ordenar).fetch("persona").findPagingList(tamanoPagina).getPage(pagina);
	}

	

}
