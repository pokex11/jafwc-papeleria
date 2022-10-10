package com.papeleriajafwc.papeleria.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tipo_documento")
	private Long tipo_documento;
	
	@Column(name="documento")
	private Long numero_documento;
	
	@Column(name="nombre", length = 50)
	private String nombre;
	
	@Column(name="apellidos", length = 100)
	private String apellidos;
	
	@Column(name="correo", length = 100)
	private String correo;
	
	@Column(name="direccion", length = 1000)
	private String direccion;
	
	@Column(name="telefono")
	private Long telefono;
	
	@Column(name="usuario", length = 50)
	private String user;
	
	@Column(name="password", length = 50)
	private String password;
	
	@Column(name="tipo_usuario")
	private Long tipo_usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(Long tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public Long getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(Long numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(Long tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, correo, direccion, id, nombre, numero_documento, password, telefono,
				tipo_documento, tipo_usuario, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(correo, other.correo)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(numero_documento, other.numero_documento)
				&& Objects.equals(password, other.password) && Objects.equals(telefono, other.telefono)
				&& Objects.equals(tipo_documento, other.tipo_documento)
				&& Objects.equals(tipo_usuario, other.tipo_usuario) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", tipo_documento=" + tipo_documento + ", numero_documento=" + numero_documento
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", user=" + user + ", password=" + password + ", tipo_usuario="
				+ tipo_usuario + "]";
	}
	
	
}
