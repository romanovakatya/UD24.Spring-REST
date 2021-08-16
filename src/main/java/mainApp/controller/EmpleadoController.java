package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mainApp.dto.Empleado;
import mainApp.service.EmpleadoServiceImpl;


@RestController
@RequestMapping("/api")
public class EmpleadoController {

	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;
	
	
	@GetMapping("/empleados")
	
	public List<Empleado> listarEmpleados(){
		
		return empleadoServiceImpl.listarEmpleados();
	}
	
	
	//listar Empleados por el campo trabajo
	@GetMapping("/empleados/trabajo/{trabajo}")
	public List<Empleado> listarEmpleadoTrabajo(@PathVariable(name="trabajo") String trabajo) {
		
		return empleadoServiceImpl.listarEmpleadoTrabajo(trabajo);
	}
	
	
	//añadir un empleado nuevo,
	@PostMapping("/empleados")
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		
		return empleadoServiceImpl.guardarEmpleado(empleado);
	}
	
	//buscar un empleado por id,
	@GetMapping("/empleados/{id}")
	public Empleado empleadoXID(@PathVariable(name="id") Long id) {
		
		Empleado empleado_xid= new Empleado();
		
		empleado_xid=empleadoServiceImpl.empleadoXID(id);
		
		System.out.println("Cliente XID: "+ empleado_xid);
		
		return empleado_xid;
	}
	
	
	//actualizar un empleado,
	@PutMapping("/empleados/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id")Long id,@RequestBody Empleado empleado) {
		
		Empleado empleado_seleccionado= new Empleado();
		Empleado empleado_actualizado= new Empleado();
		
		empleado_seleccionado= empleadoServiceImpl.empleadoXID(id);
		
		empleado_seleccionado.setNombre(empleado.getNombre());
		empleado_seleccionado.setTrabajo(empleado.getTrabajo()); 
		empleado_seleccionado.setSalario();
		
		empleado_actualizado = empleadoServiceImpl.actualizarEmpleado(empleado_seleccionado);
		
		System.out.println("El empleado actualizado es: "+ empleado_actualizado);
		
		return empleado_actualizado;
	}
	
	//para eliminar un empleado,
	@DeleteMapping("/empleados/{id}")
	
	public void eliminarEmpleado(@PathVariable(name="id")Long id) {
		
		empleadoServiceImpl.eliminarEmpleado(id);
	}
}
