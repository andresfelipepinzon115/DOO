package com.doo.ubico.business.assembler.dto.concrete;

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

public class AulaDTODomainAssembler implements DTODomainAssembler <AulaDomain, AulaDTO> {


	private static final DTODomainAssembler<BloqueDomain, BloqueDTO> BloqueAssembler = BloqueDTODomainAssembler.obtenerInstancia();
	private static final DTODomainAssembler<TipoAulaDomain, TipoAulaDTO> TipoAulaAssembler = TipoAulaDTODomainAssembler.obtenerInstancia();

	private AulaDTODomainAssembler() {
		super();
	}

	//Instancia
	private static final DTODomainAssembler<AulaDomain, AulaDTO> instancia = new AulaDTODomainAssembler();

	public static final DTODomainAssembler<AulaDomain, AulaDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public AulaDomain ensamblarDominio(AulaDTO dto) {
		var AulaDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new AulaDTO());
		var TipoAulaDomain = TipoAulaAssembler.ensamblarDominio(AulaDtoTmp.getTipoAula());
		var BloqueDomain = BloqueAssembler.ensamblarDominio(AulaDtoTmp.getBloque());

		return AulaDomain.crear(AulaDtoTmp.getId(), AulaDtoTmp.getNombre(), AulaDtoTmp.getCapacidad(), BloqueDomain, TipoAulaDomain);

	}

	@Override
	public AulaDTO ensamblarDTO(AulaDomain dominio) {
		var AulaDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, AulaDomain.crear());
		var TipoAulaDTO = TipoAulaAssembler.ensamblarDTO(AulaDomainTmp.getTipoAula());
		var BloqueDTO = BloqueAssembler.ensamblarDTO(AulaDomainTmp.getBloque());
		return AulaDTO.build().setId(AulaDomainTmp.getId()).setNombre(AulaDomainTmp.getNombre()).setCapacidad(AulaDomainTmp.getCapacidad()).setTipoAula(TipoAulaDTO).setBloque(BloqueDTO);
	}
}



