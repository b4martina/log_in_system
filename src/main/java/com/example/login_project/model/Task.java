//added later , order 1, using this to create a task management system

package com.example.login_project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="TASKS")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column (name = "STATUS")
private String status;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Task(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUsers() {
        return user;
    }

    public void setUsers(User users) {
        this.user = user;
    }


    //private User user;

}
