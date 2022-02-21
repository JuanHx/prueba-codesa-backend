package com.crud_postgres.web.app.model;

import javax.persistence.Entity;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name = "personas")
public class Personas {
	
	public Personas(){
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id")
	private long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "nacionalidad")
	private String nacionalidad;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "edad")
	private String edad;
	
	@Column(name = "fecha_Nan")
	private Date fechaNacimiento;
	
	@Column(name = "delete")
	private Integer delete = 0;
	
	

	public Personas(String nombre, String apellido, String nacionalidad, String telefono, String edad,
			Date fechaNacimiento, Integer delete) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.delete = delete;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getDelete() {
		return delete;
	}

	public void setDelete(Integer delete) {
		this.delete = delete;
	}

	@Override
	public String toString() {
		return "Personas [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nacionalidad=" + nacionalidad
				+ ", telefono=" + telefono + ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento + ", delete="
				+ delete + "]";
	}

	
}
