package com.doo.ubico.business.assembler.dto.concrete;

import com.doo.ubico.business.assembler.dto.AssemblerDTO;
import com.doo.ubico.dto.AulaDTO;
import com.doo.ubico.dto.BloqueDTO;
import com.doo.ubico.dto.TipoAulaDTO;
import com.doo.ubico.business.assembler.dto.DTODomainAssembler;
import com.doo.ubico.business.domain.AulaDomain;
import com.doo.ubico.business.domain.BloqueDomain;
import com.doo.ubico.business.domain.TipoAulaDomain;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;
import com.doo.ubico.entity.AulaEntity;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;



import com.doo.ubico.dto.AulaDTO;
import com.doo.ubico.dto.BloqueDTO;
import com.doo.ubico.dto.TipoAulaDTO;
import com.doo.ubico.business.assembler.dto.DTODomainAssembler;
import com.doo.ubico.business.assembler.dto.AssemblerDTO;
import com.doo.ubico.business.domain.AulaDomain;
import com.doo.ubico.business.domain.BloqueDomain;
import com.doo.ubico.business.domain.TipoAulaDomain;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;

import java.util.ArrayList;
import java.util.List;
import static com.doo.ubico.crosscutting.helpers.ObjectHelper.getObjectHelper;

public final class AulaDTODomainAssembler implements DTODomainAssembler<AulaDomain, AulaDTO> {

	private static final DTODomainAssembler<BloqueDomain, BloqueDTO> BloqueAssembler = BloqueDTODomainAssembler.obtenerInstancia();
	private static final AssemblerDTO<TipoAulaDomain, TipoAulaDTO> TipoAulaAssembler = TipoAulaDTODomainAssembler.getInstance();

	private AulaDTODomainAssembler() {
		super();
	}

	// Instancia
	private static final DTODomainAssembler<AulaDomain, AulaDTO> instancia = new AulaDTODomainAssembler();

	public static DTODomainAssembler<AulaDomain, AulaDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public AulaDomain ensamblarDominio(AulaDTO dto) {
		var AulaDtoTmp = getObjectHelper().getDefault(dto, new AulaDTO());
		var TipoAulaDomain = TipoAulaAssembler.toDomain(AulaDtoTmp.getTipoAula());
		var BloqueDomain = BloqueAssembler.ensamblarDominio(AulaDtoTmp.getBloque());

		return AulaDomain.crear(AulaDtoTmp.getId(), AulaDtoTmp.getNombre(), AulaDtoTmp.getCapacidad(), BloqueDomain, TipoAulaDomain);
	}

	@Override
	public AulaDTO ensamblarDTO(AulaDomain dominio) {
		var AulaDomainTmp = getObjectHelper().getDefault(dominio, AulaDomain.crear());
		var TipoAulaDTO = TipoAulaAssembler.toDTO(AulaDomainTmp.getTipoAula());
		var BloqueDTO = BloqueAssembler.ensamblarDTO(AulaDomainTmp.getBloque());
		return AulaDTO.build()
				.setId(AulaDomainTmp.getId())
				.setNombre(AulaDomainTmp.getNombre())
				.setCapacidad(AulaDomainTmp.getCapacidad())
				.setTipoAula(TipoAulaDTO)
				.setBloque(BloqueDTO);
	}

	@Override
	public List<AulaDTO> toDTOCollection(List<AulaDomain> domainCollection) {
		var domainCollectionTmp = getObjectHelper().getDefault(domainCollection, new ArrayList<AulaDomain>());
		return domainCollectionTmp.stream().map(this::ensamblarDTO).toList();
	}

	@Override
	public List<AulaDomain> toDomainCollection(List<AulaDTO> dtoCollection) {
		var dtoCollectionTmp = getObjectHelper().getDefault(dtoCollection, new ArrayList<AulaDTO>());
		var resultadosDomain = new ArrayList<AulaDomain>();

		for (AulaDTO aulaDto : dtoCollectionTmp) {
			var aulaDomainTmp = ensamblarDominio(aulaDto);
			resultadosDomain.add(aulaDomainTmp);
		}
		return resultadosDomain;
	}
}



