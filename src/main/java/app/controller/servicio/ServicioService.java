package app.controller.servicio;

import app.dao.DAOExcepcion;
import app.dao.ServicioDAO;
import app.model.Servicio;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public class ServicioService {
    
    private ServicioDAO servicioDAO = null;
    
    
    public static void main(String[] args) {
        ServicioDAO dao = new ServicioDAO();
        try {        
            
            List<Servicio> servicio = dao.list();
            for (Servicio servicio1 : servicio) {
                System.out.println("Total --> " + servicio1.getDescripcion());
            }
            
        } catch (DAOExcepcion e) {
            Assert.fail("falló");
        }
    }
    
    public ServicioService(){
      servicioDAO = new ServicioDAO();
    }

    
    public List<Servicio> list() throws DAOExcepcion {
        return servicioDAO.list();
    }

    public Servicio get(Servicio servicio) throws DAOExcepcion {
        return servicioDAO.get(servicio);
    }

    public Servicio save(Servicio servicio) throws DAOExcepcion {
        return servicioDAO.save(servicio);
    }
    
    public Servicio update(Servicio servicio) throws DAOExcepcion {
        return servicioDAO.update(servicio);
    }
    
    public void delete(Servicio servicio) throws DAOExcepcion {
         servicioDAO.delete(servicio);
    }
    
}
