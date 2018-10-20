package service;

import dao.AuthenticationDao;
import dao.UserDao;
import model.Role;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by xzinoviou
 * 16/10/2018
 */

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserServiceImpl implements UserService{

    private AuthenticationDao authenticationDao;
    private UserDao userDao;

    public UserServiceImpl(){
        super();
        this.userDao = new UserDao();
        this.authenticationDao = new AuthenticationDao();
    }

    @GET
    @Path("/role")
    @Override
    public String viewUserRole(@HeaderParam("authorization") String auth) {

        if (auth == null || auth == "" || !authenticationDao.isUserAuthenticated(auth)) {
            return "{\"error\":\"Authentication Failed. You have no access for this resource.\"}";

        }

        String[] info = authenticationDao.decodeToken(auth);

        String role = "{\"role\":\""+userDao.getUserRoleByEmail(info[0])+"\"}";

        return userDao.getUserRoleByEmail(info[0])!=null
                ? role
                : "{\"error\":\"Such information is not available in database.\"}";
    }


    @GET
    @Path("/role-types")
    @Override
    public Object fetchRoleTypes(){

       return userDao.getRoleTypes()!=null
            ? userDao.getRoleTypes()
            : "{\"error\":\"Such information is not available in database.\"}";
    }
}
