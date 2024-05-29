package com.doo.ubico.business.assembler.dto.concrete;

import com.doo.ubico.dto.BloqueDTO;
import com.doo.ubico.business.assembler.dto.DTODomainAssembler;
import com.doo.ubico.business.domain.BloqueDomain;

import java.util.ArrayList;
import java.util.List;

import static com.doo.ubico.crosscutting.helpers.ObjectHelper.getObjectHelper;


public final class BloqueDTODomainAssembler implements DTODomainAssembler<BloqueDomain, BloqueDTO>{
	
	private static final  DTODomainAssembler<BloqueDomain, BloqueDTO> instancia = new BloqueDTODomainAssembler();

	private BloqueDTODomainAssembler() {
		super();
	}
	
	public static final  DTODomainAssembler<BloqueDomain, BloqueDTO> obtenerInstancia(){
		return instancia;
	}
	
	@Override
	public final BloqueDomain ensamblarDominio(final BloqueDTO dto) {
		var bloqueDtoTmp = getObjectHelper().getDefault(dto, new BloqueDTO());
		return BloqueDomain.crear(bloqueDtoTmp.getId(), bloqueDtoTmp.getNombre());
	}

	@Override
	public final BloqueDTO ensamblarDTO(final BloqueDomain dominio) {
		var bloqueDomainTmp = getObjectHelper().getDefault(dominio, BloqueDomain.crear());
		return BloqueDTO.build().setId(bloqueDomainTmp.getId()).setNombre(bloqueDomainTmp.getNombre());
	}
	@Override
	public List<BloqueDTO> toDTOCollection(List<BloqueDomain> domainCollection) {
		var domainCollectionTmp = getObjectHelper().getDefault(domainCollection, new ArrayList<BloqueDomain>());
		return domainCollectionTmp.stream().map(this::ensamblarDTO).toList();
	}


}


