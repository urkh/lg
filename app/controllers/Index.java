package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.login;

public class Index extends Controller {


	public static Result index() {
	//	return Inicio;
		return ok(login.render());
	}


 
}