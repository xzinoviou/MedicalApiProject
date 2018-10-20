package model;

/**
 * Created by xzinoviou
 * 14/10/2018
 */
public class UserInfo {

    private User user;

    private RoleTypeEnum role;

    public UserInfo(){
        this.user = null;
        this.role = null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RoleTypeEnum getRole() {
        return role;
    }

    public void setRole(RoleTypeEnum role) {
        this.role = role;
    }
}
