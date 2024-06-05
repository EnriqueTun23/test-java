package com.example.examen_task.controller;
import com.example.examen_task.model.Tarea;
import com.example.examen_task.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class SistemaController {

    /***
     * Controllador que da vida alas vistas
     *
     * **/
    @Autowired
    private TareaService tareaService;
    @GetMapping("/")
    public String welcome() {
        return "index";
    }

    @GetMapping("/tareas/nueva")
    public String nuevaTarea(Model model) {
        model.addAttribute("tarea", new Tarea());
        return "nueva-tarea";
    }

    @PostMapping("/tareas/guardar")
    public String registrarTarea(@RequestParam("nombre") String nombre,
                                 @RequestParam("descripcion") String descripcion,
                                 @RequestParam("fechaInicio") String fechaInicio, Model model) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // Crear un objeto para el formato para las fechas
        Tarea tarea = new Tarea();
        tarea.setNombre(nombre);
        tarea.setDescripcion(descripcion);
        try {
            tarea.setFechaInicio(formatter.parse(fechaInicio));

        } catch (ParseException e) {
            e.printStackTrace();
            return "error";
        }


        tareaService.insertarTarea(tarea);
        model.addAttribute("tareas", tareaService.obtenerTareasDadasDeAlta());
        return "listado-tareas";
    }

    @GetMapping("/tareas/lista")
    public String obtenerTareasDadasDeAlta(Model model) {
        model.addAttribute("tareas", tareaService.obtenerTareasDadasDeAlta());
        return "listado-tareas";
    }
}
