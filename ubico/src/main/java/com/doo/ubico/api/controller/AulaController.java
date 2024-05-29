package com.doo.ubico.api.controller;

import java.util.List;

import com.doo.ubico.api.response.aula.AulaResponse;
import com.doo.ubico.business.facade.RegistrarAulaFachada;
import com.doo.ubico.business.facade.concrete.RegistrarAulaFachadaImpl;
import com.doo.ubico.crosscutting.exception.UbicoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.doo.ubico.dto.AulaDTO;


@RestController
@RequestMapping("/api/v1/aulas")
public final class AulaController {

	@GetMapping("/dummy")
	public AulaDTO dummy() {
		return AulaDTO.build();
	}

	@GetMapping("/p")
/*	public ResponseEntity<AulaResponse> consultar() {
		var httpStatusCode = HttpStatus.ACCEPTED;
		var aulaResponse = new AulaResponse();

		try {
			var aulasDto = AulaDTO.build();
			var facade = new RegistrarAulaFachadaImpl();

			aulaResponse.setDatos(facade.ejecutar(aulasDto));
			aulaResponse.getMensajes().add("Aulas consultadas exitosamente");
		} catch (final UbicoException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			aulaResponse.getMensajes().add(exception.getMensajeUsuario());
			exception.printStackTrace();
		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar las aulas";
			aulaResponse.getMensajes().add(mensajeUsuario);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(aulaResponse, httpStatusCode);
	}*/

	@PostMapping
	public ResponseEntity<AulaResponse> crear(@RequestBody AulaDTO aula) {
		var httpStatusCode = HttpStatus.ACCEPTED;
		var aulaResponse = new AulaResponse();

		try {
			var facade = new RegistrarAulaFachadaImpl();
			facade.ejecutar(aula);
			aulaResponse.getMensajes().add("Aula creada exitosamente");
		} catch (final UbicoException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			aulaResponse.getMensajes().add(exception.getMensajeUsuario());
			exception.printStackTrace();
		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Se ha presentado un problema tratando de registrar la nueva aula";
			aulaResponse.getMensajes().add(mensajeUsuario);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(aulaResponse, httpStatusCode);
	}

/*	@DeleteMapping("/{id}")
	public ResponseEntity<AulaResponse> eliminar(@PathVariable int id) {
		var httpStatusCode = HttpStatus.ACCEPTED;
		var aulaResponse = new AulaResponse();

		try {
			var facade = new EliminarAulaFacade();
			facade.execute(id);
			aulaResponse.getMensajes().add("Aula eliminada exitosamente");
		} catch (final PCHException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			aulaResponse.getMensajes().add(exception.getMensajeUsuario());
			exception.printStackTrace();
		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la aula";
			aulaResponse.getMensajes().add(mensajeUsuario);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(aulaResponse, httpStatusCode);
	}*/

/*	@PutMapping("/{id}")
	public ResponseEntity<AulaResponse> modificar(@PathVariable int id, @RequestBody AulaDTO aulaDTO) {
		var httpStatusCode = HttpStatus.ACCEPTED;
		var aulaResponse = new AulaResponse();

		try {
			aulaDTO.setId(id);
			var facade = new ModificarAulaFacade();
			facade.execute(aulaDTO);
			aulaResponse.getMensajes().add("Aula modificada exitosamente");
		} catch (final PCHException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			aulaResponse.getMensajes().add(exception.getMensajeUsuario());
			exception.printStackTrace();
		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Se ha presentado un problema tratando de modificar la aula";
			aulaResponse.getMensajes().add(mensajeUsuario);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(aulaResponse, httpStatusCode);
	}*/
}

