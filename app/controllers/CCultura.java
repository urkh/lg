package controllers;

import models.Cultura;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.formCultura;
import views.html.listaCultura;

public class CCultura extends Controller {



	public static Result listar(int pagina, String ordenarPor, String orden, String filtro) {
		return ok(listaCultura.render(Cultura.pagina(pagina, 10, ordenarPor, orden, filtro), ordenarPor, orden, filtro));
	}


	public static Result Inicio = redirect(routes.CCultura.nuevo());

	public static Result index() {
		return Inicio;
	}


	public static Result nuevo() {
		Form<Cultura> formRCultura = form(Cultura.class);
		return ok(formCultura.render(formRCultura));
	}


	public static Result guardar(){
		
		Form<Cultura> formRCultura = form(Cultura.class).bindFromRequest();
		formRCultura.get().save();
		flash("exito", "Solicitud registrada exitosamente!");
		return Inicio;
		
	}


  
 
}