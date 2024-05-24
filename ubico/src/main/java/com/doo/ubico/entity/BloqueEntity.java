package com.doo.ubico.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "bloque")

public final  class BloqueEntity {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int id;
    private String nombre;
}
