package com.swj.model;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Table(schema = "info", name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fk_question_id")
    private int fkQuestionId;
    @Column(name = "fk_member_id")
    private  int fkMemberId;
    @Temporal(TemporalType.TIMESTAMP)
    private GregorianCalendar created;
    @Column(name = "answer")
    private String answerText;
    private int likes;
    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "fk_question_id")
    private Question question;

    public Answer() {
    }

    public Answer(int id, int fkQuestionId, int fkMemberId, GregorianCalendar created, String answerText, int likes) {
        this.id = id;
        this.fkQuestionId = fkQuestionId;
        this.fkMemberId = fkMemberId;
        this.created = created;
        this.answerText = answerText;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkQuestionId() {
        return fkQuestionId;
    }

    public void setFkQuestionId(int fkQuestionId) {
        this.fkQuestionId = fkQuestionId;
    }

    public int getFkMemberId() {
        return fkMemberId;
    }

    public void setFkMemberId(int fkMemberId) {
        this.fkMemberId = fkMemberId;
    }

    public GregorianCalendar getCreated() {
        return created;
    }

    public void setCreated(GregorianCalendar created) {
        this.created = created;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
