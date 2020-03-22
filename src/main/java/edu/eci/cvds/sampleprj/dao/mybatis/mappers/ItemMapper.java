package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Item;

public interface ItemMapper {
	
    
    public List<Item> consultarItems();        
    
    public Item consultarItem(@Param("itid") int id);
    
    public void insertarItem(@Param("it") Item it);

    public List<Item> consultarDisponibles();  
    
    public void actualizarTarifaItem(@Param("id") int id, @Param("tarifa") long tarifa);
}
