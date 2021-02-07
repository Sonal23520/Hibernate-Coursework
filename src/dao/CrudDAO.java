package dao;

import entity.SuperEntity;

import java.io.Serializable;
import java.util.ArrayList;

public interface CrudDAO<Entity extends SuperEntity,ID extends Serializable> extends SuperDAO{
    public boolean save(Entity entity)throws Exception;
    public boolean update(Entity entity)throws Exception;
    public boolean delete(ID id)throws Exception;
    public Entity search(ID id)throws Exception;
    public ArrayList<Entity> getAll()throws Exception;
}
