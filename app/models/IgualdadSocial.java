package models;

import play.db.ebean.*;
import play.data.validation.*;
import play.data.format.*;

import java.util.*;

import javax.persistence.*;


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

}