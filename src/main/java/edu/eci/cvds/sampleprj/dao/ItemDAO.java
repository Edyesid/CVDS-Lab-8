package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.Item;

public interface ItemDAO {

   public void save(Item idItem) throws PersistenceException;

   public Item load(int id) throws PersistenceException;
   
   public List<Item> consultarItems() throws PersistenceException;
   
   public List<Item> consultarDisponibles() throws PersistenceException;
   
   public void tarifaItemUpdate(int idItem, long tarifa) throws PersistenceException;

}