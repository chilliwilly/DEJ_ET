/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import estructura.Automovil;
import estructura.Marca;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import negocio.ETService;

@WebServlet(name = "IngresarServlet", urlPatterns = {"/IngresarServlet"})
public class IngresarServlet extends HttpServlet {

    @Resource(name = "jdbc/et_dej4501")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection cnx = ds.getConnection()){            
            ETService service = new ETService(cnx);
            
            ArrayList<Marca> m = service.getMarca();
            request.setAttribute("lista",m);
            request.getRequestDispatcher("/ingresar_vehiculo.jsp").forward(request, response);
            
        } catch (Exception ex) {
            throw new RuntimeException("Error Get", ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String patente = request.getParameter("txtPatente");
        int marca = Integer.parseInt(request.getParameter("cboMarca"));
        int anio = Integer.parseInt(request.getParameter("txtAnio"));
        String color = request.getParameter("txtColor");
        boolean aire=false;
        boolean ab=false;
        boolean abs=false;
        
        if(request.getParameter("chkAire") != null)
        {
            aire = true;
        }
        
        if(request.getParameter("chkAB") != null)
        {
            ab = true;
        }
        
        if(request.getParameter("chkABS") != null)
        {
            abs = true;
        }
        
        String mensaje="";
        try (Connection cnx = ds.getConnection()){            
            ETService service = new ETService(cnx);
            
            Automovil auto=new Automovil(patente, marca, anio, color, aire, ab, abs);
            
            mensaje = service.validaPatente(auto);
            
            ArrayList<Marca> m = service.getMarca();

            request.setAttribute("lista",m);
            request.setAttribute("estado",mensaje);
            request.getRequestDispatcher("/ingresar_vehiculo.jsp").forward(request, response);
            
        } catch (Exception ex) {
            throw new RuntimeException("Error Post", ex);
        }
    }
}
