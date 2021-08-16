package mainApp.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "empleado") // si tabla tiene otro nombre
public class Empleado {

	// atributos de la entidad empleado,

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "trabajo")
	private String trabajo;

	@Column(name = "salario")
	private int salario;

	@Temporal(TemporalType.TIMESTAMP)
	private Date create_date;

	// constructores,
	//por defecto,
	public Empleado() {

	}

	//con atributos nombre, trabajo y fecha de creación,
	public Empleado(String nombre, String trabajo, Date date) {

		this.nombre = nombre;
		this.setTrabajo(trabajo);
		this.setCreate_date(date);

	}

	// los getters y setters,

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTrabajo() {
		return this.trabajo;
	}

	// controlamos que trabajo introducido por el usuario sea uno de,
	// los valores de enumeración, si no guardamos el trabajo por defecto,
	public void setTrabajo(String trabajo) {

		if (trabajo.equalsIgnoreCase("director") || trabajo.equalsIgnoreCase("programador")
				|| trabajo.equalsIgnoreCase("rrhh") || trabajo.equalsIgnoreCase("administrador")
				|| trabajo.equalsIgnoreCase("vendedor")) {

			this.trabajo = trabajo;
		} else {
			this.trabajo = "empleado";
		}
		
		this.setSalario();

	}

	public double getSalario() {
		return salario;
	}

	// controlamos el salario a partir de trabajo que tiene,
	// un empleado,
	public void setSalario() {

		switch (trabajo) {
		case "director":

			this.salario = 6000;
			break;

		case "programador":

			this.salario = 3000;
			break;
		case "rrhh":

			this.salario = 2000;
			break;

		case "administrador":

			this.salario = 1600;
			break;

		case "vendedor":

			this.salario = 1300;
			break;

		default:
			// salario del empleado que se pone como valor por defecto,
			this.salario = 1000;
			break;
		}
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date date) {

			this.create_date = date;
	}

	// Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", trabajo=" + trabajo + ", salario=" + salario + "]";
	}
}
