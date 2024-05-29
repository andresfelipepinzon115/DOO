package com.doo.ubico.business.usecase.concrete;


import com.doo.ubico.business.domain.TipoAulaDomain;
import com.doo.ubico.business.usecase.UseCaseWithReturn;
import com.doo.ubico.crosscutting.exception.custom.BusinessUbicoException;
import com.doo.ubico.data.dao.factory.DAOFactory;
import com.doo.ubico.business.assembler.entity.concrete.TipoAulaEntityDomainAssembler;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;
import com.doo.ubico.crosscutting.exception.UbicoException;

import java.util.List;

public class ConsultarTipoAulasImpl implements UseCaseWithReturn<TipoAulaDomain, List<TipoAulaDomain>> {

    private DAOFactory factory;

    public ConsultarTipoAulasImpl(final DAOFactory factory) {
        if (ObjectHelper.getObjectHelper().isNull(factory)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar la consulta de los tipos de aula";
            var mensajeTecnico = "El DAOFactory de consultar los tipos de aula llegó nulo...";
            throw new BusinessUbicoException(mensajeTecnico, mensajeUsuario);
        }
        this.factory = factory;
    }

    @Override
    public List<TipoAulaDomain> execute(TipoAulaDomain data) {
        var tipoAulaEntityFilter = TipoAulaEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(data);
        var resultadosEntity = factory.getTipoAulaDAO().consultar(tipoAulaEntityFilter);
        return TipoAulaEntityDomainAssembler.obtenerInstancia().toDomainCollection(resultadosEntity);
    }
}
