package pac;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("INICIAMOS...");
		
		// Configuración de hibernate
		Configuration cfg = new Configuration ().configure(); // Carga configuación de Hibernate desde hibernate.cfg.xml
		SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build()); //Crea sesion en bbdd
		Session session = sessionFactory.openSession(); //Abre session en bbdd
		
		System.out.println("Configuración REALIZADA");	
		
		
			
			// LLAMADA METODO METERMODULOS PARA INSERTAR REGISTROS EN LA TABLA MODULOS DE LA BBDD	
			meterModulos(session);
			
			// LLAMADA METODO METERPROFESOR PARA INSERTAR REGISTROS EN LA TABLA PROFESOR		
			meterProfesor(session);
					
			//LLAMADA METODO METERALUMNO PARA INSERTAR REGISTROS DE ALUMNOS EN LA BBDD		
			meterAlumnos(session);

			//CERRAMOS SESSION Y SESSIONFACTORY
			session.close();
			sessionFactory.close();	

	}
	

	//METODO PARA INTRODUCIR MODULOS EN LA BBDD
	public static void meterModulos(Session session) {
		
		// CREAMOS OBJETOS DE TIPO MÓDULO 
		try {
	
			Modulo m03b = new Modulo();
			m03b.setNombre("Progamación B");
			m03b.setCodigo("M03B");
			
			Modulo m06 = new Modulo();
			m06.setNombre("Acceso de Datos");
			m06.setCodigo("M06");
			
			Modulo m07 = new Modulo();
			m07.setNombre("Desarrollo de interfaces");
			m07.setCodigo("M07");
	
			Modulo m13 = new Modulo();
			m13.setNombre("Proyecto DAM");
			m13.setCodigo("M13");
		
			//INICIAMOS TRANSACCION EN LA SESION DE HIBERNATE
	        session.beginTransaction();
	        
	        //GUARDAMOS CADA OBJETO MODULO EN LA BBDD Y LO MOSTRAMOS POR PANTALLA
	        session.save(m03b);
	        System.out.println("Insert into modulo, nombre: " + m03b.getNombre() + ", codigo: " + m03b.getCodigo());
	        session.save(m06);
	        System.out.println("Insert into modulo, nombre: " + m06.getNombre() + ", codigo: " + m06.getCodigo());
	        session.save(m07);
	        System.out.println("Insert into modulo, nombre: " + m07.getNombre() + ", codigo: " + m07.getCodigo());
	        session.save(m13);
	        System.out.println("Insert into modulo, nombre: " + m13.getNombre() + ", codigo: " + m13.getCodigo());
	        
	        //COMMIT GUARDA LOS DATOS EN LA BBDD
	        session.getTransaction().commit();
	        
	    } catch (Exception e) {
	    	
	    	//SI HAY ERROR DESHACE LOS CAMBIOS
	        if (session.getTransaction() != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    }
	}
		
	
	//METODO PARA INTRODUCIR PROFESORES EN LA BBDD	
	public static void meterProfesor(Session session) {
	    try {
	    	
	    	// CREA OBJETO PROFESOR
	        Profesor profesor = new Profesor("Hassabis", "Mujer");  
	        
	        //INICIAMOS TRANSACCION EN LA SESION DE HIBERNATE
	        session.beginTransaction();
	        //GUARDAMOS OBJETO PROFESOR EN LA BBDD 
	        session.save(profesor);
	        // CONFIRNAMOS TRANSACCION Y LO MOSTRAMOS POR PANTALLA
	        session.getTransaction().commit();
	        System.out.println("Insert into profesor, nombre: " + profesor.getNombre() + ", sexo: " + profesor.getSexo());
	        
	    	//SI HAY ERROR DESHACE LOS CAMBIOS
	    } catch (Exception e) {
	        if (session.getTransaction() != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    }
	}

	//METODO PARA INTRODUCIR ALUMNOS EN LA BBDD
	public static void meterAlumnos(Session session) {
		
		try {
			//SACAMOS DE LA BBDD LA INFORMACION DE LOS MODULOS QUE HEMOS INSERTADO CON EL METODO meterModulos.
			 Modulo m03b = (Modulo) session.createQuery("FROM Modulo WHERE codigo = 'm03b'").uniqueResult();
		     Modulo m06 = (Modulo) session.createQuery("FROM Modulo WHERE codigo = 'm06'").uniqueResult();
		     Modulo m07 = (Modulo) session.createQuery("FROM Modulo WHERE codigo = 'm07'").uniqueResult();
		     Modulo m13 = (Modulo) session.createQuery("FROM Modulo WHERE codigo = 'm13'").uniqueResult();
		        
			// CREAMOS CONJUNTOS DE LOS MODULOS PARA CADA ALUMNO
	        Set <Modulo> seta1 = new HashSet<>();
	        seta1.add(m03b);
	        seta1.add(m06);
	        seta1.add(m07);
	        seta1.add(m13);

	        Set <Modulo> seta2 = new HashSet<>();
	        seta2.add(m03b);
	        seta2.add(m06);
	        seta2.add(m07);

	        Set <Modulo> seta3 = new HashSet<>();
	        seta3.add(m07);
	        seta3.add(m13);

	        Set <Modulo> seta4 = new HashSet<>();
	        seta4.add(m06);
	        seta4.add(m07);
	        seta4.add(m13);	
	        
	        //CREAMOS OBJETOS ALUMNOS Y LE AÑADIMOS LAS PROPIEDADES
	        Alumno alumno1 = new Alumno();
	        alumno1.setNombre("Sandberg");
	        alumno1.setNacionalidad("USA");
	        alumno1.setEdad(26);
	        alumno1.setSexo("Mujer");
	        alumno1.setModulos(seta1);

	        Alumno alumno2 = new Alumno();
	        alumno2.setNombre("Fei-Fei Li");
	        alumno2.setNacionalidad("China");
	        alumno2.setEdad(21);
	        alumno2.setSexo("Mujer");
	        alumno2.setModulos(seta2);

	        Alumno alumno3 = new Alumno();
	        alumno3.setNombre("Sophie Wilson");
	        alumno3.setNacionalidad("Reino Unido");
	        alumno3.setEdad(19);
	        alumno3.setSexo("Mujer");
	        alumno3.setModulos(seta3);

	        Alumno alumno4 = new Alumno();
	        alumno4.setNombre("Aya Soffer");
	        alumno4.setNacionalidad("Israel");
	        alumno4.setEdad(35);
	        alumno4.setSexo("Mujer");
	        alumno4.setModulos(seta4);

	     // INICIA UNA TRANSACCIÓN EN LA SESIÓN DE HIBERNATE
	        session.beginTransaction();
	        
	     // GUARDA LOS OBJETOS ALUMNO EN LA BASE DE DATOS E IMPRIME MENSAJE        
	        session.save(alumno1);
	        System.out.println("Insert into alumno, nombre: " + alumno1.getNombre() + ", nacionalidad: "
	                + alumno1.getNacionalidad() + ", edad: " + alumno1.getEdad() + ", sexo: " + alumno1.getSexo()
	                + ", módulos: " + alumno1.getModulos().size());
	        
	        session.save(alumno2);
	        System.out.println("Insert into alumno, nombre: " + alumno2.getNombre() + ", nacionalidad: "
	                + alumno2.getNacionalidad() + ", edad: " + alumno2.getEdad() + ", sexo: " + alumno2.getSexo()
	                + ", módulos: " + alumno2.getModulos().size());
	        
	        session.save(alumno3);
	        System.out.println("Insert into alumno, nombre: " + alumno3.getNombre() + ", nacionalidad: "
	                + alumno3.getNacionalidad() + ", edad: " + alumno3.getEdad() + ", sexo: " + alumno3.getSexo()
	                + ", módulos: " + alumno3.getModulos().size());
	        
	        session.save(alumno4);
	        System.out.println("Insert into alumno, nombre: " + alumno4.getNombre() + ", nacionalidad: "
	                + alumno4.getNacionalidad() + ", edad: " + alumno4.getEdad() + ", sexo: " + alumno4.getSexo()
	                + ", módulos: " + alumno4.getModulos().size());
	        
	     // CONFIRMA LA TRANSACCIÓN,
	        session.getTransaction().commit();

	     //SI HAY ALGÚN ERROR, REALIZA UN ROLLBACK 
	    } catch (Exception e) {
	        if (session.getTransaction() != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    }
	}
}
			



