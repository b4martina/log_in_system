package com.example.login_project.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name="USERS")
public class User {
 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)

 @Column(name="ID")
    private Long id;
 @Column(name = "USERNAME")
 private String username;

 @Column(name ="PASSWORD")
 private String password;

 @Column(name ="NAME")
    private String name;
@Column(name = "SURNAME")
    private String surname;

@Column(name="EMAIL")
 private String email;

@Column (name="ROLE")
 private String role;


 public User(){
 }

 public User(Long id, String username, String password,String name,String surname,String email,String role){
     this.id=id;
     this.username=username;
     this.password=password;
     this.name=name;
     this.surname=surname;
     this.email=email;
     this.role=role;
 }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
     this.name=name;
    }

    //order 2 , added for TMS, onetomany , generated list,added library
    //get set
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }





}
