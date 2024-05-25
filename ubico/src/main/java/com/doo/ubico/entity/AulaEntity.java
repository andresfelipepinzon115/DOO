package com.doo.ubico.entity;


import com.doo.ubico.crosscutting.helpers.NumericHelper;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;
import com.doo.ubico.crosscutting.helpers.TextHelper;

public final  class AulaEntity {

    private int id;
    private String nombre;
    private BloqueEntity bloque;
    private TipoAulaEntity tipoAula;
    private int capacidad;

    private AulaEntity(final int id){
        setId(id);
        setNombre(TextHelper.EMPTY);
        setBloque(BloqueEntity.build());
    }

    public AulaEntity(final int id, final String nombre, final BloqueEntity bloque, final TipoAulaEntity tipoAula, final int capacidad){ {
        setId(id);
        setNombre(nombre);
        setBloque(AulaEntity.this.bloque);
        setTipoAula(tipoAula);
    }
    }

    public static final AulaEntity build(final int id, final String nombre, final String bloque, final String tipoAula , final int capacidad){
        return new AulaEntity(id, nombre, BloqueEntity.build(bloque), TipoAulaEntity.build(tipoAula), capacidad);
    }

    public static final AulaEntity build(final int id){
        return new AulaEntity(id);
    }

    public static final AulaEntity build(final int id, final String nombre, final AulaEntity bloque, final TipoAulaEntity tipoAula){
        return new AulaEntity(id);
    }

    public static final AulaEntity build(){
        return new AulaEntity(NumericHelper.ZERO);
    }

    public final int getId() {
        return id;
    }

    public final String getNombre() {
        return nombre;
    }

    public final BloqueEntity getBloque() {
        return bloque;
    }

    public final TipoAulaEntity getTipoAula() {
        return tipoAula;
    }

    public  final int getCapacidad() {
        return capacidad;
    }

    public  final AulaEntity setCapacidad(int capacidad) {
        this.capacidad = NumericHelper.ZERO;
        return this;
    }

    private final void setId(final int id) {
        this.id = id;
    }

    private final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    private final BloqueEntity setBloque(final BloqueEntity bloque) {
        this.bloque = ObjectHelper.getObjectHelper().getDefault(AulaEntity.this.bloque, BloqueEntity.build(NumericHelper.ZERO));
        return bloque;
    }

    private final void setTipoAula(final TipoAulaEntity tipoAula) {
        this.tipoAula = ObjectHelper.getObjectHelper().getDefault(AulaEntity.this.tipoAula, TipoAulaEntity.build(NumericHelper.ZERO));
    }
}

