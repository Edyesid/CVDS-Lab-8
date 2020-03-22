package edu.eci.cvds.sampleprj.dao.mybatis;
import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import java.util.List;

public class MyBATISItemDAO implements ItemDAO{

  @Inject
  private ItemMapper itemMapper;    

  @Override
  public void save(Item idItem) throws PersistenceException{
	  try{
	      itemMapper.insertarItem(idItem);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al registrar el item "+idItem.toString(),e);
	  }        
  }

  @Override
  public Item load(int id) throws PersistenceException {
	  try{
	      return itemMapper.consultarItem(id);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar el item "+id,e);
	  }
  }


	@Override
	public List<Item> consultarItems() throws PersistenceException {
        try{
            return itemMapper.consultarItems();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar los items",e);
        }
	}
	
	@Override
	public List<Item> consultarDisponibles() throws PersistenceException {
        try{
            return itemMapper.consultarDisponibles();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar los items disponibles ",e);
        }
	}
	
	@Override
	public void tarifaItemUpdate(int idItem, long tarifa) throws PersistenceException {
        try{
            itemMapper.actualizarTarifaItem(idItem,tarifa);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al actualizar la tarifa del  item "+ idItem,e);
	}
  }
}