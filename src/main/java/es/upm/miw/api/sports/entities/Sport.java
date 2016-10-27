package es.upm.miw.api.sports.entities;

public class Sport {

    private int id;

    private String sportName;

    public Sport() {
    }

    public Sport(int id, String sportName) {
        super();
        this.id = id;
        this.sportName = sportName;
    }

    public Sport(String sportName) {
        super();
        this.sportName = sportName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    @Override
    public String toString() {
        return "Sport [id=" + id + ", sportName=" + sportName + "]";
    }

}
