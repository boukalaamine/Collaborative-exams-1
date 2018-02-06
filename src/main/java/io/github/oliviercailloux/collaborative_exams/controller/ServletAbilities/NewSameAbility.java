package io.github.oliviercailloux.collaborative_exams.controller.ServletAbilities;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import io.github.oliviercailloux.collaborative_exams.model.entity.data;
import io.github.oliviercailloux.collaborative_exams.model.relation.SameAbility;



@Path("NewSameAbility")
public class NewSameAbility {
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public int newSameAbility(MultivaluedMap<String, String> form) throws Exception {
		
		int idQuestion1  = Integer.valueOf(form.getFirst("idQuestion1"));
		int idQuestion2  = Integer.valueOf(form.getFirst("idQuestion2"));
		
		int idAuthor  = Integer.valueOf(form.getFirst("idAuthor"));

		SameAbility s = new SameAbility(data.getQuestionByID(idQuestion1),data.getQuestionByID(idQuestion2),data.getAuthorByID(idAuthor));
		
		data.addSameAbility(s);	
		return data.sameAbilityCount;
		
	}

}