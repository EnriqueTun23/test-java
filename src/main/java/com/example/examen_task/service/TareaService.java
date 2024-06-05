package com.example.examen_task.service;

import com.example.examen_task.mapper.TareaMapper;
import com.example.examen_task.model.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    private final TareaMapper tareaMapper;

    @Autowired
    public TareaService(TareaMapper tareaMapper) {
        this.tareaMapper = tareaMapper;
    }

    public List<Tarea> obtenerTareasDadasDeAlta() {
        return tareaMapper.obtenerTareas();
    }

    public void insertarTarea(Tarea tarea) {
        tareaMapper.insertarTarea(tarea);
    }
}
