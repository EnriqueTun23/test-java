package com.example.examen_task.controller;

import com.example.examen_task.model.Tarea;
import com.example.examen_task.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {
    private final TareaService tareaService;

    /***
     * Controllador que da vida a apis para su uso
     *
     * **/
    @Autowired
    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping("/altas")
    public ResponseEntity<List<Tarea>> obtenerTareasDadasDeAlta() {
        List<Tarea> tareas = tareaService.obtenerTareasDadasDeAlta();
        return  ResponseEntity.ok(tareas);
    }

    @PostMapping("/alta")
    public ResponseEntity<Tarea> insertarTarea(@RequestBody Tarea tarea) {
        tareaService.insertarTarea(tarea);
        return ResponseEntity.ok(tarea);
    }
}
