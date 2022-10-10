package com.papeleriajafwc.papeleria.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.papeleriajafwc.papeleria.model.Usuario;
import com.papeleriajafwc.papeleria.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService servicio; 

	@GetMapping
	public ResponseEntity<?> getUsuarios() {
		return ResponseEntity.ok(servicio.consultarUsuarios());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUsuario(@PathVariable Long id) {
		return ResponseEntity.ok(servicio.consultarUsuarioById(id));
	}

	@PostMapping
	public ResponseEntity<?> CrearUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardarUsuario(usuario));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario, @PathVariable Long id){
		Optional<Usuario> respuesta = servicio.consultarUsuarioById(id);
		if (respuesta.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardarUsuario(usuario));
		}
		return ResponseEntity.notFound().build();		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
		Optional<Usuario> respuesta = servicio.consultarUsuarioById(id);
		if (respuesta.isPresent()) {
			servicio.eliminarUsuario(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();

	}

}
