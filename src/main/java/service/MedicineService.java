package service;

import model.Medicine;

/**
 * Created by xzinoviou
 * 13/10/2018
 */
public interface MedicineService {

    public Object view(String key,String auth);

    public Object view(Long id,String auth);

    public Object viewWithAuthentication(Long id,String auth);

    public void edit(Long id, Medicine medicine, String auth);

    public void create(Medicine medicine, String auth);

    public void delete(Long id);

    public Object fetchAll(String auth);
}
