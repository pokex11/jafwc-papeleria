package com.papeleriajafwc.papeleria.service;

import java.util.List;
import java.util.Optional;

import com.papeleriajafwc.papeleria.model.Producto;

public interface ProductoService {
	public List<Producto> consultarProductos();
	public Optional<Producto> consultarProductoById(Long id);
	public Producto guardarProducto(Producto producto);
	public void eliminarProducto(Long id);
}
