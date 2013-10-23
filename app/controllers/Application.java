package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	public static Result checkMutant() throws Exception {
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
			System.out.println(dnsArrays[i]);
		}
		String status = new MagnetoTool().checkMutant(dnsArrays) ? "Muntant" : "Human" ;
		result.put("name", name.toString());
		result.put("status", status);
		return ok(result);
	}

}
