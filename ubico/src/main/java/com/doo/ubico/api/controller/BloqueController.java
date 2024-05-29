package com.doo.ubico.api.controller;

import java.util.List;

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

import com.doo.ubico.business.facade.ConsultarBloquesFachada;
import com.doo.ubico.business.facade.concrete.ConsultarBloquesFachadaImpl;
import com.doo.ubico.crosscutting.exception.UbicoException;
import com.doo.ubico.crosscutting.helpers.NumericHelper;
import com.doo.ubico.dto.AulaDTO;
import com.doo.ubico.dto.BloqueDTO;
import com.doo.ubico.api.response.bloque.BloqueResponse;


@RestController
@RequestMapping("/api/V1/Bloques")
public class BloqueController {
	
	
	@GetMapping("/dummy")
	public BloqueDTO getDummy() {
		return BloqueDTO.build();
	}
	
	@GetMapping
	public ResponseEntity<BloqueResponse> consultar(@RequestParam(required = false, defaultValue = "0") String id, @RequestParam(required = false, defaultValue = "") String nombre){
		BloqueResponse bloqueResponse = BloqueResponse.build();
		HttpStatus httpStatusResponse = HttpStatus.OK;
		
		try {
			final var BloqueDTOFilter = BloqueDTO.build().setId(NumericHelper.convertToInt(id)).setNombre(nombre);
			final ConsultarBloquesFachada fachada = new ConsultarBloquesFachadaImpl();
			bloqueResponse.setDatos(fachada.execute(BloqueDTOFilter));
			bloqueResponse.getMensajes().add("Bloques consultados exitosamente");
			
		}catch (final UbicoException exception) {
			exception.printStackTrace();
			bloqueResponse.getMensajes().add(exception.getMensajeUsuario());
			httpStatusResponse = HttpStatus.BAD_REQUEST;
		}catch (final Exception exception) {
			exception.printStackTrace();
			bloqueResponse.getMensajes().add("Se a presentado un error inesperado tratando de consultar la informacion de los Bloques");
			httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(bloqueResponse, httpStatusResponse);
	}

	
	@PostMapping
	public ResponseEntity<BloqueResponse> crear(@RequestBody BloqueDTO bloque){
		BloqueResponse bloqueResponse = BloqueResponse.build();
		HttpStatus httpStatusResponse = HttpStatus.OK;
		
		try {
			//Llamar la fachada de registro de bloque
			bloqueResponse.getDatos().add(bloque);
			bloqueResponse.getMensajes().add("Bloque registrado exitosamente");
			
		}catch (final UbicoException exception) {
			exception.printStackTrace();
			bloqueResponse.getMensajes().add(exception.getMensajeUsuario());
			httpStatusResponse = HttpStatus.BAD_REQUEST;
		}catch (final Exception exception) {
			exception.printStackTrace();
			bloqueResponse.getMensajes().add("Se a presentado un error inesperado tratando de consultar la informacion de los Bloques");
			httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(bloqueResponse, httpStatusResponse);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<BloqueResponse> eliminar(@PathVariable int id){
		BloqueResponse bloqueResponse = BloqueResponse.build();
		HttpStatus httpStatusResponse = HttpStatus.OK;
		
		try {
			//Llamar la fachada de eliminar de bloque
			bloqueResponse.getDatos().add(BloqueDTO.build().setId(id));
			bloqueResponse.getMensajes().add("Bloque eliminado exitosamente");
			
		}catch (final UbicoException exception) {
			exception.printStackTrace();
			bloqueResponse.getMensajes().add(exception.getMensajeUsuario());
			httpStatusResponse = HttpStatus.BAD_REQUEST;
		}catch (final Exception exception) {
			exception.printStackTrace();
			bloqueResponse.getMensajes().add("Se a presentado un error inesperado tratando de consultar la informacion de los Bloques");
			httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(bloqueResponse, httpStatusResponse);
	}
	@PutMapping("/{id}")
	public ResponseEntity<BloqueResponse> modificar(@PathVariable int id, @RequestBody BloqueDTO bloque){
		BloqueResponse bloqueResponse = BloqueResponse.build();
		HttpStatus httpStatusResponse = HttpStatus.OK;
		
		try {
			bloque.setId(id);
			//Llamar la fachada de modificar de bloque
			bloqueResponse.getDatos().add(bloque);
			bloqueResponse.getMensajes().add("Bloque modificado exitosamente");
			
		}catch (final UbicoException exception) {
			exception.printStackTrace();
			bloqueResponse.getMensajes().add(exception.getMensajeUsuario());
			httpStatusResponse = HttpStatus.BAD_REQUEST;
		}catch (final Exception exception) {
			exception.printStackTrace();
			bloqueResponse.getMensajes().add("Se a presentado un error inesperado tratando de consultar la informacion de los Bloques");
			httpStatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(bloqueResponse, httpStatusResponse);
	}

}
