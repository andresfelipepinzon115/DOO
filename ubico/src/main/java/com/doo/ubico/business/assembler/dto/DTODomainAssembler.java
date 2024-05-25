package com.doo.ubico.business.assembler.dto;

public interface DTODomainAssembler<D, T> {
	
	D ensamblarDominio(T dto);
	T ensamblarDTO(D dominio);
	

}
