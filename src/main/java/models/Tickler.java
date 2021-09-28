package models;
public class Tickler {
    //creo las variables
    public Long TKC_ID;
    public String TKC_DESCRIPTION;

    public Tickler() {

    }
    //hago el constructor
    public Tickler(Long TKC_ID, String TKC_DESCRIPTION) {
        this.TKC_ID = TKC_ID;
        this.TKC_DESCRIPTION = TKC_DESCRIPTION;
    }

    //creamos un getter && setter
    public Long getTKC_ID() {
        return TKC_ID;
    }

    public void setTKC_ID(Long TKC_ID) {
        this.TKC_ID = TKC_ID;
    }

    public String getTKC_DESCRIPTION() {
        return TKC_DESCRIPTION;
    }

    public void setTKC_DESCRIPTION(String TKC_DESCRIPTION) {
        this.TKC_DESCRIPTION = TKC_DESCRIPTION;
    }
}

