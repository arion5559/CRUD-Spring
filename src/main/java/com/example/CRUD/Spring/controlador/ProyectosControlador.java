package com.example.CRUD.Spring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.CRUD.Spring.DAO.ProyectosDAO;
import com.example.CRUD.Spring.Modelo.Proyecto;

import java.util.List;

@RestController
public class ProyectosControlador {
    @Autowired
    private ProyectosDAO proyectosDAO;

    @GetMapping("/listar")
    public List<Proyecto> listar(){
        return proyectosDAO.getProyectos();
    }

    @GetMapping("/buscar/{nombre}")
    public List<Proyecto> buscar(@PathVariable String nombre){
        return proyectosDAO.getProyectos(nombre);
    }

    @GetMapping("/eliminar")
    public void eliminar(){
        proyectosDAO.eliminarProyecto();
    }
}
