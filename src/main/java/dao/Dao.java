package dao;

import dbutils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xzinoviou
 * 13/10/2018
 */
public abstract class Dao {

    protected Connection connection;
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;


    public Dao(){
        try{
            connection = DBUtils.getConnection();
        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void closeAll(){

        try{
            if(resultSet!=null && !resultSet.next())
                resultSet.close();

            if(preparedStatement!=null)
                preparedStatement.close();

        } catch(SQLException e){

            e.printStackTrace();
        }

    }
}