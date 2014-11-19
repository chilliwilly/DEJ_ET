package dao;

import estructura.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MarcaDAO {    
    private Connection cnx;
    
    public MarcaDAO(Connection cnx){
        this.cnx = cnx;
    }
    
    public ArrayList<Marca> listarMarca()
    {
        ArrayList<Marca> listado = new ArrayList<>();
        
        String sql = "SELECT * FROM MARCA ORDER BY ID_MARCA ASC;";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                int num = rs.getInt("ID_MARCA");
                String nom = rs.getString("DESCRIPCION_MARCA");                
                
                Marca marca = new Marca(num, nom);
                listado.add(marca);
            }

            return listado;
            
        } catch (Exception ex) {
            throw new RuntimeException("Error al Buscar Marca", ex);
        }
    }
}