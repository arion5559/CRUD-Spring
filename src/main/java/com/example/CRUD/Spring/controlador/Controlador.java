package com.example.CRUD.Spring.controlador;

import com.example.CRUD.Spring.Modelo.Proyecto;
import com.example.CRUD.Spring.Service.ProyectosDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @GetMapping("/guardarProyecto")
    public String guardarProyecto(@Validated Proyecto proyecto, Model model) {
        proyectosDAOService.guardarProyecto(proyecto);
        return "redirect:/proyectos";
    }

    @GetMapping("/eliminarProyecto")
    public String eliminarProyecto(int id, Model model) {
        proyectosDAOService.eliminarProyecto(id);
        return "redirect:/proyectos";
    }

    @GetMapping("/obtenerProyectoPorId/{id}")
    @ResponseBody
    public Proyecto obtenerProyectoPorId(@PathVariable int id, Model model) {
        return proyectosDAOService.obtenerProyectoPorId(id).get();
    }

    @GetMapping("/actualizarProyecto/{id}")
    public String actualizarProyecto(@PathVariable int id, @Validated Proyecto proyecto, Model model) {
        proyecto.setId(id);
        proyectosDAOService.guardarProyecto(proyecto);
        return "redirect:/proyectos";
    }
}
