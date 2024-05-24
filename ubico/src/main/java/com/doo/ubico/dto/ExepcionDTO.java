package com.doo.ubico.dto;

import com.doo.ubico.crosscutting.helpers.ObjectHelper;
import com.doo.ubico.crosscutting.helpers.TextHelper;
import com.doo.ubico.entity.AulaEntity;

import java.time.LocalDateTime;

public class ExepcionDTO {

    private int id;
    private String nombre;
    private MotivoNoDisponibilidadDTO motivo;
    private LocalDateTime fecha;
    private LocalDateTime HoraInicio;
    private LocalDateTime HoraFin;
    private AulaEntity aula;


    public ExepcionDTO(final int id, final String nombre, final MotivoNoDisponibilidadDTO motivo, final LocalDateTime fecha, final LocalDateTime HoraInicio, final LocalDateTime HoraFin, final AulaEntity aula) {
        setId(id);
        setMotivo(motivo);
        setFecha(fecha);
        setHoraInicio(HoraInicio);
        setHoraFin(HoraFin);
        setAula(aula);
    }

    public ExepcionDTO() {
        setId(id);
        setMotivo(MotivoNoDisponibilidadDTO.build());
        setFecha(LocalDateTime.now());
        setHoraInicio(LocalDateTime.now());
        setHoraFin(LocalDateTime.now());

    }

    public final AulaEntity getAula() {
        return aula;
    }

    public final LocalDateTime getFecha() {
        return fecha;
    }

    public final  LocalDateTime getHoraFin() {
        return HoraFin;
    }

    public final LocalDateTime getHoraInicio() {
        return HoraInicio;
    }

    public final int getId() {
        return id;
    }

    public final MotivoNoDisponibilidadDTO getMotivo() {
        return motivo;
    }

    private final  AulaEntity setAula( final AulaEntity aula) {
        this.aula = ObjectHelper.getObjectHelper().getDefault(aula, AulaEntity.build());
        return aula;
    }

    private final  LocalDateTime setFecha(LocalDateTime fecha) {
        this.fecha = LocalDateTime.now();
        return fecha;
    }

    private final  LocalDateTime setHoraFin(LocalDateTime horaFin) {
        HoraFin = TextHelper.getHoraDefecto();
        return HoraFin;
    }

    private final  LocalDateTime setHoraInicio(LocalDateTime horaInicio) {
        HoraInicio = TextHelper.getHoraDefecto();
        return HoraInicio;
    }

    private final  int setId(int id) {
        this.id = id;
        return id;
    }

    private final ExepcionDTO setMotivo(final MotivoNoDisponibilidadDTO motivo) {
        this.motivo = ObjectHelper.getObjectHelper().getDefault(motivo, MotivoNoDisponibilidadDTO.build());
        return this;
    }

}
