package modelo;

import play.db.ebean.*;
import play.data.validation.*;

import javax.persistence.*;


@Entity
public class IgualdadSocial extends Model {

	@Id
	public Long id;

	@Constraints.Required
	@ManyToOne
	public Persona persona;


}