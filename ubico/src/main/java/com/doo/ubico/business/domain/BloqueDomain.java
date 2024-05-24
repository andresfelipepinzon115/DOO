package com.doo.ubico.business.domain;

import com.doo.ubico.crosscutting.helpers.TextHelper;

public class BloqueDomain {
	
	private int id;
    private String nombre;
    
    private BloqueDomain(final int id, final String nombre) {
    	setId(id);
        setNombre(nombre);
	}
	
	private BloqueDomain() {
    	setNombre(TextHelper.EMPTY);
    }
	
	public static final BloqueDomain crear(final int id, final String nombre) {
    	return new BloqueDomain(id,nombre);
    }
    
    
    public static final BloqueDomain crear() {
    	return new BloqueDomain();
    }
    
	
	private void setId(final int id) {
		this.id = id;
	}
	private void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
    
    


}
