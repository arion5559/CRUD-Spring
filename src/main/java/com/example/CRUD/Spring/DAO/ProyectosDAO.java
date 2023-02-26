package com.example.CRUD.Spring.DAO;

import com.example.CRUD.Spring.Modelo.Proyecto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProyectosDAO extends CrudRepository<Proyecto, Integer> {
}
