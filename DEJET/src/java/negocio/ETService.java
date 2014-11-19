package negocio;

import dao.*;
import estructura.*;
import java.sql.Connection;
import java.util.ArrayList;

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
        String aire = "Si";
        String abag = "Si";
        String fabs = "Si";
        ArrayList<Automovil> a = new ArrayList<Automovil>();
        for(Automovil auto: aDAO.listaAuto(cod_marca))
        {
            Automovil am = new Automovil();
            am.setPatente(auto.getPatente());
            am.setId_marca(auto.getId_marca());
            am.setAnio(auto.getAnio());
            am.setColor(auto.getColor());
            if(!auto.isAire())
            {
                aire = "No";
            }
            if(!auto.isAirbag())
            {
                abag = "No";
            }
            if(!auto.isAbs())
            {
                fabs = "No";
            }
            am.setVaire(aire);
            am.setVairbag(abag);
            am.setVabs(fabs);
            a.add(am);
        }
        return a;
    }
}
