/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller.local;

import app.dao.DAOExcepcion;
import app.model.Local;
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

@WebServlet("/adm/locales")
public class LocalController extends HttpServlet {

    private LocalService service;

    public LocalController() {
        service = new LocalService();
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
            Logger.getLogger(LocalController.class.getName()).log(Level.SEVERE, null, ex);
        }
                break;

            case Constants.ACTION_DELETE:
        try {
            this.delete(request, response);
        } catch (DAOExcepcion ex) {
            Logger.getLogger(LocalController.class.getName()).log(Level.SEVERE, null, ex);
        }
                break;

            default:
        try {
            this.list(request, response);
        } catch (DAOExcepcion ex) {
            Logger.getLogger(LocalController.class.getName()).log(Level.SEVERE, null, ex);
        }
                break;
        }

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Local local = new Local();
        local.setDescripcion(request.getParameter("descripcion"));
        local.setDireccion(request.getParameter("direccion"));
        local.setTelefono(request.getParameter("telefono"));
        
        Long id = Long.parseLong(request.getParameter("id"));
        if(id > 0){
            local.setId(id);
            try {
                service.update(local);
            } catch (DAOExcepcion ex) {
                Logger.getLogger(LocalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                service.save(local);
            } catch (DAOExcepcion ex) {
                Logger.getLogger(LocalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        response.sendRedirect(request.getContextPath()+"/adm/locales");
    }
    

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOExcepcion {
        List<Local> locales = service.list();
        request.setAttribute("locales", locales);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/adm/local/local.jsp");
        rd.forward(request, response);

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("local", new Local());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/adm/local/localForm.jsp");
        rd.forward(request, response);

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOExcepcion {

        Local local = new Local();
        local.setId(Long.parseLong(request.getParameter("id")));

        request.setAttribute("local", service.get(local));

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/adm/local/localForm.jsp");
        rd.forward(request, response);

    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOExcepcion {

        Local local = new Local();
        local.setId(Long.parseLong(request.getParameter("id")));
        service.delete(local);

        response.sendRedirect(request.getContextPath()+"/adm/locales");

    }
}
