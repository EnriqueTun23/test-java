package com.example.examen_task.model;
import lombok.Data;

import java.util.Date;

@Data
public class Tarea {
    private Long id;
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
}
