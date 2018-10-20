package model;

/**
 * Created by xzinoviou
 * 14/10/2018
 */
public enum RoleTypeEnum {

    ADMIN("ADMIN"),
    DOCTOR("DOCTOR"),
    PATIENT("PATIENT"),
    VISITOR("VISITOR");

    private final String role;

    RoleTypeEnum(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
