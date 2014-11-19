package estructura;

public class Marca {
    private int id_marca;
    private String descrip_marca;

    public Marca() {
    }

    public Marca(int id_marca, String descrip_marca) {
        this.id_marca = id_marca;
        this.descrip_marca = descrip_marca;
    }    
    
    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getDescrip_marca() {
        return descrip_marca;
    }

    public void setDescrip_marca(String descrip_marca) {
        this.descrip_marca = descrip_marca;
    }
}