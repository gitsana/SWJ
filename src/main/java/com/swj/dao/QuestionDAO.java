package com.swj.dao;

import com.swj.model.Question;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class QuestionDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SWJ");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Question> readAllQuestions() {
        Query query = entityManager.createQuery("select q from Question q");
        return (List<Question>) query.getResultList();
    }

    public Question readQuestionById(int questionId) {
        Question question = entityManager.find(Question.class, questionId);
        return question;
    }

    // test
    public static void main(String[] args) {

        QuestionDAO questionDAO = new QuestionDAO();

        // read all questions
        System.out.println("--------- Read all questions below -----------");
        List<Question> allQuestions = questionDAO.readAllQuestions();
        for(Question question : allQuestions) {
            System.out.println(question.getQuestionText());
        }

        // read a question by id
        System.out.println("\n--------- Read a question by ID -----------");
        Question question = questionDAO.readQuestionById(5);
        System.out.println(question.getQuestionText());

    }

}
