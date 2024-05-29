package com.doo.ubico.business.facade.concrete;

import com.doo.ubico.business.assembler.dto.concrete.AulaDTODomainAssembler;
import com.doo.ubico.business.facade.RegistrarAulaFachada;
import com.doo.ubico.business.usecase.RegistrarAula;
import com.doo.ubico.business.usecase.concrete.RegistrarAulaImpl;
import com.doo.ubico.crosscutting.exception.UbicoException;
import com.doo.ubico.crosscutting.exception.custom.BusinessUbicoException;
import com.doo.ubico.data.dao.factory.DAOFactory;
import com.doo.ubico.data.dao.factory.enums.Factory;
import com.doo.ubico.dto.AulaDTO;

public class RegistrarAulaFachadaImpl implements RegistrarAulaFachada{
	
	private  final DAOFactory factory;
	
	public RegistrarAulaFachadaImpl() {
		factory= DAOFactory.getFactory();
	}
	
	

	@Override
	public final void ejecutar(final AulaDTO aula) {
		try {
			factory .iniciarTransaccion();
			
			var aulaDomain = AulaDTODomainAssembler.obtenerInstancia().ensamblarDominio(aula);
			
			final RegistrarAula useCase = new RegistrarAulaImpl(factory);
			useCase.ejecutar(aulaDomain);
			
			factory.confirmarTransaccion();
		}catch (UbicoException excepcion) {
			factory.cancelarTransaccion();
			throw excepcion;
			
		}catch(final Exception excepcion) {
			factory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema tratando de registrar la nueva informacion de la ciudad";
			var mensajeTecnico = "Se ha presentado un problema tratando de registar la informacion de la nueva ciudad en el metodo Ejecutar de la clase RegistrarCiudadFachadaImpl, porfavor siga la traza completa del problema...";
			
			throw new BusinessUbicoException(mensajeTecnico,mensajeUsuario);
		}finally {
			factory.cerrarConexion();
		}
		
	}

}
