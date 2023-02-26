package com.example.CRUD.Spring.Service;

import com.example.CRUD.Spring.DAO.ProyectosDAO;
import com.example.CRUD.Spring.Modelo.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProyectoDAOServiceImp implements ProyectosDAOService {

    @Autowired
    private ProyectosDAO proyectosDAO;

    @Override
    public List<Proyecto> listarProyectos() {
        return (List<Proyecto>) proyectosDAO.findAll();
    }

    @Override
    public Optional<Proyecto> obtenerProyectoPorId(int id) {
        return Optional.empty();
    }

    @Override
    public int guardarProyecto(Proyecto proyecto) {
        return 0;
    }

    @Override
    public void eliminarProyecto(int id) {

    }
}
