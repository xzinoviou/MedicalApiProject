package service;

import model.ActiveSubstance;

/**
 * Created by xzinoviou
 * 15/10/2018
 */
public interface ActiveSubstanceService {

    public Object view(String key,String auth);

    public Object view(Long id,String auth);

    public Object viewWithAuthentication(Long id,String auth);

    public void edit(ActiveSubstance activeSubstance, Long id);

    public void create(ActiveSubstance activeSubstance);

    public void delete(Long id);

    public Object fetchAll(String auth);

}
