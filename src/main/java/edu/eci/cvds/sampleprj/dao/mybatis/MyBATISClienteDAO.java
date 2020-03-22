package edu.eci.cvds.sampleprj.dao.mybatis;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;
import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;

public class MyBATISClienteDAO  implements ClienteDAO{
	@Inject
	  private ClienteMapper clienteMapper;    

	  @Override
	  public void save(Cliente cliente) throws PersistenceException{
	  try{
	      clienteMapper.agregarCliente(cliente);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al registrar el cliente "+cliente.toString(),e);
	  }        

	  }

	  @Override
	  public Cliente load(long id) throws PersistenceException {
	  try{
	      return clienteMapper.consultarCliente(id);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar el cliente "+id,e);
	  }


	  }

    @Override
    public List<Cliente> consultarClientes() throws  PersistenceException{
        try{
            return clienteMapper.consultarClientes();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar los clientes",e);
        }
    }

	@Override
	public void agregarItemRentado(long id, int idit, Date fechainicio, Date fechafin) {
        try{
            clienteMapper.agregarItemRentadoACliente(id,idit,fechainicio,fechafin);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al agregar el item"
                    +idit+" a los items rentados del cliente"+id, e);
        }
	}

}
