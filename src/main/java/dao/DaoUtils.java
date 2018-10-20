package dao;

import java.util.List;

/**
 * Created by xzinoviou
 * 13/10/2018
 */
public interface DaoUtils <E,L,S>{


    public Object getEntityById(L l);

    public Object getEntityByParam(S s);

    public Object getEntityByParams(S s1,S s2);

    public List<E> getAllEntities();

    public void createEntity(E e);

    public void editEntity(E e);

    public void deleteEntityById(L l);
}