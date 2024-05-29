package com.doo.ubico.business.assembler.entity;

public interface EntityDomainAssembler<D, E> {
	
	D ensamblarDominio(E entidad);
	E ensamblarEntidad(D dominio);
	
}
