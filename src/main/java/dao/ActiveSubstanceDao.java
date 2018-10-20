package dao;

import model.ActiveSubstance;
import model.Medicine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzinoviou
 * 15/10/2018
 */
public class ActiveSubstanceDao extends Dao implements DaoUtils <ActiveSubstance,Long,String> {

    public ActiveSubstanceDao(){
        super();
    }

    public Object getEntityById(Long id){

        ActiveSubstance activeSubstance = null;

        try{

            String query = "SELECT * FROM ACTIVE_SUBSTANCE WHERE ACTIVE_SUBSTANCE_ID = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,id);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                activeSubstance = new ActiveSubstance();
                activeSubstance.setId(resultSet.getLong(1));
                activeSubstance.setAtcKey(resultSet.getString(2));
                activeSubstance.setName(resultSet.getString(3));
                activeSubstance.setDescription(resultSet.getString(4));
            }

            closeAll();

        } catch (Exception e){
            e.printStackTrace();
        }

        return activeSubstance;


    }

    public Object getEntityByParams(String key,String key2) {return null;}

    public Object getEntityByParam(String atcKey) {

        ActiveSubstance activeSubstance = null;

        try{

            String query = "SELECT * FROM ACTIVE_SUBSTANCE WHERE ATC_KEY = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,atcKey);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                activeSubstance = new ActiveSubstance();
                activeSubstance.setId(resultSet.getLong(1));
                activeSubstance.setAtcKey(resultSet.getString(2));
                activeSubstance.setName(resultSet.getString(3));
                activeSubstance.setDescription(resultSet.getString(4));
            }

            closeAll();

        } catch (Exception e){
            e.printStackTrace();
        }

        return activeSubstance;

    }

    public List<ActiveSubstance> getAllEntities() {

        List<ActiveSubstance> activeSubstances = new ArrayList<>();

        try{

            String query = "SELECT * FROM ACTIVE_SUBSTANCE";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                ActiveSubstance activeSubstance = new ActiveSubstance();
                activeSubstance.setId(resultSet.getLong(1));
                activeSubstance.setAtcKey(resultSet.getString(2));
                activeSubstance.setName(resultSet.getString(3));
                activeSubstance.setDescription(resultSet.getString(4));

                activeSubstances.add(activeSubstance);

            }

            closeAll();

        } catch (SQLException e){
            e.printStackTrace();
        }


        return activeSubstances;


    }

    @Override
    public void createEntity(ActiveSubstance activeSubstance) {

    }

    @Override
    public void editEntity(ActiveSubstance activeSubstance) {

    }

    public void createEntity(Medicine medicine) {

    }

    public void editEntity(Medicine medicine) {
/*
        try{

            String query = "UPDATE MEDICINE SET FIRST_NAME = ? , LAST_NAME = ? WHERE STUDENT_KEY = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,student.getFirstName());
            preparedStatement.setString(2,student.getLastName());
            preparedStatement.setString(3,key);

            preparedStatement.executeUpdate();

            closeAll();

        } catch (Exception e){
            e.printStackTrace();
        }
        */

    }

    public void deleteEntityById(Long id) {

        try{

            String query = "DELETE FROM MEDICINE WHERE ACTIVE_SUBSTANCE_ID= ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

            closeAll();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
