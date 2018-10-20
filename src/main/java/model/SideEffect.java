package model;

/**
 * Created by xzinoviou
 * 15/10/2018
 */
public class SideEffect {

    private Long id;
    private String name;

    public SideEffect(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SideEffect{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
