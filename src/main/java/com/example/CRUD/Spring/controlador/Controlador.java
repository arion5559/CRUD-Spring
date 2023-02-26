package com.example.CRUD.Spring.controlador;

import com.example.CRUD.Spring.Modelo.Proyecto;
import com.example.CRUD.Spring.Service.ProyectosDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private ProyectosDAOService proyectosDAOService;

    // Listar todos los proyectos y enlazarlos con la tabla de la vista proyectos.html
    @GetMapping("/listar")
    public String listarProyectos(Model model) {
        List<Proyecto> proyectos = proyectosDAOService.listarProyectos();
        model.addAttribute("proyectos", proyectos);
        return "proyectos";
    }
}
