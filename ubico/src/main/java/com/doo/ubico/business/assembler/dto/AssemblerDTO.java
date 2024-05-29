package com.doo.ubico.business.assembler.dto;


import com.doo.ubico.business.assembler.Assembler;

import java.util.List;

public interface AssemblerDTO<D,K> extends Assembler<D, K> {
	
	K toDTO(D domain);
	List<K> toDTOCollection(List<D> domainCollection);
	
}
