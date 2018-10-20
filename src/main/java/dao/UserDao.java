package dao;

import model.Role;
import model.RoleTypeEnum;
import model.User;
import model.UserInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzinoviou
 * 13/10/2018
 */
public class UserDao extends Dao implements DaoUtils <User,Long,String> {

    public UserDao(){
        super();
    }



    public Object getEntityById(Long id) {
        return null;


    }

    public Object getEntityByParam(String email) {
        User user = null;

        try{

            String query = "SELECT * FROM USER WHERE USER_EMAIL = ? ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                user = new User();

                user.setId(resultSet.getLong(1));
                user.setEmail(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setFirstName(resultSet.getString(4));
                user.setLastName(resultSet.getString(5));
                user.setDate(resultSet.getDate(6));
                user.setTelephone(resultSet.getString(7));
                user.setAddress(resultSet.getString(8));

            }


            closeAll();


        } catch(SQLException e){
            e.printStackTrace();
        }



        return user;

    }


    public List<Role> getRoleTypes(){

        List<Role> roles = new ArrayList<>();

        try{


            String query = "SELECT ROLE_ID,ROLE_TYPE FROM ROLE";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Role role = new Role();
                role.setId(resultSet.getLong(1));
                role.setRole(resultSet.getString(2));
                roles.add(role);
            }


            closeAll();

        } catch(SQLException e){
            e.printStackTrace();
        }

        return roles;
    }



    public void assignRole(User user, Long roleId){

        try{

            String query = "INSERT INTO USER_ROLE (USER_ID,ROLE_ID) VALUES(?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,user.getId());
            preparedStatement.setLong(2,roleId);

            preparedStatement.executeUpdate();

            closeAll();


        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    public Object getEntityByParams(String email,String password) {

        User user = null;

        try{

            String query = "SELECT * FROM USER WHERE USER_EMAIL = ? " +
                    "AND USER_PASSWORD = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                user = new User();

                user.setId(resultSet.getLong(1));
                user.setEmail(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setFirstName(resultSet.getString(4));
                user.setLastName(resultSet.getString(5));
                user.setDate(resultSet.getDate(6));
                user.setTelephone(resultSet.getString(7));
                user.setAddress(resultSet.getString(8));

            }


            closeAll();


        } catch(SQLException e){
            e.printStackTrace();
        }



        return user;

    }

    public List<User> getAllEntities() {
        return null;
    }


    public void createEntity(User user) {

        try{

            String query = "INSERT INTO USER " +
                    "(USER_EMAIL,USER_PASSWORD,FIRST_NAME,LAST_NAME," +
                    "DATE_OF_BIRTH,TEL,ADDRESS) " +
                    "VALUES(?,?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user.getEmail());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getFirstName());
            preparedStatement.setString(4,user.getLastName());
            preparedStatement.setDate(5,user.getDate());
            preparedStatement.setString(6,user.getTelephone());
            preparedStatement.setString(7,user.getAddress());


            preparedStatement.executeUpdate();

            closeAll();


        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void editEntity(User user) {

    }

    public void deleteEntityById(Long aLong) {

    }

    public Object getUserRole(User user){

        String userRole = null;

        try{

            String query = "SELECT ROLE.ROLE_TYPE FROM USER,USER_ROLE,ROLE WHERE USER.USER_ID=USER_ROLE.USER_ID AND " +
                    "USER_ROLE.ROLE_ID=ROLE.ROLE_ID AND USER.USER_ID = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,user.getId());
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                userRole = resultSet.getString(1);
            }

            closeAll();


        } catch(SQLException e){
            e.printStackTrace();
        }

        return userRole;
    }

    public Object getUserRoleByEmail(String email){

        String userRole = null;

        try{

            String query = "SELECT ROLE.ROLE_TYPE FROM USER,USER_ROLE,ROLE WHERE USER.USER_ID=USER_ROLE.USER_ID AND " +
                    "USER_ROLE.ROLE_ID=ROLE.ROLE_ID AND USER.USER_EMAIL = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                userRole = resultSet.getString(1);
            }

            closeAll();


        } catch(SQLException e){
            e.printStackTrace();
        }

        return userRole;
    }
}
