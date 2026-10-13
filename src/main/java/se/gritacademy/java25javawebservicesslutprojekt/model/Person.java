package se.gritacademy.java25javawebservicesslutprojekt.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    @Column(name = "name")
    private String name;
    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @ManyToMany
    @JoinTable(name = "person_tools",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "tools_id"))

    private Set<Tools> tools = new HashSet<>();

    public Person() {}

    public Person(Long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

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

}
