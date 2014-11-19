package estructura;

public class Automovil {
    private String patente;
    private String id_marca;
    private int anio;
    private String color;
    private boolean aire;
    private boolean airbag;
    private boolean abs;
    private String vaire;
    private String vairbag;
    private String vabs;

    public Automovil() {
    }

    public Automovil(String patente, String id_marca, int anio, String color, boolean aire, boolean airbag, boolean abs) {
        this.patente = patente;
        this.id_marca = id_marca;
        this.anio = anio;
        this.color = color;
        this.aire = aire;
        this.airbag = airbag;
        this.abs = abs;
    }    

    public Automovil(String patente, String id_marca, int anio, String color, String vaire, String vairbag, String vabs) {
        this.patente = patente;
        this.id_marca = id_marca;
        this.anio = anio;
        this.color = color;
        this.vaire = vaire;
        this.vairbag = vairbag;
        this.vabs = vabs;
    }    
    
    public String getVaire() {
        return vaire;
    }

    public void setVaire(String vaire) {
        this.vaire = vaire;
    }

    public String getVairbag() {
        return vairbag;
    }

    public void setVairbag(String vairbag) {
        this.vairbag = vairbag;
    }

    public String getVabs() {
        return vabs;
    }

    public void setVabs(String vabs) {
        this.vabs = vabs;
    }
    
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getId_marca() {
        return id_marca;
    }

    public void setId_marca(String id_marca) {
        this.id_marca = id_marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAire() {
        return aire;
    }

    public void setAire(boolean aire) {
        this.aire = aire;
    }

    public boolean isAirbag() {
        return airbag;
    }

    public void setAirbag(boolean airbag) {
        this.airbag = airbag;
    }

    public boolean isAbs() {
        return abs;
    }

    public void setAbs(boolean abs) {
        this.abs = abs;
    }
}