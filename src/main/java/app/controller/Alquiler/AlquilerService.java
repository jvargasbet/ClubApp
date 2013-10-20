
package app.controller.Alquiler;

import app.controller.Socio.SocioService;
import app.controller.campo.CampoService;
import app.dao.AlquilerDAO;
import app.dao.DAOExcepcion;
import app.model.Alquiler;
import app.model.Campo;
import app.model.Socio;
import app.utiles.utiles;
import java.sql.Date;



import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlquilerService {
  public static void main(String[] args) {
        
     
        Alquiler alquiler = new Alquiler();
        alquiler.setHoraInicio("09:50:00");
        alquiler.setHoraFin("11:00:00");
        alquiler.setFecha(utiles.stringToDate("11/05/2013"));
        
        alquiler.setServicios("Solicitud de canchita de fulbito");
        alquiler.setEstado(1);
        Socio socio = new Socio();
        socio.setId(1);
        alquiler.setSocio(socio);
        Campo campo = new Campo();
        campo.setId(9);
        alquiler.setCampo(campo);
        

        AlquilerService alquilerService = new AlquilerService();
        try {
            alquilerService.save(alquiler);
        } catch (DAOExcepcion ex) {
            Logger.getLogger(CampoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private AlquilerDAO alquilerDAO = null;
    
    public AlquilerService(){
        alquilerDAO = new AlquilerDAO();
    }
    
    public List<Alquiler> list() throws DAOExcepcion {
        return alquilerDAO.list();
    }

    public Alquiler get(Alquiler alquiler) throws DAOExcepcion {
        return alquilerDAO.get(alquiler);
    }

    public Alquiler save(Alquiler alquiler) throws DAOExcepcion {
        return alquilerDAO.save(alquiler);
    }
    
    public Alquiler update(Alquiler alquiler) throws DAOExcepcion {
        return alquilerDAO.update(alquiler);
    }
    
    public void delete(Alquiler alquiler) throws DAOExcepcion {
        alquilerDAO.delete(alquiler);
    }
      
}
