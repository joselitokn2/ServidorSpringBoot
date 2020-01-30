package com.springboot.jose.rest.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity // Es una tabla producto
public class Producto implements Serializable {
	
	
	private static final long serialVersionUID = 7897940257027322024L;
	
	/* ID de la Base Datos */
	@Id // ID de la tabla 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generador de valor
	private long producto_id;
	
	/* LO NORMAL */
	private String nombre; 
	private String descripcion;
	private float precio;
	private int stock;
	
	
	/* la configuracion */
	@Version
	private long version;


	public long getProducto_id() {
		return producto_id;
	}


	public void setProducto_id(long producto_id) {
		this.producto_id = producto_id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public long getVersion() {
		return version;
	}


	public void setVersion(long version) {
		this.version = version;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + Float.floatToIntBits(precio);
		result = prime * result + (int) (producto_id ^ (producto_id >>> 32));
		result = prime * result + stock;
		result = prime * result + (int) (version ^ (version >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		if (producto_id != other.producto_id)
			return false;
		if (stock != other.stock)
			return false;
		if (version != other.version)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Producto [producto_id=" + producto_id + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", stock=" + stock + ", version=" + version + "]";
	}
	public Producto() {}


	public Producto(String nombre, String descripcion, float precio, int stock, long version) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.version = version;
	}


	
	
	
}
