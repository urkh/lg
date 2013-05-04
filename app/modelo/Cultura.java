package modelo;


import javax.persistence.*;


import play.db.ebean.*;
import play.data.validation.*;


@Entity
public class Cultura extends Model {


	@Id
	public Long id;

	@Constraints.Required
	@ManyToOne
	public Persona persona;

}