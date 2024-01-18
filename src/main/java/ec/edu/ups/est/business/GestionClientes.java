package ec.edu.ups.est.business;

import java.util.List;

import ec.edu.ups.est.dao.ClienteDAO;
import ec.edu.ups.est.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionClientes {
	
	@Inject 
	private ClienteDAO daocliente;
	
	public  void guardarClientes(Cliente cliente) {
		Cliente cli = daocliente.read(cliente.getIdCliente());
		if (cli != null) {
			daocliente.update(cliente);
		}else {
			daocliente.insert(cliente);
		}
	}
	
	public void actualizarCliente(Cliente persona) throws Exception {
		Cliente cli = daocliente.read(persona.getIdCliente());
		if (cli != null){
			daocliente.update(persona);
		}else {
			throw new Exception("Cliente no existe");
		}
	}
	
	public void borrarCliente(int codigo) {
		daocliente.remove(codigo);		
	}
	
	public Cliente getPersonaCedula(String cedula) throws Exception{
		System.out.println("cedulaGestion=" + cedula + "tamaño="+ cedula.length());
		if(cedula.length()!= 10){
			throw new Exception("Cedula incorrecta");
		}else {
			System.out.println("clienteEnviado");
			Cliente cli = daocliente.getClientePorCedula(cedula);
			return cli;
		}
		
	}
	
	public List<Cliente> getAll(){
		return daocliente.getAll();
	}
	
	
}
