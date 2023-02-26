package com.example.CRUD.Spring.Service;

import com.example.CRUD.Spring.Modelo.Proyecto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ProyectosDAOService {
    public List<Proyecto> listarProyectos();
    public Optional<Proyecto> obtenerProyectoPorId(int id);
    public int guardarProyecto(Proyecto proyecto);
    public void eliminarProyecto(int id);
}
