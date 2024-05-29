package com.doo.ubico.business.facade.concrete;


import com.doo.ubico.business.usecase.concrete.ConsultarBloquesImpl;
import com.doo.ubico.business.assembler.dto.concrete.BloqueDTODomainAssembler;
import com.doo.ubico.crosscutting.exception.custom.BusinessUbicoException;
import com.doo.ubico.data.dao.factory.DAOFactory;
import com.doo.ubico.dto.BloqueDTO;
import com.doo.ubico.crosscutting.exception.UbicoException;

import java.util.List;

public final class ConsultarBloquesFacade implements FacadeWithReturn<BloqueDTO, List<BloqueDTO>> {

    private DAOFactory daoFactory;

    public ConsultarBloquesFacade() {
        daoFactory = DAOFactory.getFactory();
    }

    @Override
    public List<BloqueDTO> execute(final BloqueDTO dto) {
        try {
            var useCase = new ConsultarBloquesImpl(daoFactory);
            var bloqueDomain = BloqueDTODomainAssembler.obtenerInstancia().ensamblarDominio(dto);
            var resultadosDomain = useCase.execute(bloqueDomain);
            return BloqueDTODomainAssembler.obtenerInstancia().toDTOCollection(resultadosDomain);
        } catch (final UbicoException excepcion) {
            throw excepcion;
        } catch (final Exception excepcion) {
            excepcion.printStackTrace();
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de los bloques";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar la información de los bloques";
            throw new BusinessUbicoException(mensajeTecnico, mensajeUsuario, excepcion);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
