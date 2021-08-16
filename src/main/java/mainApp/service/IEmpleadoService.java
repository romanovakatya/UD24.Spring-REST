package mainApp.service;

import java.util.List;

import mainApp.dto.Empleado;

public interface IEmpleadoService {
	
	//Metodos del CRUD
		public List<Empleado> listarEmpleados(); //Listar All 
		
		public Empleado guardarEmpleado(Empleado empleado);	//Guarda un empleado CREATE
		
		public Empleado empleadoXID(Long id); //Leer datos de un empleado READ
		
		public List<Empleado> listarEmpleadoTrabajo(String trabajo);//Listar empleados por campo trabajo
		
		public Empleado actualizarEmpleado(Empleado empleado); //Actualiza datos del empleado UPDATE
		
		public void eliminarEmpleado(Long id);// Elimina el empleado DELETE

}
