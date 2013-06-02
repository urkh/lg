package controllers;

import models.Alimentacion;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.formAlimentacion;
import views.html.listaAlimentacion;


//@Security.Authenticated(Secured.class)
public class CAlimentacion extends Controller {


	public static Result listar(int pagina, String ordenarPor, String orden, String filtro) {
		return ok(listaAlimentacion.render(Alimentacion.pagina(pagina, 10, ordenarPor, orden, filtro), ordenarPor, orden, filtro));
	}


	public static Result Inicio = redirect("/alimentacion/lista");

	public static Result index() {
		return Inicio;
	}


	public static Result nuevo() {
		Form<Alimentacion> formRAlimentacion = form(Alimentacion.class);
		return ok(formAlimentacion.render(formRAlimentacion));
	}


	public static Result guardar(){
		
		Form<Alimentacion> formRAlimentacion = form(Alimentacion.class).bindFromRequest();
		formRAlimentacion.get().save();
		flash("exito", "Denuncia registrada exitosamente!");
		return Inicio;
		
	}
  
 
}