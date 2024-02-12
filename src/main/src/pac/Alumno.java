package pac;

import java.io.Serializable;
import java.util.Set;

public class Alumno implements Serializable  {
	private long id;
	private String nombre;
	private String nacionalidad;
	private int edad;
	private String sexo;
	private Set<Modulo> modulos; //COLECCION RELACION N-M ALUMNOS-MODULOS

	
	// CONSTRUCTOR POR DEFECTO
	public Alumno() {
		
	}
	
	// CONSTRUCTOR CON PARÁMETROS PARA CREAR OBJETOS MODULOS DE FORMA ESPECIFICA
	public Alumno(long id, String nombre, String nacionalidad, int edad, String sexo, Set<Modulo> modulos) {
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
		this.sexo = sexo;
		this.modulos.addAll(modulos); //AGREGA A UNA COLECCION MODULOS ELEMENTOS MODULOS 
		
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

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
    public Set<Modulo> getModulos() {
        return modulos;
    }
    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }
	

	@Override
	public String toString() {
		return "Insert into alumno, nombre:" + nombre + ", nacionalidad:" + nacionalidad + ", edad:" + edad + ", sexo:" + sexo + ", "
				+ ""
				+ "modulos:" + modulos + ";";
	}

}