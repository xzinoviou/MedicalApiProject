package dao;

import model.Medicine;
import model.MedicineInfo;
import model.SideEffect;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzinoviou
 * 13/10/2018
 */
public class MedicineDao extends Dao implements DaoUtils <Medicine,Long,String> {

    private MedicineInfo medicineInfo;

    public MedicineDao(){
        super();
        medicineInfo = new MedicineInfo();
    }

    public Object getEntityById(Long id){

        Medicine medicine = null;

        try{

            String query = "SELECT * FROM MEDICINE WHERE MEDICINE_ID = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,id);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                medicine = new Medicine();
                medicine.setId(resultSet.getLong(1));
                medicine.setKey(resultSet.getString(2));
                medicine.setName(resultSet.getString(3));
                medicine.setDescription(resultSet.getString(4));
                medicine.setPrice(resultSet.getDouble(5));
                medicine.setValid(resultSet.getBoolean(6));
                medicine.setProducer(resultSet.getString(7));
            }

            closeAll();

        } catch (Exception e){
            e.printStackTrace();
        }

        return medicine;


    }

    public Object getEntityByParams(String key,String key2) {return null;}

    public Object getEntityByParam(String key) {

        Medicine medicine = null;

        try{

            String query = "SELECT * FROM MEDICINE WHERE MEDICINE_KEY = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,key);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                medicine = new Medicine();
                medicine.setId(resultSet.getLong(1));
                medicine.setKey(resultSet.getString(2));
                medicine.setName(resultSet.getString(3));
                medicine.setDescription(resultSet.getString(4));
                medicine.setPrice(resultSet.getDouble(5));
                medicine.setValid(resultSet.getBoolean(6));
                medicine.setProducer(resultSet.getString(7));
            }

            closeAll();

        } catch (Exception e){
            e.printStackTrace();
        }

        return medicine;

    }

    public List<Medicine> getAllEntities() {

        List<Medicine> medicines = new ArrayList<>();

        try{

            String query = "SELECT * FROM MEDICINE ORDER BY NAME ASC";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                Medicine medicine = new Medicine();
                medicine.setId(resultSet.getLong(1));
                medicine.setKey(resultSet.getString(2));
                medicine.setName(resultSet.getString(3));
                medicine.setDescription(resultSet.getString(4));
                medicine.setPrice(resultSet.getDouble(5));
                medicine.setValid(resultSet.getBoolean(6));
                medicine.setProducer(resultSet.getString(7));

                medicines.add(medicine);

            }

            closeAll();

        } catch (SQLException e){
            e.printStackTrace();
        }


        return medicines;


    }

    public void createEntity(Medicine medicine) {


        try{

            String query = "INSERT INTO MEDICINE(MEDICINE_KEY,NAME,DESCRIPTION,PRICE,VALID,PRODUCER) " +
                    "VALUES( ? , ? , ? , ? , ? ,?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,medicine.getKey());
            preparedStatement.setString(2,medicine.getName());
            preparedStatement.setString(3,medicine.getDescription());
            preparedStatement.setDouble(4,medicine.getPrice());
            preparedStatement.setBoolean(5,true);
            preparedStatement.setString(6,medicine.getProducer());

            preparedStatement.executeUpdate();

            closeAll();

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void editEntity(Medicine medicine) {

        try{

            String query = "UPDATE MEDICINE SET MEDICINE_KEY = ?, NAME = ? , " +
                    "DESCRIPTION = ? , PRICE = ? , PRODUCER = ? " +
                    "WHERE MEDICINE_ID = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,medicine.getKey());
            preparedStatement.setString(2,medicine.getName());
            preparedStatement.setString(3,medicine.getDescription());
            preparedStatement.setDouble(4,medicine.getPrice());
            preparedStatement.setString(5,medicine.getProducer());
            preparedStatement.setLong(6,medicine.getId());

            preparedStatement.executeUpdate();

            closeAll();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void deleteEntityById(Long id) {

        try{

            String query = "DELETE FROM MEDICINE WHERE MEDICINE_ID= ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

            closeAll();

        } catch (Exception e){
            e.printStackTrace();
        }

    }




    public MedicineInfo getMedicineInfoById(Long medicineId){

        medicineInfo.setMedicine((Medicine) getEntityById(medicineId));

        try{

            if(medicineInfo.getMedicine()==null)
                return null;

            medicineInfo = new MedicineInfo();
            medicineInfo.setMedicine((Medicine) getEntityById(medicineId));

            String query = "SELECT SIDE_EFFECT.SIDE_EFFECT_ID,SIDE_EFFECT.DESCRIPTION " +
                    "FROM SIDE_EFFECT,MEDICINE_SIDE_EFFECT " +
                    "WHERE SIDE_EFFECT.SIDE_EFFECT_ID=MEDICINE_SIDE_EFFECT.SIDE_EFFECT_ID " +
                    "AND MEDICINE_SIDE_EFFECT.MEDICINE_ID = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,medicineInfo.getMedicine().getId());
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                SideEffect sideEffect = new SideEffect();
                sideEffect.setId(resultSet.getLong(1));
                sideEffect.setName(resultSet.getString(2));
                medicineInfo.getSideEffects().add(sideEffect);
            }

            closeAll();


        } catch(SQLException e){
            e.printStackTrace();
        }

        return medicineInfo;
    }

    public List<MedicineInfo> getAllMedicineInfos(){

        List<MedicineInfo> medicineInfos = new ArrayList<>(getAllEntities().size());

        getAllEntities().forEach(med->{
            medicineInfos.add(new MedicineInfo());
            medicineInfos.get(medicineInfos.size()-1).setMedicine(med);
        });


        try{

            String query = "SELECT MEDICINE_SIDE_EFFECT.MEDICINE_ID,SIDE_EFFECT.SIDE_EFFECT_ID,SIDE_EFFECT.DESCRIPTION " +
                    "FROM SIDE_EFFECT,MEDICINE_SIDE_EFFECT " +
                    "WHERE SIDE_EFFECT.SIDE_EFFECT_ID=MEDICINE_SIDE_EFFECT.SIDE_EFFECT_ID " +
                    "ORDER BY MEDICINE_SIDE_EFFECT.MEDICINE_ID ASC,SIDE_EFFECT.SIDE_EFFECT_ID ASC";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            int count = 0;
            while(resultSet.next() && count!=medicineInfos.size()){

                if(resultSet.getLong(1)!=medicineInfos.get(count).getMedicine().getId())
                    count++;


                    SideEffect sideEffect = new SideEffect();
                    sideEffect.setId(resultSet.getLong(2));
                    sideEffect.setName(resultSet.getString(3));
                    MedicineInfo medicineInfo = new MedicineInfo();
                    medicineInfo.getSideEffects().add(sideEffect);
                    medicineInfos.get(count).getSideEffects().add(sideEffect);


            }

            closeAll();


        } catch(SQLException e){
            e.printStackTrace();
        }

        return medicineInfos;
    }



}
