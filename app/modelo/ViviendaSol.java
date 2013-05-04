package modelo;


import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.*;



@Entity
public class ViviendaSol extends Model {


	@Id
	public Long id;

	@Constraints.Required
	public String nombre;


}