package estructura;

public class Automovil {
    private String patente;
    private int id_marca;
    private int anio;
    private String color;
    private boolean aire;
    private boolean airbag;
    private boolean abs;
    private String marca;

    public Automovil() {
    }

    public Automovil(String patente, int id_marca, int anio, String color, boolean aire, boolean airbag, boolean abs) {
        this.patente = patente;
        this.id_marca = id_marca;
        this.anio = anio;
        this.color = color;
        this.aire = aire;
        this.airbag = airbag;
        this.abs = abs;
    }  

    public Automovil(String patente, String marca, int anio, String color, boolean aire, boolean airbag, boolean abs) {
        this.patente = patente;
        this.marca = marca;
        this.anio = anio;
        this.color = color;
        this.aire = aire;
        this.airbag = airbag;
        this.abs = abs;        
    }   
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
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