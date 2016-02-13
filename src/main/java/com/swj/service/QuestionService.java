package com.swj.service;

import com.swj.dao.QuestionDAO;
import com.swj.model.Question;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/question")
public class QuestionService {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Question> getAllQuestions() {
        QuestionDAO questionDAO = new QuestionDAO();
        List<Question> questions = questionDAO.readAllQuestions();
        return questions;
    }

    @GET
    @Path("/id/{theId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Question getQuestionById(@PathParam("theId") int questionId) {
        QuestionDAO questionDAO = new QuestionDAO();
        Question question = questionDAO.readQuestionById(questionId);
        return question;
    }

    @POST
    @Path("/createQuestion")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewQuestion(Question newQuestion) {
        QuestionDAO questionDAO = new QuestionDAO();
        questionDAO.createQuestion(newQuestion);
        return Response.status(Response.Status.OK).entity(newQuestion).build();
    }
}
