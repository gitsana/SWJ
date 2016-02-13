package com.swj.model;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(schema = "info", name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fk_member_id")
    private int fkMemberId;
    @Temporal(TemporalType.TIMESTAMP)
    private GregorianCalendar created;
    @Column(name = "question")
    private String questionText;
    private int views;
    @Column(name = "url_slug")
    private String urlSlug;
    private int likes;
    @ManyToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn(name = "fk_member_id")
    private User user;

    public Question(int fkMemberId, GregorianCalendar created, String questionText, int views, String urlSlug, int likes, User user) {
        this.fkMemberId = fkMemberId;
        this.created = created;
        this.questionText = questionText;
        this.views = views;
        this.urlSlug = urlSlug;
        this.likes = likes;
        this.user = user;
    }

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getUrlSlug() {
        return urlSlug;
    }

    public void setUrlSlug(String urlSlug) {
        this.urlSlug = urlSlug;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
