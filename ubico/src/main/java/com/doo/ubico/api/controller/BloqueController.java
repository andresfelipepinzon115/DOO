package com.doo.ubico.api.controller;

import java.util.List;

import com.doo.ubico.crosscutting.exception.UbicoException;
import org.aspectj.apache.bcel.ExceptionConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.doo.ubico.dto.BloqueDTO;
import com.doo.ubico.business.facade.concrete.ConsultarBloquesFacade;
import com.doo.ubico.crosscutting.exception.custom.DataUbicoException;
import com.doo.ubico.api.response.BloqueResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/blocks")
public final class BloqueController {

	@GetMapping("/dummy")
	public BloqueDTO dummy() {
		return BloqueDTO.build();
	}

	@GetMapping
	public ResponseEntity<BloqueResponse> consultar() {
		var httpStatusCode = HttpStatus.ACCEPTED;
		var bloqueResponse = new BloqueResponse();

		try {
			var bloquesDto = BloqueDTO.build();
			var facade = new ConsultarBloquesFacade();
			bloqueResponse.setDatos(facade.execute(bloquesDto));
			bloqueResponse.getMensajes().add("Bloques consultados exitosamente");
		} catch (final UbicoException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			bloqueResponse.getMensajes().add(exception.getMensajeUsuario());
			exception.printStackTrace();
		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar los bloques";
			bloqueResponse.getMensajes().add(mensajeUsuario);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(bloqueResponse, httpStatusCode);
	}

	/*@PostMapping
	public ResponseEntity<BloqueResponse> crear(@RequestBody BloqueDTO bloque) {
		var httpStatusCode = HttpStatus.ACCEPTED;
		var bloqueResponse = new BloqueResponse();

		try {
			var facade = new RegistrarBloqueFacade();
			facade.execute(bloque);
			bloqueResponse.getMensajes().add("Bloque creado exitosamente");
		} catch (final UbicoException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			bloqueResponse.getMensajes().add(exception.getMensajeUsuario());
			exception.printStackTrace();
		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Se ha presentado un problema tratando de registrar el nuevo bloque";
			bloqueResponse.getMensajes().add(mensajeUsuario);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(bloqueResponse, httpStatusCode);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BloqueResponse> eliminar(@PathVariable int id) {
		var httpStatusCode = HttpStatus.ACCEPTED;
		var bloqueResponse = new BloqueResponse();

		try {
			var facade = new EliminarBloqueFacade();
			facade.execute(id);
			bloqueResponse.getMensajes().add("Bloque eliminado exitosamente");
		} catch (final UbicoException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			bloqueResponse.getMensajes().add(exception.getMensajeUsuario());
			exception.printStackTrace();
		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Se ha presentado un problema tratando de eliminar el bloque";
			bloqueResponse.getMensajes().add(mensajeUsuario);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(bloqueResponse, httpStatusCode);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BloqueResponse> modificar(@PathVariable int id, @RequestBody BloqueDTO bloqueDTO) {
		var httpStatusCode = HttpStatus.ACCEPTED;
		var bloqueResponse = new BloqueResponse();

		try {
			bloqueDTO.setId(id);
			var facade = new ModificarBloqueFacade();
			facade.execute(bloqueDTO);
			bloqueResponse.getMensajes().add("Bloque modificado exitosamente");
		} catch (final UbicoException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			bloqueResponse.getMensajes().add(exception.getMensajeUsuario());
			exception.printStackTrace();
		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Se ha presentado un problema tratando de modificar el bloque";
			bloqueResponse.getMensajes().add(mensajeUsuario);
			exception.printStackTrace();
		}

		return new ResponseEntity<>(bloqueResponse, httpStatusCode);*/
	}

