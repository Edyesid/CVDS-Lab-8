package edu.eci.cvds.sampleprj.dao;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;

public interface ClienteDAO {


	Cliente load(int id) throws PersistenceException;

	void save(Cliente it) throws PersistenceException;

}
