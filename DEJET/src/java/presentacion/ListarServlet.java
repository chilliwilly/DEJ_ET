package presentacion;

import estructura.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.*;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import negocio.*;

@WebServlet(name = "ListarServlet", urlPatterns = {"/ListarServlet"})
public class ListarServlet extends HttpServlet {

    @Resource(name = "jdbc/et_dej4501")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection cnx = ds.getConnection()){            
            ETService service = new ETService(cnx);
            
            ArrayList<Marca> m = service.getMarca();
            request.setAttribute("lista",m);
            request.getRequestDispatcher("/buscar_marca.jsp").forward(request, response);
            
        } catch (Exception ex) {
            throw new RuntimeException("Error Get", ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int marca_id = Integer.parseInt(request.getParameter("cboMarca"));
        
        try (Connection cnx = ds.getConnection()){            
            ETService service = new ETService(cnx);
            
            ArrayList<Marca> m = service.getMarca();           
            
            ArrayList<Automovil> a = service.getAutos(marca_id);
            request.setAttribute("alista",a);
            request.setAttribute("lista",m);
            request.getRequestDispatcher("/buscar_marca.jsp").forward(request, response);
            
        } catch (Exception ex) {
            throw new RuntimeException("Error Post", ex);
        }
    }
}
