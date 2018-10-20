package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by xzinoviou
 * 15/10/2018
 */
@XmlRootElement
public class ActiveSubstance {

    private Long id;
    private String atcKey;
    private String name;
    private String description;

    public ActiveSubstance(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAtcKey() {
        return atcKey;
    }

    public void setAtcKey(String atcKey) {
        this.atcKey = atcKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ActiveSubstance{" +
                "id=" + id +
                ", atcKey='" + atcKey + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
