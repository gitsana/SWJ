package com.swj.service;

import com.swj.dao.AnswerDAO;
import com.swj.model.Answer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/answer")
public class AnswerService {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Answer> getAllAnswers() {
        AnswerDAO answerDAO = new AnswerDAO();
        List<Answer> answers = answerDAO.readAllAnswers();
        return answers;
    }

    @GET
    @Path("/id/{theId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Answer getAnswerById(@PathParam("theId") int answerId) {
        AnswerDAO answerDAO = new AnswerDAO();
        Answer answer = answerDAO.readAnswerById(answerId);
        return answer;
    }

    @GET
    @Path("/question/{theQuestionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Answer> getAllAnswersByFkQuestionId(@PathParam("theQuestionId") int fkQuestionId) {
        AnswerDAO answerDAO = new AnswerDAO();
        List<Answer> answers = answerDAO.readAllAnswersByFkQuestionId(fkQuestionId);
        return answers;
    }
}
