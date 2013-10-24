package controllers;

import java.util.ArrayList;
import java.util.Iterator;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import play.libs.Json;
import play.mvc.*;
import utils.MagnetoTool;
import views.html.*;

public class Application extends Controller {

	public static Result index() {

		return ok(index.render("Magneto REST API"));
	}

	public static Result checkMutant() {
		JsonNode json = request().body().asJson();
		ObjectNode result = Json.newObject();
		Object name = json.findPath("name").getTextValue();
		Iterator<JsonNode> elements= null;
		ArrayList<String> listStrs = new ArrayList<String>();
		String[] dnsArrays = null;
		if(json.findPath("dna").isArray()){
			elements =json.findPath("dna").getElements();
		}
		while(elements.hasNext()){
			listStrs.add(elements.next().getTextValue().toString());
		}	
		dnsArrays = new String[listStrs.size()];
		for(int i=0;i<listStrs.size();i++){
			dnsArrays[i] = listStrs.get(i).toString();
		}
		String status = null;
		try{
			status = new MagnetoTool().checkMutant(dnsArrays) ? "Muntant" : "Human" ;
		}catch(Exception e){
			status = "Try again, no results";
		}
		result.put("name", name.toString());
		result.put("status", status);
		return ok(result);
	}
	
	
	public static Result checkPreFlight() {
	    response().setHeader("Access-Control-Allow-Origin", "*");       // Need to add the correct domain in here!!
	    response().setHeader("Access-Control-Allow-Methods", "POST");   // Only allow POST
	    response().setHeader("Access-Control-Max-Age", "300");          // Cache response for 5 minutes
	    response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");         // Ensure this header is also allowed!  
	    return ok();
	}

}
