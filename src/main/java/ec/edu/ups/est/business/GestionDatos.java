package ec.edu.ups.est.business;

import java.util.Date;
import java.util.List;

import ec.edu.ups.est.dao.ClienteDAO;
import ec.edu.ups.est.dao.DeudasDAO;
import ec.edu.ups.est.model.Cliente;
import ec.edu.ups.est.model.Deuda;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {

	@Inject
	private ClienteDAO clienteDao;
	
	@Inject
	private DeudasDAO deudasDao;
	
	@PostConstruct
	public void init() {
		
		System.out.println("Iniciando");
		
		Deuda deuda1 = new Deuda();
		deuda1.setFecha(new Date());
		deuda1.setMonto(200);
		deuda1.setNumero("001-001-00000001");
		
		deudasDao.insert(deuda1);
		
		
		Cliente cliente = new Cliente();
		cliente.setNombre("David Alvarado");
		cliente.setDireccion("Monay");
		cliente.setDni("0123456789");
		cliente.setDeudas(List.of(deuda1));
		
		clienteDao.insert(cliente);
		
		List<Cliente> list = clienteDao.getAll();
		for(Cliente per: list) {
			System.out.println(per.getNombre());
		}
		
	}
	
	
}
