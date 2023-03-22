package cn.edu.zime.bigdata2002.appdemo.dao.model;

public class Doctor {
    private String id;
    private String name;
    private String genda;
    private String level;
    private String depart;
    private String ability;

    public Doctor(String id, String name, String genda, String level, String depart, String ability) {
        this.id = id;
        this.name = name;
        this.genda = genda;
        this.level = level;
        this.depart = depart;
        this.ability = ability;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenda() {
        return genda;
    }

    public void setGenda(String genda) {
        this.genda = genda;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
}
