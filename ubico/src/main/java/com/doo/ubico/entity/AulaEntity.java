package com.doo.ubico.entity;


import com.doo.ubico.crosscutting.helpers.NumericHelper;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;
import com.doo.ubico.crosscutting.helpers.TextHelper;

public final  class AulaEntity {

    private int id;
    private String nombre;
    private BloqueEntity bloque;

    private AulaEntity(final int id){
        setId(id);
        setNombre(TextHelper.EMPTY);
        setPais(BloqueEntity.build());
    }

    public AulaEntity(final int id, final String nombre, final BloqueEntity bloque) {
        setId(id);
        setNombre(nombre);
        setPais(AulaEntity.this.bloque);
    }

    public static final AulaEntity build(final int id){
        return new AulaEntity(id);
    }

    public static final AulaEntity build(final int id, final String nombre, final AulaEntity departamentoEntity){
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
}
