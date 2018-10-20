package service;

import dao.ActiveSubstanceDao;
import dao.AuthenticationDao;
import dao.UserDao;
import model.ActiveSubstance;
import model.Medicine;
import model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by xzinoviou
 * 15/10/2018
 */
@Path("/active-substances")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ActiveSubstanceServiceImpl implements ActiveSubstanceService {

    private ActiveSubstanceDao activeSubstanceDao;
    private AuthenticationDao authenticationDao;
    private UserDao userDao;

    private User user;

    public ActiveSubstanceServiceImpl(){
        super();
        activeSubstanceDao = new ActiveSubstanceDao();
        authenticationDao = new AuthenticationDao();
        user = new User();
        userDao = new UserDao();
    }


    @GET
    @Path("/id/{id}")
    @Override
    public Object view(@PathParam("id") Long id, @HeaderParam("authorization") String auth) {

        if (auth == null || auth == "" || !authenticationDao.isUserAuthenticated(auth)) {
            return "{\"error\":\"Authentication Failed. You have no access for this resource.\"}";

        }

        return activeSubstanceDao.getEntityById(id)!=null ?
                activeSubstanceDao.getEntityById(id) : "{\"error\":\"Such information is not available in database.\"}";
    }

    @GET
    @Path("/key/{key}")
    @Override
    public Object view(@PathParam("key") String key, @HeaderParam("authorization") String auth) {

        if (auth == null || auth == "" || !authenticationDao.isUserAuthenticated(auth)) {
            return "{\"error\":\"Authentication Failed. You have no access for this resource.\"}";

        }

        return activeSubstanceDao.getEntityByParam(key)!=null ?
                activeSubstanceDao.getEntityByParam(key) : "{\"error\":\"Such information is not available in database.\"}";
    }


    @Override
    public Object viewWithAuthentication(Long id, String auth) {
        return null;
    }

    @Override
    public void edit(ActiveSubstance activeSubstance, Long id) {

    }

    @POST
    @Path("/create")
    @Override
    public void create(ActiveSubstance activeSubstance) {

    }

    @DELETE
    @Path("/id")
    @Override
    public void delete(Long id) {

    }


    @GET
    @Path("/list")
    public Object fetchAll(@HeaderParam("authorization") String auth) {


        if (auth == null || auth == "" || !authenticationDao.isUserAuthenticated(auth)) {
            return "{\"error\":\"Authentication Failed. You have no access for this resource.\"}";

        }

        return activeSubstanceDao.getAllEntities()!=null ?
                activeSubstanceDao.getAllEntities() : "{\"error\":\"Such information is not available in database.\"}";
    }
}
