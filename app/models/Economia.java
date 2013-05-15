package models;

import play.db.ebean.*;
import play.data.validation.*;
import play.data.format.*;

import java.util.*;
import javax.persistence.*;
import com.avaje.ebean.Page;

@Entity
public class Economia extends Model {
	
	@Id
	public Long id;
	
	@Constraints.Required
	@ManyToOne
	public Persona persona;

	@Constraints.Required
	public String fecha;

	//empleo, curso o postulacion
	@Constraints.Required
	public String solicitud;

	//empleo o curso a realizar
	public String tipoSol;

	public String empresa;

	public String turno;

	public String dias;


	public static Finder<Long, Economia> buscar = new Finder<Long, Economia>(Long.class, Economia.class);


	public static Page<Economia> pagina(int pagina, int tamanoPagina, String ordenarPor, String ordenar, String filtrar) {
		return buscar.where().ilike("persona.cedula", "%" + filtrar + "%").orderBy(ordenarPor + " " + ordenar).fetch("persona").findPagingList(tamanoPagina).getPage(pagina);
	}




	
	

}
