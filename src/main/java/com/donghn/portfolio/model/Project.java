package com.donghn.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

    private long id;
    private String title;
    private String cover;
    private String intro;

    public Project() {

    }

    public Project(String title, String cover, String intro) {
        this.title = title;
        this.cover = cover;
        this.intro = intro;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    @Column(name = "cover", nullable = false)
    public String getCover() {
        return cover;
    }

    @Column(name = "intro", nullable = false)
    public String getIntro() {
        return intro;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }


    @Override
    public String toString() {
        return "Project [id=" + id + ", title=" + title + "]";
    }
}
