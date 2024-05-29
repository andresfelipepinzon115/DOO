package com.doo.ubico.api.controller;




import com.doo.ubico.api.response.aula.TipoAulaResponse;
import com.doo.ubico.crosscutting.exception.UbicoException;
import com.doo.ubico.dto.TipoAulaDTO;
import com.doo.ubico.business.assembler.dto.concrete.TipoAulaDTODomainAssembler;
import com.doo.ubico.business.facade.concrete.ConsultarTipoAulaFacade;
import com.doo.ubico.data.dao.factory.DAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/api/types")
public final class TipoAulaController {

    @Autowired
    private ConsultarTipoAulaFacade consultarTipoAulasFacade;

    @GetMapping("/dummy")
    public TipoAulaDTO dummy() {
        return TipoAulaDTO.build();
    }

    @GetMapping
    public ResponseEntity<TipoAulaResponse> consultar() {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var tipoAulaResponse = new TipoAulaResponse();

        try {
            var tipoAulaDto = TipoAulaDTO.build();
            tipoAulaResponse.setDatos(consultarTipoAulasFacade.execute(tipoAulaDto));
            tipoAulaResponse.getMensajes().add("Tipos de aula consultados exitosamente");
        } catch (final UbicoException exception) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            tipoAulaResponse.getMensajes().add(exception.getMensajeUsuario());
            exception.printStackTrace();
        } catch (final Exception exception) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar los tipos de aula";
            tipoAulaResponse.getMensajes().add(mensajeUsuario);
            exception.printStackTrace();
        }

        return new ResponseEntity<>(tipoAulaResponse, httpStatusCode);
    }
}
