package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzinoviou
 * 15/10/2018
 */
public class MedicineInfo {

    private Medicine medicine;
    private List<SideEffect> sideEffects;

    public MedicineInfo(){
        this.medicine = new Medicine();
        this.sideEffects = new ArrayList<>();
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public List<SideEffect> getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(List<SideEffect> sideEffects) {
        this.sideEffects = sideEffects;
    }
}
