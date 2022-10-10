package com.papeleriajafwc.papeleria.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papeleriajafwc.papeleria.model.Usuario;
import com.papeleriajafwc.papeleria.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repositorioUsuario;
	
	@Override
	@Transactional
	public List<Usuario> consultarUsuarios() {
		return repositorioUsuario.findAll();
	}

	@Override
	@Transactional
	public Optional<Usuario> consultarUsuarioById(Long id) {
		return repositorioUsuario.findById(id);
	}

	@Override
	@Transactional
	public Usuario guardarUsuario(Usuario usuario) {
		return repositorioUsuario.save(usuario);
	}

	@Override
	@Transactional
	public void eliminarUsuario(Long id) {
		repositorioUsuario.deleteById(id);
	}
}
