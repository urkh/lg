package models;


import javax.persistence.*;
import java.util.*;

import play.db.ebean.*;
import play.data.validation.*;
import play.data.format.*;

@Entity
public class Cultura extends Model {


	@Id
	public Long id;

	@Constraints.Required
	@ManyToOne
	public HijosPersonas hPersonas;

	@Constraints.Required
	public String tPantalon;

	@Constraints.Required
	public String tFranelas;

	@Constraints.Required
	public String tZapatos;

	@Constraints.Required
	public String utiles;

	@Constraints.Required
	@Formats.DateTime(pattern="yyyy-mm-dd")
	public Date fecha;







}