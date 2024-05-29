package com.doo.ubico.business.usecase.concrete;

import com.doo.ubico.business.assembler.entity.concrete.AulaEntityDomainAssembler;
import com.doo.ubico.business.domain.AulaDomain;
import com.doo.ubico.crosscutting.exception.UbicoException;
import com.doo.ubico.crosscutting.exception.custom.CrosscuttingUbicoException;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;
import com.doo.ubico.data.dao.factory.DAOFactory;

import java.util.List;

/*public class ConsultarAulas implements UseCaseWithReturn<AulaDomain, List<AulaDomain>> {
    private DAOFactory factory;

    public ConsultarAulas(final DAOFactory factory) {
        if (ObjectHelper.getObjectHelper().isNull(factory)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar la consulta de las aulas";
            var mensajeTecnico = "El DAOFactory de consultar las aulas llegó nulo...";
            throw new CrosscuttingUbicoException(mensajeTecnico, mensajeUsuario);
        }
        this.factory = factory;
    }

    @Override
    public List<AulaDomain> execute(AulaDomain data) {
        var aulaEntityFilter = AulaEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(data);
        var resultadosEntity = factory.getAulaDAO().consultar(aulaEntityFilter);
        return AulaEntityDomainAssembler.obtenerInstancia().toDomainCollection(resultadosEntity);
    } */


