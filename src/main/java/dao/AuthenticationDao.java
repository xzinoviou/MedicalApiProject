package dao;

import model.User;

import java.sql.SQLException;
import java.util.Base64;

/**
 * Created by xzinoviou
 * 15/10/2018
 */
public class AuthenticationDao extends Dao{

    private String getAuth(String authString){

        String userToken = null;
        try{

            String[] tokenParts = authString.split("\\:");
            String query = "SELECT USER_EMAIL,USER_NAME FROM USER " +
                    "WHERE USER_EMAIL = ? AND USER_NAME = ? ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,tokenParts[0]);
            preparedStatement.setString(2,tokenParts[1]);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                userToken = resultSet.getString(1) + ":"+resultSet.getString(2);
            }

            closeAll();


        } catch(SQLException e){
            e.printStackTrace();
        }

        return userToken;
    }

    public boolean isUserAuthenticated(String authString){

        /*
        String decodedAuth = "";
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];

        byte[] bytes = null;

        try{

            bytes = Base64.getDecoder().decode(authInfo);
        } catch(Exception e){
            e.printStackTrace();
        }

        decodedAuth = new String(bytes);
*/
        String[] tokenParts = decodeToken(authString);
        User user = null;

        try {


            //String[] tokenParts = decodedAuth.split("\\:");
            String query = "SELECT USER_EMAIL,USER_PASSWORD FROM USER " +
                    "WHERE USER_EMAIL = ? AND USER_PASSWORD = ? ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tokenParts[0]);
            preparedStatement.setString(2, tokenParts[1]);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setEmail(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
            }
        }
        catch(SQLException e){
                e.printStackTrace();
            }


        if(user!=null)
            return true;



        return false;
    }

    public String[] decodeToken(String authString){

        String decodedAuth = "";
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];

        byte[] bytes = null;

        try{

            bytes = Base64.getDecoder().decode(authInfo);
        } catch(Exception e){
            e.printStackTrace();
        }

        decodedAuth = new String(bytes);

        String[] tokenParts = decodedAuth.split("\\:");

        return tokenParts;
    }


}
