
package se.gritacademy.java25javawebservicesslutprojekt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Tools {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @NotBlank(message = "Must fill tool name")
    @Column(nullable = false)
    private String toolsName;

    @NotBlank(message = "Must fill description")
    @Column(nullable = false)
    private String toolsDescription;

    //Removed mappedBy = tools to keep ManyToMany relation one-way, due to problem causing infinte list
    //because of relation from person to tools, and tools to person making an infinte loop

    public Tools() {}

    public Tools(Long id, String toolsName, String toolsDescription) {
        this.id = id;
        this.toolsName = toolsName;
        this.toolsDescription = toolsDescription;
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

    @Override
    public String toString() {
        return "Tools{" +
                "id=" + id +
                ", toolsName='" + toolsName + '\'' +
                ", toolsDescription='" + toolsDescription + '\'' +
                '}';
    }
}
