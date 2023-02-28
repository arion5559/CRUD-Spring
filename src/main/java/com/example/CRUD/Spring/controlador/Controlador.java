package com.example.CRUD.Spring.controlador;

import com.example.CRUD.Spring.Modelo.Proyecto;
import com.example.CRUD.Spring.Service.ProyectosDAOService;
import com.fasterxml.jackson.databind.JsonSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private ProyectosDAOService proyectosDAOService;

    // Listar todos los proyectos y enlazarlos con la tabla de la vista proyectos.html
    @GetMapping("/listarProyectos")
    @ResponseBody
    public List<Proyecto> listarProyectos(Model model) {
        // Obtener todos los proyectos
        List<Proyecto> proyectos = proyectosDAOService.listarProyectos();
        // Enviar los proyectos para que sean aceptados como iterable por una request de javascript
        model.addAttribute("proyectos", proyectos);
        // devuelve un iterable de proyectos
        return proyectos;
    }

    @PostMapping("/guardarProyecto/{nombre}/{descripcion}/{fechaInicio}/{fechaFin}/{estado}")
    public void guardarProyecto(@PathVariable("nombre") String nombre,
                                @PathVariable("descripcion") String descripcion, Model model) {
        Proyecto proyecto = new Proyecto(nombre, descripcion);
        proyectosDAOService.guardarProyecto(proyecto);
    }

    @DeleteMapping("/eliminarProyecto/{id}")
    public String eliminarProyecto(@PathVariable("id") int id, Model model) {
        proyectosDAOService.eliminarProyecto(id);
        return "redirect:/proyectos";
    }

    @GetMapping("/obtenerProyectoPorId/{id}")
    @ResponseBody
    public Optional<Proyecto> obtenerProyectoPorId(@PathVariable("id") int id, Model model) {
        return proyectosDAOService.obtenerProyectoPorId(id);
    }

    @PutMapping("/actualizarProyecto/{id}/{nombre}/{descripcion}")
    public String actualizarProyecto(@PathVariable("id") int id,
                                        @PathVariable("nombre") String nombre,
                                        @PathVariable("descripcion") String descripcion,
                                     Model model) {
        Proyecto proyecto = new Proyecto(nombre, descripcion);
        proyecto.setId(id);
        System.out.println(proyecto);
        System.out.println(id);
        proyectosDAOService.actualizarProyecto(id, proyecto);
        return "redirect:/proyectos";
    }
}
