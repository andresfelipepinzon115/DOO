package com.doo.ubico.business.facade.concrete;



import com.doo.ubico.business.usecase.concrete.ConsultarTipoAulasImpl;
import com.doo.ubico.business.assembler.dto.concrete.TipoAulaDTODomainAssembler;
import com.doo.ubico.crosscutting.exception.custom.BusinessUbicoException;
import com.doo.ubico.data.dao.factory.DAOFactory;
import com.doo.ubico.dto.TipoAulaDTO;

import com.doo.ubico.crosscutting.exception.UbicoException;

import java.util.List;

public final class ConsultarTipoAulaFacade implements FacadeWithReturn<TipoAulaDTO, List<TipoAulaDTO>> {

    private DAOFactory daoFactory;

    public ConsultarTipoAulaFacade() {
        daoFactory = DAOFactory.getFactory();
    }

    @Override
    public List<TipoAulaDTO> execute(final TipoAulaDTO dto) {
        try {
            var useCase = new ConsultarTipoAulasImpl(daoFactory);
            var tipoAulaDomain = TipoAulaDTODomainAssembler.getInstance().toDomain(dto);
            var resultadosDomain = useCase.execute(tipoAulaDomain);
            return TipoAulaDTODomainAssembler.getInstance().toDTOCollection(resultadosDomain);
        } catch (final UbicoException excepcion) {
            throw excepcion;
        } catch (final Exception excepcion) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de los tipos de aula";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar la información de los tipos de aula";
            throw new BusinessUbicoException(mensajeTecnico, mensajeUsuario, excepcion);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
