package com.doo.ubico.business.usecase.concrete;


import com.doo.ubico.business.domain.BloqueDomain;
import com.doo.ubico.business.usecase.UseCaseWithReturn;
import com.doo.ubico.crosscutting.exception.custom.BusinessUbicoException;
import com.doo.ubico.data.dao.factory.DAOFactory;
import com.doo.ubico.business.assembler.entity.concrete.BloqueEntityDomainAssembler;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;
import com.doo.ubico.crosscutting.exception.UbicoException;

import java.util.List;

public class ConsultarBloquesImpl implements UseCaseWithReturn<BloqueDomain, List<BloqueDomain>> {

    private DAOFactory factory;

    public ConsultarBloquesImpl(final DAOFactory factory) {
        if (ObjectHelper.getObjectHelper().isNull(factory)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar la consulta de los bloques";
            var mensajeTecnico = "El DAOFactory de consultar los bloques llegó nulo...";
            throw new BusinessUbicoException(mensajeTecnico, mensajeUsuario);
        }
        this.factory = factory;
    }

    @Override
    public List<BloqueDomain> execute(BloqueDomain data) {
        var bloqueEntityFilter = BloqueEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(data);
        var resultadosEntity = factory.getBloqueDAO().consultar(bloqueEntityFilter);
        return BloqueEntityDomainAssembler.obtenerInstancia().toDomainCollection(resultadosEntity);
    }
}
