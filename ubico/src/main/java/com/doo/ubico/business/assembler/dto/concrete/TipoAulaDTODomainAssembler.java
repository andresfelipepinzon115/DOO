package com.doo.ubico.business.assembler.dto.concrete;


import com.doo.ubico.dto.TipoAulaDTO;
import com.doo.ubico.business.assembler.dto.AssemblerDTO;
import com.doo.ubico.business.domain.TipoAulaDomain;

import java.util.ArrayList;
import java.util.List;
import static com.doo.ubico.crosscutting.helpers.ObjectHelper.getObjectHelper;


import com.doo.ubico.dto.TipoAulaDTO;
import com.doo.ubico.business.assembler.dto.AssemblerDTO;
import com.doo.ubico.business.domain.TipoAulaDomain;
import java.util.ArrayList;
import java.util.List;
import static com.doo.ubico.crosscutting.helpers.ObjectHelper.getObjectHelper;

public final class TipoAulaDTODomainAssembler implements AssemblerDTO<TipoAulaDomain, TipoAulaDTO> {

    private static final AssemblerDTO<TipoAulaDomain, TipoAulaDTO> instance = new TipoAulaDTODomainAssembler();

    private TipoAulaDTODomainAssembler() {
        super();
    }

    public static AssemblerDTO<TipoAulaDomain, TipoAulaDTO> getInstance() {
        return instance;
    }

    @Override
    public TipoAulaDomain toDomain(TipoAulaDTO data) {
        var tipoAulaDtoTmp = getObjectHelper().getDefault(data, TipoAulaDTO.build());
        return TipoAulaDomain.crear(tipoAulaDtoTmp.getId(), tipoAulaDtoTmp.getNombre());
    }

    @Override
    public TipoAulaDTO toDTO(TipoAulaDomain domain) {
        var tipoAulaDomainTmp = getObjectHelper().getDefault(domain, TipoAulaDomain.crear());
        return new TipoAulaDTO(tipoAulaDomainTmp.getId(), tipoAulaDomainTmp.getNombre());
    }

    @Override
    public List<TipoAulaDomain> toDomainCollection(List<TipoAulaDTO> dtoCollection) {
        var dtoCollectionTmp = getObjectHelper().getDefault(dtoCollection, new ArrayList<TipoAulaDTO>());
        var resultadosDomain = new ArrayList<TipoAulaDomain>();

        for (TipoAulaDTO tipoAulaDto : dtoCollectionTmp) {
            var tipoAulaDomainTmp = toDomain(tipoAulaDto);
            resultadosDomain.add(tipoAulaDomainTmp);
        }
        return resultadosDomain;
    }

    @Override
    public List<TipoAulaDTO> toDTOCollection(List<TipoAulaDomain> domainCollection) {
        var domainCollectionTmp = getObjectHelper().getDefault(domainCollection, new ArrayList<TipoAulaDomain>());
        return domainCollectionTmp.stream().map(this::toDTO).toList();
    }
}

