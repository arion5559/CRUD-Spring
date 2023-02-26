package com.example.CRUD.Spring.DAO;

import com.example.CRUD.Spring.Modelo.Proyecto;

import java.util.Date;
import java.util.List;

public interface ProyectosDAO {
    List<Proyecto> getProyectos();

    List<Proyecto> getProyectos(String nombre);

    Proyecto getProyecto(int id);

    void saveProyecto(Proyecto proyecto);

    void saveProyecto(String nombre, String descripcion, Date fechaInicio, Date fechaFin, String subido);

    void deleteProyecto(int id);

    void updateProyecto(Proyecto proyecto);

    void updateProyecto(int id, String nombre, String descripcion, Date fechaInicio, Date fechaFin, String subido);

    Proyecto searchProyectos(String nombre);

    void eliminarProyecto();
}
