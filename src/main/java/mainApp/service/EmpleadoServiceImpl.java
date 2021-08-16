package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IEmpleadoDAO;
import mainApp.dto.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	//Utilizamos los metodos de la interface IEmpleadoDAO, es como si instaciaramos.
	
	
	//copiamos métodos desde la clase IEmpleadoDAO
	@Autowired
	IEmpleadoDAO iEmpleadoDAO;
	
	
	@Override
	public List<Empleado> listarEmpleados() {
		
		return iEmpleadoDAO.findAll();
	}

	
	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		
		return iEmpleadoDAO.save(empleado);
	}

	
	@Override
	public Empleado empleadoXID(Long id) {
		
		return iEmpleadoDAO.findById(id).get();
	}

	
	@Override
	public List<Empleado> listarEmpleadoTrabajo(String trabajo) {
		
		return iEmpleadoDAO.findByTrabajo(trabajo);
	}

	
	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		
		return iEmpleadoDAO.save(empleado);
	}

	
	@Override
	public void eliminarEmpleado(Long id) {
		
		iEmpleadoDAO.deleteById(id);
	}

}
