package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;

public class MyBATISTipoItemDAO implements TipoItemDAO{
	@Inject
    private TipoItemMapper tipoItemMapper;
	
	@Override
	public void save(TipoItem tipoItem) throws PersistenceException {
        try{
            tipoItemMapper.addTipoItem(tipoItem);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar el tipo de item:"+ tipoItem.toString(),e);
        }
	}

	@Override
	public TipoItem load(int id) throws PersistenceException {
        try{
            return tipoItemMapper.getTipoItem(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el tipo de item item "+id,e);
        }
	}

	@Override
	public List<TipoItem> consultarTipoItems() throws PersistenceException {
        try {
            return tipoItemMapper.getTiposItems();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar los tipos de item", e);
        }
	}
}