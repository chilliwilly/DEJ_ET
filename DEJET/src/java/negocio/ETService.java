package negocio;

import dao.*;
import estructura.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ETService {
    private Connection cnx;
    
    public ETService(Connection cnx)
    {
        this.cnx = cnx;
    }
    
    public ArrayList<Marca> getMarca()
    {
        MarcaDAO mDAO = new MarcaDAO(cnx);
        
        ArrayList<Marca> m = mDAO.listarMarca();
        
        return m;       
    }
    
    public ArrayList<Automovil> getAutos(int cod_marca)
    {
        AutoDAO aDAO = new AutoDAO(cnx);
        ArrayList<Automovil> a = aDAO.listaAuto(cod_marca);
        
        return a;
    }
    
    public boolean validaTextoPatente(String patente_in)
    {
        return patente_in.matches("[BCDFGHJKLPRSTVWXYZ]{4}[0-9]{2}");
    }
    
    public boolean validaExistePatente(String patente_in)
    {
        boolean valida=false;        
        AutoDAO aDAO = new AutoDAO(cnx);
        
        for(String p: aDAO.getPatente())
        {
            if(p.equals(patente_in))
            {
                valida=true;
                break;
            }
        }
        
        return valida;
    }
    
    public String validaPatente(Automovil auto)
    {
        String mensaje = "";
        
        if(validaTextoPatente(auto.getPatente()))
        {
            if(validaExistePatente(auto.getPatente()))
            {
                mensaje="Patente ya ha sido ingresada";
            }
            else
            {
                mensaje="Auto Ingresado";
                AutoDAO aDAO = new AutoDAO(cnx);
                aDAO.setAuto(auto);
            }
        } 
        else
        {
            mensaje = "Patente no es valida";
        }
        return mensaje;
    }
}
