package service;

import dao.AuthenticationDao;
import dao.MedicineDao;
import dao.SideEffectDao;
import dao.UserDao;
import model.Medicine;
import model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by xzinoviou
 * 13/10/2018
 */
@Path("/medicines")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicineServiceImpl implements MedicineService{

    private MedicineDao medicineDao;
    private AuthenticationDao authenticationDao;
    private UserDao userDao;
    private SideEffectDao sideEffectDao;

    private User user;

    public MedicineServiceImpl(){
        super();
        medicineDao = new MedicineDao();
        authenticationDao = new AuthenticationDao();
        user = new User();
        userDao = new UserDao();
        sideEffectDao = new SideEffectDao();
    }

    @GET
    @Path("/id/{id}")
    @Override
    public Object view(@PathParam("id") Long id,@HeaderParam("authorization") String auth) {

        if (auth == null || auth == "" || !authenticationDao.isUserAuthenticated(auth)) {
            return "{\"error\":\"Authentication Failed. You have no access for this resource.\"}";

        }

        return medicineDao.getEntityById(id)!=null ? medicineDao.getEntityById(id) : "{\"error\":\"Such information is not available in database.\"}";
    }



    @GET
    @Path("/key/{key}")
    @Override
    public Object view(@PathParam("key") String key, @HeaderParam("authorization") String auth) {

        if (auth == null || auth == "" || !authenticationDao.isUserAuthenticated(auth)) {
            return "{\"error\":\"Authentication Failed. You have no access for this resource.\"}";

        }

        return medicineDao.getEntityByParam(key)!=null ? medicineDao.getEntityByParam(key) : "{\"error\":\"Such information is not available in database.\"}";
    }


    @Override
    public Object viewWithAuthentication(Long id, String auth) {
        return null;
    }


    @PUT
    @Path("/id/{id}")
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Long id, Medicine medicine, @HeaderParam("authorization") String auth) {

        medicineDao.editEntity(medicine);

    }



    @POST
    @Path("/add")
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Medicine medicine, @HeaderParam("authorization") String auth) {


        medicineDao.createEntity(medicine);
    }

    @DELETE
    @Path("/id")
    @Override
    public void delete(Long id) {

        medicineDao.deleteEntityById(id);
    }


    @GET
    @Path("/list")
    public Object fetchAll(@HeaderParam("authorization") String auth) {


        if (auth == null || auth == "" || !authenticationDao.isUserAuthenticated(auth)) {
            return "{\"error\":\"Authentication Failed. You have no access for this resource.\"}";

        }

        return medicineDao.getAllEntities()!=null ? medicineDao.getAllEntities() : "{\"error\":\"Such information is not available in database.\"}";
    }

    @GET
    @Path("/side-effects/{id}")
    public Object viewMedicineInfo(@HeaderParam("authorization")String auth, @PathParam("id")Long id) {

        if (auth == null || auth == "" || !authenticationDao.isUserAuthenticated(auth)) {
            return "{\"error\":\"Authentication Failed. You have no access for this resource.\"}";

        }


        return medicineDao.getMedicineInfoById(id) != null ? medicineDao.getMedicineInfoById(id) : "{\"error\":\"Such information is not available in database.\"}";

    }

    @GET
    @Path("/side-effects/list")
    public Object fetchAllMedicineInfo(@HeaderParam("authorization")String auth){

    if (auth == null || auth == "" || !authenticationDao.isUserAuthenticated(auth)) {
        return "{\"error\":\"Authentication Failed. You have no access for this resource.\"}";

    }


        return medicineDao.getAllMedicineInfos()!=null ? medicineDao.getAllMedicineInfos() :  "{\"error\":\"Such information is not available in database.\"}";


    }

    @GET
    @Path("/side-effects/types")
    public Object viewSideEffectTypes(@HeaderParam("authorization")String auth) {

        if (auth == null || auth == "" || !authenticationDao.isUserAuthenticated(auth)) {
            return "{\"error\":\"Authentication Failed. You have no access for this resource.\"}";

        }

        return sideEffectDao.getAllEntities() != null ? sideEffectDao.getAllEntities() : "{\"error\":\"Such information is not available in database.\"}";

    }
}
