package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n03.model.domain;

public class Flor {

    private Integer pk_FlorID;

    private String nameFlor;

    private String paisFlor;


   public Flor(){}

    public Flor(String nameFlor, String paisFlor) {
       this.nameFlor = nameFlor;
       this.paisFlor = paisFlor;
    }

    public Integer getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(Integer pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNameFlor() {
        return nameFlor;
    }

    public void setNameFlor(String nameFlor) {
        this.nameFlor = nameFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }
}
