package se.gritacademy.java25javawebservicesslutprojekt.model;

import jakarta.persistence.*;

@Entity
public class Tools {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}