package entity;
import java.io.Serializable;

public class University implements Serializable {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'';
    }
}