package com.example.CRUD.Spring.Modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Table(name = "proyectos")
@Entity
@ToString
@EqualsAndHashCode
public class Proyecto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    public Proyecto(String nombre, String descripcion) {
    }

    public Proyecto(int id, String nombre, String descripcion) {
    }

    public Proyecto() {
    }
}
