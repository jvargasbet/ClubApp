package app.controller.servicio;

import app.dao.DAOExcepcion;
import app.dao.ServicioDAO;
import app.model.Servicio;
import java.util.List;

public class ServicioService {
    
    private ServicioDAO servicioDAO = null;
    
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
