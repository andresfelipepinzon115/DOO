package com.doo.ubico.business.usecase.concrete;

import com.doo.ubico.business.domain.TipoAulaDomain;
import com.doo.ubico.business.usecase.RegistrarTipoAula;
import com.doo.ubico.data.dao.factory.DAOFactory;

import co.edu.uco.tiendachepito.business.assembler.entity.concrete.CiudadEntityDomainAssembler;

public final class RegistrarTipoAulaImpl implements RegistrarTipoAula{
	
	private final DAOFactory factory;
	
	public RegistrarCiudadImpl(final DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public void ejecutar(final TipoAulaDomain tipoAula) {
		////1. Validar que los datos necesarios sean validos 
		//2. No debe exisitir una ciudad con el mismo nombre para el mismo departamento
		
		//3. Guardar la informacion del nuevo tipo de Aula
		var tipoAulaEntity = TipoAulaEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(tipoAula);
		factory.gettipoAulaDAO().crear(tipoAulaEntity);

		
	}

		
	}

}
