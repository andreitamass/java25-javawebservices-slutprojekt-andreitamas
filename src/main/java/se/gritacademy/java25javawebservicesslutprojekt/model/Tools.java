package se.gritacademy.java25javawebservicesslutprojekt.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Tools {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    @Column(nullable = false)
    private String toolsName;
    @Column(nullable = false)
    private String toolsDescription;
    @ManyToMany(mappedBy = "tools") //Means a tool can be borrowed by different users
    private Set<Person> persons = new HashSet<>(); //List with users and whats tools they have

    public Tools() {}

    public Tools(Long id, String toolsName, String toolsDescription, Set<Person> persons) {
        this.id = id;
        this.toolsName = toolsName;
        this.toolsDescription = toolsDescription;
        this.persons = persons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToolsName() {
        return toolsName;
    }

    public void setToolsName(String toolsName) {
        this.toolsName = toolsName;
    }

    public String getToolsDescription() {
        return toolsDescription;
    }

    public void setToolsDescription(String toolsDescription) {
        this.toolsDescription = toolsDescription;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", toolsName='" + toolsName + '\'' +
                ", toolsDescription='" + toolsDescription + '\'' +
                '}';
    }

}