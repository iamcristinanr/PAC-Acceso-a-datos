package pac;

import java.io.Serializable;

public class Modulo implements Serializable {
	private long id;
	private String nombre;
	private String codigo;
	
	
	// CONSTRUCTOR CON PARÁMETROS PARA CREAR OBJETOS MODULOS DE FORMA ESPECIFICA
	public Modulo(long id, String nombre, String codigo) {
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
	}
	
	//CONSTRUCTOR POR DEFECTO
	public Modulo() {
		// TODO Auto-generated constructor stub
	}


	// METODOS GETTER Y SETTER PARA ACCEDER Y MODIFICAR ATRIBUTOS
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	

	@Override
	public String toString() {
		return "Insert into modulo, nombre:" + nombre + ", código:" + codigo + ";";
	}
	

}


