package com.doo.ubico.business.facade.concrete;

import com.doo.ubico.business.assembler.dto.concrete.AulaDTODomainAssembler;
import com.doo.ubico.business.usecase.concrete.RegistrarAulaImpl;
import com.doo.ubico.crosscutting.exception.UbicoException;
import com.doo.ubico.crosscutting.exception.custom.BusinessUbicoException;
import com.doo.ubico.data.dao.factory.DAOFactory;
import com.doo.ubico.data.dao.factory.enums.Factory;
import com.doo.ubico.dto.AulaDTO;

import java.util.List;

/*public final class ConsultarAulasFacade implements FacadeWithReturn<AulaDTO, List<AulaDTO>> {

    private DAOFactory daoFactory;

    public ConsultarAulasFacade() {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
    }

/*    @Override
    public List<AulaDTO> execute(final AulaDTO dto) {
        try {
            var useCase = new ConsultarAulas(daoFactory);
            var aulaDomain = AulaDTODomainAssembler.obtenerInstancia().ensamblarDominio(dto);
            var resultadosDomain = useCase.execute(aulaDomain);
            return AulaDTODomainAssembler.obtenerInstancia().ensamblarDominio(resultadosDomain);
        } catch (final UbicoException excepcion) {
            throw excepcion;
        } catch (final Exception excepcion) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de las aulas";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar la información de las aulas";
            throw new BusinessUbicoException(mensajeTecnico, mensajeUsuario, excepcion);
        } finally {
            daoFactory.cerrarConexion();
        }
    }*/


