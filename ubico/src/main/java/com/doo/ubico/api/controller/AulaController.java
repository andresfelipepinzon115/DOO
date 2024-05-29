package com.doo.ubico.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doo.ubico.dto.AulaDTO;


@RestController
@RequestMapping("/api/V1/aulas")
public class AulaController {
	
	@GetMapping
	public List<AulaDTO> listar() {
		return null;
		
		
	}
}
