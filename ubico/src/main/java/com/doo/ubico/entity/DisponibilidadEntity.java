package com.doo.ubico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import  java.time.LocalTime;

@Data
@NoArgsConstructor

public  final class DisponibilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private AulaEntity aula;
    private  LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

}
