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

import com.papeleriajafwc.papeleria.model.Producto;
import com.papeleriajafwc.papeleria.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService servicio;
	
	@GetMapping
	public ResponseEntity<?> getProductos(){
		return ResponseEntity.ok(servicio.consultarProductos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProducto(@PathVariable Long id){
		return ResponseEntity.ok(servicio.consultarProductoById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> crearProducto(@RequestBody Producto producto){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardarProducto(producto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Long id){
		Optional<Producto> respuesta = servicio.consultarProductoById(id);
		if (respuesta.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardarProducto(producto));
		}
		return ResponseEntity.notFound().build();		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Long id){
		Optional<Producto> respuesta = servicio.consultarProductoById(id);
		if (respuesta.isPresent()) {
			servicio.eliminarProducto(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
