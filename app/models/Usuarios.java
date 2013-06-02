package models;

import play.db.ebean.*;
import play.data.validation.*;

import java.util.*;
import javax.persistence.*;
import com.avaje.ebean.*;

@Entity
public class Usuarios extends Model {
	
	@Id
	public Long id;
	
	@Constraints.Required
	@ManyToOne
	public Persona persona;

	@Constraints.Required
	public String usuario;

	@Constraints.Required
	public String contrasena;

	@Constraints.Required
	public String tipo;


	public static Finder<Long, Usuarios> buscar = new Finder<Long, Usuarios>(Long.class, Usuarios.class);


	public static Page<Usuarios> pagina(int pagina, int tamanoPagina, String ordenarPor, String ordenar, String filtrar) {
		return buscar.where().ilike("persona.cedula", "%" + filtrar + "%").orderBy(ordenarPor + " " + ordenar).fetch("persona").findPagingList(tamanoPagina).getPage(pagina);
	}


    public static Usuarios validar(String usuario, String contrasena) {
        return buscar.where().eq("usuario", usuario).eq("contrasena", contrasena).findUnique();
    }

}
