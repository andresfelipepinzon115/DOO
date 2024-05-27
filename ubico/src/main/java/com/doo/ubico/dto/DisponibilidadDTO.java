package com.doo.ubico.dto;

import java.time.LocalDateTime;

import com.doo.ubico.crosscutting.helpers.ObjectHelper;

public class DisponibilidadDTO {

	private int id;
	private String nombre;
	private LocalDateTime fecha;
	private LocalDateTime HoraInicio;
	private LocalDateTime HoraFin;
	private AulaDTO aula;

	public DisponibilidadDTO(final int id, final String nombre, final LocalDateTime fecha,
			final LocalDateTime HoraInicio, final LocalDateTime HoraFin, final AulaDTO aula) {
		setId(id);
		setFecha(fecha);
		setHoraInicio(HoraInicio);
		setHoraFin(HoraFin);
		setAula(aula);
	}

	public DisponibilidadDTO() {
		setId(id);
		setFecha(LocalDateTime.now());
		setHoraInicio(LocalDateTime.now());
		setHoraFin(LocalDateTime.now());

	}

	public final AulaDTO getAula() {
		return aula;
	}

	public final LocalDateTime getFecha() {
		return fecha;
	}

	public final LocalDateTime getHoraFin() {
		return HoraFin;
	}

	public final LocalDateTime getHoraInicio() {
		return HoraInicio;
	}

	public final int getId() {
		return id;
	}

	private final DisponibilidadDTO setAula(final AulaDTO aula) {
		this.aula = ObjectHelper.getObjectHelper().getDefault(aula, AulaDTO.build());
		return this;
	}

	private final LocalDateTime setFecha(LocalDateTime fecha) {
		this.fecha = LocalDateTime.now();
		return fecha;
	}

	private final LocalDateTime setHoraFin(LocalDateTime horaFin) {
//		HoraFin = TextHelper.getHoraDefecto();
//		return HoraFin;
		return null;
	}

	private final LocalDateTime setHoraInicio(LocalDateTime horaInicio) {
//		HoraInicio = TextHelper.getHoraDefecto();
//		return HoraInicio;
		return null;
	}

	private final int setId(int id) {
		this.id = id;
		return id;
	}

}
