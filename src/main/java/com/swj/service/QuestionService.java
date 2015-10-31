package com.swj.service;

import com.swj.dao.QuestionDAO;
import com.swj.model.Question;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
}
