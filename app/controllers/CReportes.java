package controllers;

import play.data.DynamicForm;
import play.data.Form;
import play.db.DB;
import play.mvc.Controller;
import play.mvc.Result;
import util.pdf.PDF;

import models.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import views.html.CA;
import views.html.CBC;
import views.html.CR;
import views.html.PE;
import views.html.reporteSalud;
import views.html.reporteEconomia;
import views.html.reporteAlimentacion;
import views.html.reporteVivienda;
import views.html.reporteIS;
import views.html.reporteCultura;
import views.html.reporteTierras;
import views.html.reportePT;
import views.html.reportePAG;

//@Security.Authenticated(Seguridad.class)
public class CReportes extends Controller {


	public static String getMes(){

		Calendar fecha = Calendar.getInstance();	
		int nMes = fecha.get(Calendar.MONTH);
		String mes = null;

		if(nMes==1){mes="Enero";} else 
		if(nMes==2){mes="Febrero";} else 
		if(nMes==3){mes="Marzo";} else 
		if(nMes==4){mes="Abril";} else 
		if(nMes==5){mes="Mayo";} else 
		if(nMes==6){mes="Junio";} else 
		if(nMes==7){mes="Julio";} else
		if(nMes==8){mes="Agosto";} else 
		if(nMes==9){mes="Septiembre";} else 
		if(nMes==10){mes="Octubre";} else
		if(nMes==11){mes="Noviembre";} else
		if(nMes==12){mes="Diciembre";}

		return mes;
	}
	
	
	public static Result reporteCR(Long id){

		Calendar fecha = Calendar.getInstance();			
		Form<Persona> formPersona = form(Persona.class).fill(Persona.buscar.byId(id));
		return PDF.ok(CR.render(formPersona, Integer.toString(fecha.get(Calendar.YEAR)), getMes(), Integer.toString(fecha.get(Calendar.DATE))));
		
	}


	public static Result reporteCBC(Long id){

		Calendar fecha = Calendar.getInstance();			
		Form<Persona> formPersona = form(Persona.class).fill(Persona.buscar.byId(id));
		return PDF.ok(CBC.render(formPersona, Integer.toString(fecha.get(Calendar.YEAR)), getMes(), Integer.toString(fecha.get(Calendar.DATE))));
		
	}


	public static Result reporteCA(){
		
		DynamicForm ca = form().bindFromRequest();
		Long id = Long.parseLong(ca.get("persona.id"));
		Form<Persona> formPersona = form(Persona.class).fill(Persona.buscar.byId(id));

		String norte = ca.get("norte");
		String sur = ca.get("sur");
		String este = ca.get("este");
		String oeste = ca.get("oeste");
		String fecha = ca.get("fecha");
		String fundo = ca.get("fundo");
		String tOcupacion = ca.get("tOcupacion");
		String hectareas = ca.get("hectareas");
		String rubro = ca.get("rubro");
		String vocero1 = ca.get("vocero1");
		String vocero2 = ca.get("vocero2");
		String tiempo = ca.get("tiempo");

		return PDF.ok(CA.render(formPersona, norte, sur, este, oeste, fecha, fundo, tOcupacion, hectareas, rubro, vocero1, vocero2, tiempo));
	}


	public static Result reportePE(){
		
		DynamicForm ca = form().bindFromRequest();
		Long id = Long.parseLong(ca.get("persona.id"));
		Form<Persona> formPersona = form(Persona.class).fill(Persona.buscar.byId(id));

		String fechaE = ca.get("fechaE");
		String fechaAs = ca.get("fechaAs");
		String espectaculo = ca.get("espectaculo");
		String vocero1 = ca.get("vocero1");
		String vocero2 = ca.get("vocero2");
		String vocero3 = ca.get("vocero3");
		String desde = ca.get("desde");
		String hasta = ca.get("hasta");
		String hora1 = ca.get("hora1");
		String hora2 = ca.get("hora2");
		String tipo = ca.get("tipo");

		return PDF.ok(PE.render(formPersona, fechaAs, fechaE, espectaculo, vocero1, vocero2, vocero3, desde, hasta, hora1, hora2, tipo));
	}
	

	public static Result reporteSalud(){
		return PDF.ok(reporteSalud.render(Salud.listar()));
	}

	public static Result reporteEconomia(){
		return PDF.ok(reporteEconomia.render(Economia.listar()));
	}

	public static Result reporteAlimentacion(){
		return PDF.ok(reporteAlimentacion.render(Alimentacion.listar()));
	}

	public static Result reporteVivienda(){
		return PDF.ok(reporteVivienda.render(Vivienda.listar()));
	}

	public static Result reporteIS(){
		return PDF.ok(reporteIS.render(IgualdadSocial.listar()));
	}


	public static Result reporteCultura(){
		return PDF.ok(reporteCultura.render(Cultura.listar()));
	}


	public static Result reporteTierras(){
		return PDF.ok(reporteTierras.render(Tierras.listar()));
	}

	public static Result reportePT(Long id){
		Form<Transporte> formTransporte = form(Transporte.class).fill(Transporte.buscar.byId(id));
		return PDF.ok(reportePT.render(formTransporte));
	}


	public static Result reportePAG(Long id){
		Form<Agua> formAgua = form(Agua.class).fill(Agua.buscar.byId(id));
		return PDF.ok(reportePAG.render(formAgua));
	}


}
