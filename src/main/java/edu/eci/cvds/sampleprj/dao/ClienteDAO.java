package edu.eci.cvds.sampleprj.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.Cliente;

public interface ClienteDAO {

	public Cliente load(long id) throws PersistenceException;

	public void save(Cliente cliente) throws PersistenceException;
	
	public List<Cliente> consultarClientes() throws PersistenceException;
	
	public void agregarItemRentado(long id, int idit, Date fechainicio, Date fechafin) throws PersistenceException;
	
}
