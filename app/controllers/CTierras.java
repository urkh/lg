package controllers;

import models.Tierras;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.formTierras;
import views.html.listaTierras;

public class CTierras extends Controller {


	public static Result listar(int pagina, String ordenarPor, String orden, String filtro) {
		return ok(listaTierras.render(Tierras.pagina(pagina, 10, ordenarPor, orden, filtro), ordenarPor, orden, filtro));
	}


	public static Result Inicio = redirect("/tierras/lista");

	public static Result index() {
		return Inicio;
	}


	public static Result nuevo() {
		Form<Tierras> formRTierras = form(Tierras.class);
		return ok(formTierras.render(formRTierras));
	}


		public static Result editar(Long id){
		Form<Tierras> formRTierras = form(Tierras.class).fill(Tierras.buscar.byId(id));
		return ok(formTierras.render(formRTierras));
	}

	public static Result actualizar(){
		Form<Tierras> formRTierras = form(Tierras.class).bindFromRequest();

		String ids = formRTierras.field("id").value();

		Long id = Long.parseLong(ids);
		formRTierras.get().update(id);
		flash("exito", "Solicitud actualizada con exito");
		return Inicio;
	}


	public static Result guardar(){
		
		Form<Tierras> formRTierras = form(Tierras.class).bindFromRequest();
		formRTierras.get().save();
		flash("exito", "Solicitud registrada exitosamente!");
		return Inicio;
		
	}
  
 
}