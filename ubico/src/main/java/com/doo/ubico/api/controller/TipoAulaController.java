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
@RequestMapping("/api/v1/types")
public final class TipoAulaController {

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
            var facade = new ConsultarTipoAulaFacade();
            tipoAulaResponse.setDatos(facade.execute(tipoAulaDto));
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

   /* @PostMapping
    public ResponseEntity<TipoAulaResponse> crear(@RequestBody TipoAulaDTO tipoAula) {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var tipoAulaResponse = new TipoAulaResponse();

        try {
            var facade = new RegistrarTipoAulaFacade();
            facade.execute(tipoAula);
            tipoAulaResponse.getMensajes().add("Tipo de aula creado exitosamente");
        } catch (final UbicoException exception) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            tipoAulaResponse.getMensajes().add(exception.getMensajeUsuario());
            exception.printStackTrace();
        } catch (final Exception exception) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar el nuevo tipo de aula";
            tipoAulaResponse.getMensajes().add(mensajeUsuario);
            exception.printStackTrace();
        }

        return new ResponseEntity<>(tipoAulaResponse, httpStatusCode);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoAulaResponse> eliminar(@PathVariable int id) {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var tipoAulaResponse = new TipoAulaResponse();

        try {
            var facade = new EliminarTipoAulaFacade();
            facade.execute(id);
            tipoAulaResponse.getMensajes().add("Tipo de aula eliminado exitosamente");
        } catch (final UbicoException exception) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            tipoAulaResponse.getMensajes().add(exception.getMensajeUsuario());
            exception.printStackTrace();
        } catch (final Exception exception) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "Se ha presentado un problema tratando de eliminar el tipo de aula";
            tipoAulaResponse.getMensajes().add(mensajeUsuario);
            exception.printStackTrace();
        }

        return new ResponseEntity<>(tipoAulaResponse, httpStatusCode);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoAulaResponse> modificar(@PathVariable int id, @RequestBody TipoAulaDTO tipoAulaDTO) {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var tipoAulaResponse = new TipoAulaResponse();

        try {
            tipoAulaDTO.setId(id);
            var facade = new ModificarTipoAulaFacade();
            facade.execute(tipoAulaDTO);
            tipoAulaResponse.getMensajes().add("Tipo de aula modificado exitosamente");
        } catch (final UbicoException exception) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            tipoAulaResponse.getMensajes().add(exception.getMensajeUsuario());
            exception.printStackTrace();
        } catch (final Exception exception) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "Se ha presentado un problema tratando de modificar el tipo de aula";
            tipoAulaResponse.getMensajes().add(mensajeUsuario);
            exception.printStackTrace();
        }

        return new ResponseEntity<>(tipoAulaResponse, httpStatusCode);
    }*/
}
