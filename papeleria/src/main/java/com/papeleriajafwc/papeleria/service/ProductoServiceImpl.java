package com.papeleriajafwc.papeleria.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleriajafwc.papeleria.model.Producto;
import com.papeleriajafwc.papeleria.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository repositorioProducto;

	@Override
	@Transactional
	public List<Producto> consultarProductos() {
		return repositorioProducto.findAll();
	}

	@Override
	@Transactional
	public Optional<Producto> consultarProductoById(Long id) {
		return repositorioProducto.findById(id);
	}

	@Override
	@Transactional
	public Producto guardarProducto(Producto producto) {
		return repositorioProducto.save(producto);
	}

	@Override
	@Transactional
	public void eliminarProducto(Long id) {	
		repositorioProducto.deleteById(id);
	}
}
