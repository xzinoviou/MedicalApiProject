package service;

import model.Medicine;
import model.SideEffect;

/**
 * Created by xzinoviou
 * 15/10/2018
 */
public interface SideEffectService {

    public Object view(String key,String auth);

    public Object view(Long id,String auth);

    public Object viewWithAuthentication(Long id,String auth);

    public void edit(SideEffect sideEffect, Long id);

    public void create(SideEffect sideEffect);

    public void delete(Long id);

    public Object fetchAll(String auth);
}
