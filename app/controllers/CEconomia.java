package controllers;

import models.Economia;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.formEconomia;
import views.html.listaEconomia;

public class CEconomia extends Controller {


	public static Result listar(int pagina, String ordenarPor, String orden, String filtro) {
		return ok(listaEconomia.render(Economia.pagina(pagina, 10, ordenarPor, orden, filtro), ordenarPor, orden, filtro));
	}


	public static Result Inicio = redirect(routes.CEconomia.nuevo());

	public static Result index() {
		return Inicio;
	}


	public static Result nuevo() {
		Form<Economia> formREconomia = form(Economia.class);
		return ok(formEconomia.render(formREconomia));
	}


	public static Result guardar(){
		
		Form<Economia> formREconomia = form(Economia.class).bindFromRequest();
		formREconomia.get().save();
		flash("exito", "Solicitud registrada exitosamente!");
		return Inicio;
		
	}


  
 
}