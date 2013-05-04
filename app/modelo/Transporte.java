package modelo;

import play.data.format.*;
import play.data.validation.*;
import play.db.ebean.*;

import javax.persistence.*;

import java.util.*;


@Entity
public class Transporte extends Model {

	@Id
	public Long id;


	@Constraints.Required
	@ManyToOne
	public HijosPersonas hPersonas;

	@Constraints.Required
	public Double monto;

	@Constraints.Required
	@Formats.DateTime(pattern="yyyy-mm-dd")
	public Date fechaPago;

	@Constraints.Required
	public Date mesCorrespondiente;



}