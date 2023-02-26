package com.example.CRUD.Spring.DAO;

import com.example.CRUD.Spring.Modelo.Proyecto;
import com.example.CRUD.Spring.DAO.ProyectosDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class ProyectosDAOImp implements ProyectosDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Proyecto> getProyectos() {
        String query = "FROM Proyecto";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Proyecto> getProyectos(String nombre) {
        // donde el nombre del proyecto contenga el nombre que le pasamos
        String query = "FROM Proyecto WHERE nombre LIKE %:nombre%";
        return entityManager.createQuery(query).setParameter("nombre", nombre).getResultList();
    }

    @Override
    public Proyecto getProyecto(int id) {
        return entityManager.find(Proyecto.class, id);
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        entityManager.persist(proyecto);
    }

    @Override
    public void saveProyecto(String nombre, String descripcion, Date fechaInicio, Date fechaFin, String subido) {
        entityManager.persist(new Proyecto(nombre, descripcion, fechaInicio, fechaFin, subido));
    }

    @Override
    public void deleteProyecto(int id) {
        entityManager.remove(getProyecto(id));
    }

    @Override
    public void updateProyecto(Proyecto proyecto) {
        Proyecto proyecto1 = getProyecto(proyecto.getId());
        proyecto1.setNombre(proyecto.getNombre());
        proyecto1.setDescripcion(proyecto.getDescripcion());
        proyecto1.setFechaInicio(proyecto.getFechaInicio());
        proyecto1.setFechaFin(proyecto.getFechaFin());
        proyecto1.setSubido(proyecto.getSubido());
        entityManager.flush();
    }

    @Override
    public void updateProyecto(int id, String nombre, String descripcion, Date fechaInicio, Date fechaFin, String subido) {
        Proyecto proyecto = getProyecto(id);
        proyecto.setNombre(nombre);
        proyecto.setDescripcion(descripcion);
        proyecto.setFechaInicio(fechaInicio);
        proyecto.setFechaFin(fechaFin);
        proyecto.setSubido(subido);
        entityManager.flush();
    }

    @Override
    public Proyecto searchProyectos(String nombre) {
        return entityManager.find(Proyecto.class, nombre);
    }

    @Override
    public void eliminarProyecto() {
        String query = "DELETE FROM Proyecto";
        entityManager.createQuery(query).executeUpdate();
    }
}
