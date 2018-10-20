package service;

import dao.AuthenticationDao;
import dao.MedicineDao;
import dao.SideEffectDao;
import dao.UserDao;
import model.SideEffect;
import model.User;
import org.codehaus.jackson.JsonGenerator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by xzinoviou
 * 15/10/2018
 */

@Path("/side-effects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SideEffectServiceImpl implements SideEffectService {


    private MedicineDao medicineDao;
    private AuthenticationDao authenticationDao;
    private UserDao userDao;
    private SideEffectDao sideEffectDao;

    public SideEffectServiceImpl(){
        super();
        medicineDao = new MedicineDao();
        authenticationDao = new AuthenticationDao();
        userDao = new UserDao();
        sideEffectDao = new SideEffectDao();
    }


    @Override
    public Object view(String key, String auth) {
        return null;
    }

    @Override
    public Object view(Long id, String auth) {
        return null;
    }

    @Override
    public Object viewWithAuthentication(Long id, String auth) {
        return null;
    }

    @Override
    public void edit(SideEffect sideEffect, Long id) {

    }

    @Override
    public void create(SideEffect sideEffect) {

    }

    @Override
    public void delete(Long id) {

    }

    @GET
    @Path("/all")
    @Override
    public Object fetchAll(@HeaderParam("authorization") String auth) {

        if (auth == null || auth == "" || !authenticationDao.isUserAuthenticated(auth)) {
            return "{\"error\":\"Authentication Failed. You have no access for this resource.\"}";
        }

        return sideEffectDao.getAllSideEffects() != null ? (List<SideEffect>) sideEffectDao.getAllSideEffects() : "{\"error\":\"Such information is not available in database.\"}";
    }

    @GET
    @Path("/list")
    public Object fetchAllSideEffectInfos(@HeaderParam("authorization")String auth){

        if (auth == null || auth == "" || !authenticationDao.isUserAuthenticated(auth)) {
            return "{\"error\":\"Authentication Failed. You have no access for this resource.\"}";

        }

        return sideEffectDao.getAllSideEffectInfos()!=null ? sideEffectDao.getAllSideEffectInfos() : "{\"error\":\"Such information is not available in database.\"}";
    }

}
