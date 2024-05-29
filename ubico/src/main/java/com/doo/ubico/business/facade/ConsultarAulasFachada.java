package com.doo.ubico.business.facade;

import java.util.List;

import com.doo.ubico.dto.AulaDTO;

public interface ConsultarAulasFachada {
	
	List<AulaDTO> execute(AulaDTO aula);

}
