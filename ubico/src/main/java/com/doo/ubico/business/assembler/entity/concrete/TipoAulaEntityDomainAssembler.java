package com.doo.ubico.business.assembler.entity.concrete;

import com.doo.ubico.business.assembler.entity.EntityDomainAssembler;
import com.doo.ubico.business.domain.TipoAulaDomain;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;
import com.doo.ubico.entity.TipoAulaEntity;

import java.util.List;

public abstract class TipoAulaEntityDomainAssembler implements EntityDomainAssembler<TipoAulaDomain, TipoAulaEntity>{

	public static final EntityDomainAssembler<TipoAulaDomain, TipoAulaEntity> instancia = new TipoAulaEntityDomainAssembler() {
		@Override
		public List<TipoAulaDomain> toDomainCollection(List<TipoAulaEntity> entities) {
			return List.of();
		}
	};
	private TipoAulaEntityDomainAssembler() {
		super();
	}
	
	public static final EntityDomainAssembler<TipoAulaDomain, TipoAulaEntity> obtenerInstancia(){
		return instancia;
	}
	
	@Override
	public final TipoAulaDomain ensamblarDominio(final TipoAulaEntity entidad) {
		var tipoAulaEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, TipoAulaEntity.build(0));
		return TipoAulaDomain.crear(tipoAulaEntityTmp.getId(),tipoAulaEntityTmp.getNombre());
	}

	@Override
	public final TipoAulaEntity ensamblarEntidad(final TipoAulaDomain dominio) {
		var tipoAulaDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, TipoAulaDomain.crear());
		return TipoAulaEntity.build(tipoAulaDomainTmp.getId(), tipoAulaDomainTmp.getNombre());
	}

}
