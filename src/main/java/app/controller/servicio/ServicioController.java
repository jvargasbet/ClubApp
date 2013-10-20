/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller.servicio;

import app.controller.local.LocalController;
import app.controller.local.LocalService;
import app.dao.DAOExcepcion;
import app.model.Servicio;

import app.zelper.Constants;
import app.zelper.Helper;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adm/miservicio")
public class ServicioController extends HttpServlet {


 private ServicioService service;

    public ServicioController() {
        service = new ServicioService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int action = Helper.toInteger(request.getParameter("action"), Constants.ACTION_LIST);
        
        switch (action) {
            case Constants.ACTION_CREATE:
                this.create(request, response);
                break;
                
            case Constants.ACTION_UPDATE:
        try {
            this.update(request, response);
        } catch (DAOExcepcion ex) {
            Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
                break;

            case Constants.ACTION_DELETE:
        try {
            this.delete(request, response);
        } catch (DAOExcepcion ex) {
            Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
                break;

            default:
        try {
            this.list(request, response);
        } catch (DAOExcepcion ex) {
            Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
                break;
        }

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Servicio servicio = new Servicio();
        servicio.setDescripcion(request.getParameter("descripcion"));
        servicio.setCostoHora(Double.parseDouble(request.getParameter("costo_hora")));
        
        
        Long id = Long.parseLong(request.getParameter("id"));
        if(id > 0){
            servicio.setId(id);
            try {
                service.update(servicio);
            } catch (DAOExcepcion ex) {
                Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                service.save(servicio);
            } catch (DAOExcepcion ex) {
                Logger.getLogger(ServicioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        response.sendRedirect(request.getContextPath()+"/adm/miservicio");
    }
    

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOExcepcion {
        List<Servicio> servicio = service.list();
        request.setAttribute("miservicio", servicio);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/adm/servicio/servicio.jsp");
        rd.forward(request, response);

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("servicio", new Servicio());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/adm/servicio/servicioform.jsp");
        rd.forward(request, response);

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOExcepcion {

        Servicio servicio = new Servicio();
        servicio.setId(Long.parseLong(request.getParameter("id")));

        request.setAttribute("servicio", service.get(servicio));

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/adm/servicio/servicioform.jsp");
        rd.forward(request, response);

    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOExcepcion {

        Servicio servicio = new Servicio();
        servicio.setId(Long.parseLong(request.getParameter("id")));
        service.delete(servicio);

        response.sendRedirect(request.getContextPath()+"/adm/miservicio");

    }
}
