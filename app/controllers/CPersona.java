package controllers;

import models.Persona;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.libs.Json;

import views.html.formCA;
import views.html.formPE;
import views.html.formPersona;
import views.html.listaPersona;

import java.util.HashMap;
import java.util.Map;

public class CPersona extends Controller {


	public static Result Inicio = redirect("/ciudadanos/lista");

	public static Result index() {
		return Inicio;
	}

	public static Result listar(int pagina, String ordenarPor, String orden, String filtro) {
		return ok(listaPersona.render(Persona.pagina(pagina, 10, ordenarPor, orden, filtro), ordenarPor, orden, filtro));
	}


	public static Result editar(Long id){
		Form<Persona> formRPersona = form(Persona.class).fill(Persona.buscar.byId(id));
		return ok(formPersona.render(formRPersona));
	}

	public static Result actualizar(){
		Form<Persona> formRPersona = form(Persona.class).bindFromRequest();

		String ids = formRPersona.field("id").value();

		Long id = Long.parseLong(ids);
		formRPersona.get().update(id);
		flash("exito", "Solicitud actualizada con exito");
		return Inicio;
	}



	public static Result ca() {
		return ok(formCA.render());
	}

	public static Result pe() {
		return ok(formPE.render());
	}

	public static Result nuevo() {
		Form<Persona> formRPersona = form(Persona.class);
		return ok(formPersona.render(formRPersona));
	}


	public static Result guardar(){
		
		Form<Persona> formRPersona = form(Persona.class).bindFromRequest();

		formRPersona.get().save();
		flash("exito", "El Ciudadano  " + formRPersona.get().nombre + "   " + formRPersona.get().apellido +"  fue registrado exitosamente!");
		return Inicio;
		
	}



	public static Result buscarCedula() {

		
		Map<String, String[]> queryParameters = request().queryString();
		String cedula = queryParameters.get("busqueda")[0];
	
		if(Persona.buscarP(Integer.parseInt(cedula))==null){
			
			return badRequest("Cedula no encontrada");
			
		}else{
			
			Form<Persona> formPersona = form(Persona.class).fill(Persona.buscar.where().eq("cedula", cedula).findUnique());
			Map<String, String> d = new HashMap<String, String>();
			
			d.put("persona.id", formPersona.get().id.toString());
			d.put("cedula", formPersona.get().cedula.toString());
			d.put("nombre", formPersona.get().nombre);
			d.put("apellido", formPersona.get().apellido);

			return ok(Json.toJson(d));
	
		}
	}
}