package com.doo.ubico.business.assembler.dto;

import com.doo.ubico.business.domain.BloqueDomain;
import com.doo.ubico.business.domain.TipoAulaDomain;
import com.doo.ubico.dto.BloqueDTO;
import com.doo.ubico.dto.TipoAulaDTO;

import java.util.List;


import java.util.List;

public interface DTODomainAssembler<D, T> {

	D ensamblarDominio(T dto);

	T ensamblarDTO(D dominio);

	List<D> toDomainCollection(List<T> dtoCollection);

	List<T> toDTOCollection(List<D> domainCollection);
}

