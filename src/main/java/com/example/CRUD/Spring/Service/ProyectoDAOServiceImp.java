package com.example.CRUD.Spring.Service;

import com.example.CRUD.Spring.DAO.ProyectosDAO;
import com.example.CRUD.Spring.Modelo.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
        int res = 0;
        Proyecto proyectoDB = proyectosDAO.save(proyecto);
        if (!proyectoDB.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public int actualizarProyecto(int id, Proyecto proyecto) {
        int res = 0;
        Proyecto proyectoDB = proyectosDAO.save(proyecto);
        if (!proyectoDB.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void eliminarProyecto(int id) {
        proyectosDAO.deleteById(id);
    }
}
