package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by xzinoviou
 * 18/10/2018
 */
@XmlRootElement
public class Role {

    private Long id;
    private String role;

    public Role(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}
