package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzinoviou
 * 15/10/2018
 */
public class SideEffectInfo {

    private SideEffect sideEffect;
    private List<Medicine> medicines;

    public SideEffectInfo(){
        this.sideEffect = new SideEffect();
        this.medicines = new ArrayList<>();
    }

    public SideEffect getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(SideEffect sideEffect) {
        this.sideEffect = sideEffect;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
}
