package dao;

import estructura.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AutoDAO {
    private Connection cnx;
    
    public AutoDAO(Connection cnx){
        this.cnx = cnx;
    }
    
    public ArrayList<Automovil> listaAuto(int id_marca)
    {
        ArrayList<Automovil> lista = new ArrayList<Automovil>();
        
        String sql = "SELECT PATENTE, DESCRIPCION_MARCA, AÑO, COLOR, AIRE, AIRBAG, ABS "
                + "FROM AUTOMOVIL NATURAL JOIN MARCA "
                + "WHERE ID_MARCA = ? "
                + "ORDER BY PATENTE ASC;";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            stmt.setInt(1, id_marca);
            try(ResultSet rs = stmt.executeQuery()){            
                while(rs.next())//first()
                {
                    Automovil auto = new Automovil();
                    auto.setPatente(rs.getString("PATENTE"));
                    auto.setMarca(rs.getString("DESCRIPCION_MARCA"));
                    auto.setAnio(rs.getInt("AÑO"));
                    auto.setColor(rs.getString("COLOR"));
                    auto.setAire(rs.getBoolean("AIRE"));
                    auto.setAirbag(rs.getBoolean("AIRBAG"));
                    auto.setAbs(rs.getBoolean("ABS"));                    
                    lista.add(auto);
                }
            }
            return lista;
            
        } catch (Exception ex) {
            throw new RuntimeException("Error al Buscar Marca", ex);
        }
    }
    
    public ArrayList<String> getPatente()
    {
        ArrayList<String> listado = new ArrayList<>();
        
        String sql = "SELECT PATENTE FROM AUTOMOVIL;";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                String patente = rs.getString("PATENTE");
                listado.add(patente);
            }

            return listado;
            
        } catch (Exception ex) {
            throw new RuntimeException("Error al Buscar Patentes", ex);
        }
    }
    
    public void setAuto(Automovil a)
    {
    String sql = "INSERT INTO AUTOMOVIL(PATENTE, ID_MARCA, AÑO, COLOR, AIRE, AIRBAG, ABS) values(?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            stmt.setString(1, a.getPatente());
            stmt.setInt(2, a.getId_marca());
            stmt.setInt(3, a.getAnio());
            stmt.setString(4, a.getColor());
            stmt.setBoolean(5, a.isAire());
            stmt.setBoolean(6, a.isAirbag());
            stmt.setBoolean(7, a.isAbs());
            stmt.executeUpdate();
            
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Rifa", ex);
        }
    }
}