package com.doo.ubico.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Table(name = "aulas")

public final  class AulaEntity {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String capacidad;
    private TipoAulaEntity tipoAula;
    @ManyToOne
    private BloqueEntity bloque;
}
