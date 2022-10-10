package com.papeleriajafwc.papeleria.service;

import java.util.List;
import java.util.Optional;

import com.papeleriajafwc.papeleria.model.Usuario;

public interface UsuarioService {
	public List<Usuario> consultarUsuarios();
	public Optional<Usuario> consultarUsuarioById(Long id);
	public Usuario guardarUsuario(Usuario usuario);
	public void eliminarUsuario(Long id);
}
