package controllers;

import models.IgualdadSocial;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.formIS;
import views.html.listaIS;

public class CIS extends Controller {


	public static Result listar(int pagina, String ordenarPor, String orden, String filtro) {
		return ok(listaIS.render(IgualdadSocial.pagina(pagina, 10, ordenarPor, orden, filtro), ordenarPor, orden, filtro));
	}


	public static Result Inicio = redirect("/is/lista");

	public static Result index() {
		return Inicio;
	}


	public static Result editar(Long id){
		Form<IgualdadSocial> formRIS = form(IgualdadSocial.class).fill(IgualdadSocial.buscar.byId(id));
		return ok(formIS.render(formRIS));
	}

	public static Result actualizar(){
		Form<IgualdadSocial> formRIS = form(IgualdadSocial.class).bindFromRequest();

		String ids = formRIS.field("id").value();

		Long id = Long.parseLong(ids);
		formRIS.get().update(id);
		flash("exito", "Solicitud actualizada con exito");
		return Inicio;
	}


	public static Result nuevo() {
		Form<IgualdadSocial> formRIS = form(IgualdadSocial.class);
		return ok(formIS.render(formRIS));
	}


	public static Result guardar(){
		
		Form<IgualdadSocial> formRIS = form(IgualdadSocial.class).bindFromRequest();
		formRIS.get().save();
		flash("exito", "Pago registrado exitosamente!");
		return Inicio;
		
	}
  
 
}