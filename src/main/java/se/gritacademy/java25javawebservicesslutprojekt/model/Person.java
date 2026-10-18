package se.gritacademy.java25javawebservicesslutprojekt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity //Class that JPA handles
public class Person {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Creates ID for user, creates user
    private Long id = 0L;
    @NotBlank(message = "Must fill name")
    @Column(name = "name", nullable = false) //Creates column in database with row name
    private String name;
    @NotBlank(message = "Must fill phonenumber")
    @Column(unique = true, nullable = false) //User must write a phone number, two users cannot use the same number
    private String phoneNumber;

    @ManyToMany //User can have many tools, users can share tools
    @JoinTable(name = "person_tools", //adds table to tools table, Person chooses what data gets saved in this table
            joinColumns = @JoinColumn(name = "person_id"), //Person tabel
            inverseJoinColumns = @JoinColumn(name = "tools_id")) //Tools table

    //New hashset = to create a empty "inventory" for user
    private Set<Tools> tools = new HashSet<>(); //List for users that can loan different tools at the same time

    public Person() {} //Constructor

    //Creates person with attributes
    public Person(Long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //Getters and setters to get information and set information about user
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Tools> getTools() {
        return tools;
    }

    public void setTools(Set<Tools> tools) {
        this.tools = tools;
    }

    @Override
    public String toString() { //Shows object in text
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phoneNumber + '\'' +
                '}';
    }

}
