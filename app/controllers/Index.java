package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.index;


//@Security.Authenticated(Secured.class)
public class Index extends Controller {


	public static Result inicio() {
	//	return Inicio;
		return ok(index.render());
	}

}