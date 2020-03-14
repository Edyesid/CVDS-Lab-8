package edu.eci.cvds.sampleprj.dao.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;

public class MyBATISClienteDAO  implements ClienteDAO{
	@Inject
	  private ClienteMapper clienteMapper;    

	  @Override
	  public void save(Cliente it) throws PersistenceException{
	  try{
	      ClienteMapper.agregarCliente(it);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al registrar el cliente "+it.toString(),e);
	  }        

	  }

	  @Override
	  public Cliente load(int id) throws PersistenceException {
	  try{
	      return ClienteMapper.consultarCliente(id);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar el cliente "+id,e);
	  }


	  }


}
