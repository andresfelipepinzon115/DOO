package com.doo.ubico.business.usecase.concrete;

import java.util.List;

import com.doo.ubico.business.assembler.entity.concrete.AulaEntityDomainAssembler;
import com.doo.ubico.business.domain.AulaDomain;
import com.doo.ubico.business.usecase.RegistrarAula;
import com.doo.ubico.crosscutting.exception.custom.BusinessUbicoException;
import com.doo.ubico.data.dao.factory.DAOFactory;
import com.doo.ubico.entity.AulaEntity;
import com.doo.ubico.entity.BloqueEntity;

public class RegistrarAulaImpl implements RegistrarAula {
	
	private final DAOFactory factory;
	
	public RegistrarAulaImpl(final DAOFactory factory) {
		this.factory = factory;
		
	}

	@Override
	public final void ejecutar(final AulaDomain aula) {
		//1. Validar que los datos sean validos a nivel de tipo de dato, longitud, obligatoriedad
		// formato, rango
		//2. No debe exisitir un Aula con el mismo nombre para el mismo Bloque
		validarNoExistenciaAula(aula.getNombre(), aula.getBloque().getId());
		//3. Guardar la informacion de la nueva Aula
		var aulaEntity = AulaEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(aula);
		factory.getAulaDAO().crear(aulaEntity);
	}
	
	private void validarNoExistenciaAula(String nombreAula, int idBloque) {
		var bloqueEntity = BloqueEntity.build(idBloque);
		var aulaEntity = AulaEntity.build(0, nombreAula, 0, null, bloqueEntity);
		
		final List<AulaEntity> resultados = factory.getAulaDAO().consultar(aulaEntity);
		if(!resultados.isEmpty()) {
			var mensajeUsuario = "Ya existe una Aula con el nombre \"{1}\" asociada al Bloque";
			throw new BusinessUbicoException(mensajeUsuario);
		}
	}

}
