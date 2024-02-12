package pac;

import java.io.Serializable;

public class Profesor implements Serializable {
	private long id;
	private String nombre;
	private String sexo;
	
	
	// CONSTRUCTOR CON PARÁMETROS PARA CREAR OBJETOS PROFESOR DE FORMA ESPECIFICA EN BBDD
	public Profesor (long id, String nombre, String sexo) {
		this.id = id;
		this.nombre = nombre;
		this.sexo = sexo;
	}
	
	//CONSTRUCTOR CON PARÁMETROS PARA CREAR OBJETOS PROFESOR DE FORMA EN MAIN
	public Profesor(String nombre, String sexo) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.sexo = sexo;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		return "Insert into profesor, nombre:" + nombre + ", sexo:" + sexo + ";";
	}
}


