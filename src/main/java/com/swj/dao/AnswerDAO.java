package com.swj.dao;

import com.swj.model.Answer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AnswerDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SWJ");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Answer> readAllAnswers() {
        Query query = entityManager.createQuery("select a from Answer a");
        return (List<Answer>) query.getResultList();
    }

    public Answer readAnswerById(int answerId) {
        Answer answer = entityManager.find(Answer.class, answerId);
        return answer;
    }

    public List<Answer> readAllAnswersByFkQuestionId(int fkQuestionId) {
        Query query = entityManager.createQuery("select a from Answer a where a.fkQuestionId=:qid");
        query.setParameter("qid", fkQuestionId);
        return (List<Answer>) query.getResultList();
    }

    // test
    public static void main(String[] args) {
        AnswerDAO answerDAO = new AnswerDAO();
        List<Answer> allAnswers = answerDAO.readAllAnswers();
        Answer oneAnswer = answerDAO.readAnswerById(3);

        System.out.println("----------- All answers --------------");
        for(Answer answer : allAnswers) {
            System.out.println(answer.getAnswerText());
        }

        System.out.println("\n----------- One answer --------------");
        System.out.println(oneAnswer.getAnswerText());

        System.out.println("\n----------- All answers by fkQuestionId --------------");
        List<Answer> allAnswersForQuestion = answerDAO.readAllAnswersByFkQuestionId(6);
        for(Answer answer : allAnswersForQuestion) {
            System.out.println(answer.getAnswerText());
        }
    }
}
