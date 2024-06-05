package com.example.examen_task.mapper;

import com.example.examen_task.model.Tarea;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TareaMapper {

    List<Tarea> obtenerTareas();
    void insertarTarea(Tarea tarea);
}