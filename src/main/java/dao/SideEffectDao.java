package dao;

import model.Medicine;
import model.MedicineInfo;
import model.SideEffect;
import model.SideEffectInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xzinoviou
 * 15/10/2018
 */
public class SideEffectDao extends Dao{

    private MedicineInfo medicineInfo;
    private SideEffectInfo sideEffectInfo;


    public SideEffectDao(){

        super();
        this.medicineInfo = new MedicineInfo();
        this.sideEffectInfo = new SideEffectInfo();

    }

    public List<SideEffect> getAllEntities() {

        List<SideEffect> sideEffects = new ArrayList<>();


            try {

                String query = "SELECT * FROM SIDE_EFFECT";

                preparedStatement = connection.prepareStatement(query);

                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    SideEffect sideEffect = new SideEffect();
                    sideEffect.setId(resultSet.getLong(1));
                    sideEffect.setName(resultSet.getString(2));
                    sideEffects.add(sideEffect);

                }

                closeAll();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return sideEffects;
    }


    public List<SideEffect> getAllEntitiesForMedicine(Long id) {

        List<SideEffect> sideEffects = new ArrayList<>();


        try {

            String query = "SELECT SIDE_EFFECT.DESCRIPTION FROM SIDE_EFFECT,MEDICINE_SIDE_EFFECT WHERE" +
                    "SIDE_EFFECT.SIDE_EFFECT_ID=MEDICINE_SIDE_EFFECT.SIDE_EFFECT_ID " +
                    "AND MEDICINE.MEDICINE_ID = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                SideEffect sideEffect = new SideEffect();
                sideEffect.setId(resultSet.getLong(1));
                sideEffect.setName(resultSet.getString(2));
                sideEffects.add(sideEffect);

            }

            closeAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sideEffects;
    }
    public List<SideEffect> getAllSideEffects(){


        List<SideEffect> sideEffects = new ArrayList<>();

        try{

            String query = "SELECT SIDE_EFFECT_ID,DESCRIPTION FROM SIDE_EFFECT";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                SideEffect sideEffect = new SideEffect();
                sideEffect.setId(resultSet.getLong(1));
                sideEffect.setName(resultSet.getString(2));
                sideEffects.add(sideEffect);
            }


        } catch(SQLException e){
            e.printStackTrace();
        }

        return sideEffects;
    }


    public List<SideEffectInfo> getAllSideEffectInfos(){

        List<SideEffectInfo> sideEffectInfos = new ArrayList<>(getAllEntities().size());

        getAllEntities().forEach(sideEffect->{
            sideEffectInfos.add(new SideEffectInfo());
            sideEffectInfos.get(sideEffectInfos.size()-1).setSideEffect(sideEffect);
        });


        try{

            String query = "SELECT SIDE_EFFECT.SIDE_EFFECT_ID,MEDICINE.MEDICINE_ID,MEDICINE.MEDICINE_KEY,MEDICINE.NAME," +
                    "MEDICINE.DESCRIPTION,MEDICINE.PRICE,MEDICINE.VALID,MEDICINE.PRODUCER " +
                    "FROM SIDE_EFFECT,MEDICINE,MEDICINE_SIDE_EFFECT " +
                    "WHERE MEDICINE.MEDICINE_ID=MEDICINE_SIDE_EFFECT.MEDICINE_ID " +
                    "AND SIDE_EFFECT.SIDE_EFFECT_ID = MEDICINE_SIDE_EFFECT.SIDE_EFFECT_ID " +
                    "ORDER BY SIDE_EFFECT.SIDE_EFFECT_ID,MEDICINE_SIDE_EFFECT.MEDICINE_ID";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            int count = 0;
            while(resultSet.next() && count!=sideEffectInfos.size()){

                if(resultSet.getLong(1)!=sideEffectInfos.get(count).getSideEffect().getId())
                    count++;


                Medicine medicine = new Medicine();

                medicine.setId(resultSet.getLong(2));
                medicine.setKey(resultSet.getString(3));
                medicine.setName(resultSet.getString(4));
                medicine.setDescription(resultSet.getString(5));
                medicine.setPrice(resultSet.getDouble(6));
                medicine.setValid(resultSet.getBoolean(7));
                medicine.setProducer(resultSet.getString(8));
                sideEffectInfos.get(count).getMedicines().add(medicine);


            }

            closeAll();


        } catch(SQLException e){
            e.printStackTrace();
        }

        return sideEffectInfos;
    }

}
