package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.TipoItem;

public interface TipoItemDAO {

	public void save(TipoItem tipoItem) throws PersistenceException;
	
	public TipoItem load(int id) throws PersistenceException;
	
	public List<TipoItem> consultarTipoItems() throws PersistenceException;
}