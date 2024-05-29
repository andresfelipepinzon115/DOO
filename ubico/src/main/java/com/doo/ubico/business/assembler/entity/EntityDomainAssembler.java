package com.doo.ubico.business.assembler.entity;

import java.util.List;

public interface EntityDomainAssembler<D, E> {
	
	D ensamblarDominio(E entidad);
	E ensamblarEntidad(D dominio);
    List<D> toDomainCollection(List<E> entities);

}
