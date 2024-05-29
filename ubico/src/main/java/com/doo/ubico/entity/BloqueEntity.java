package com.doo.ubico.entity;
import com.doo.ubico.crosscutting.helpers.NumericHelper;
import com.doo.ubico.crosscutting.helpers.TextHelper;


public final  class BloqueEntity {
    private  int id;
    private String nombre;

    public BloqueEntity(final int id, final String nombre) {
        setId(id);
        setNombre(TextHelper.EMPTY);

    }

    private BloqueEntity(final int id) {
        this.id = id;
        setNombre(TextHelper.EMPTY);
    }



    public static final BloqueEntity build(final int id){
        return new BloqueEntity(id);
    }

    public static final BloqueEntity build(final int id, final String nombre){
        return new BloqueEntity(id,nombre);
    }

    public static final BloqueEntity build(String nombre){
        return new BloqueEntity(NumericHelper.ZERO,nombre);
    }

    protected static final BloqueEntity build(){
        return new BloqueEntity(NumericHelper.ZERO);
    }

    public final int getId() {
        return id;
    }

    public final String getNombre() {
        return nombre;
    }

    private final void setId(final int id) {
        this.id = id;
    }

    private final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

}
