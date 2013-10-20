/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller.Socio;

import app.controller.campo.CampoService;
import app.dao.CampoDAO;
import app.dao.DAOExcepcion;
import app.dao.SocioDAO;
import app.model.Socio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jvargas
 */
public class SocioService {
    
    public static void main(String[] args) {
        
        Socio socio = new Socio();
        socio.setCelular(997391564);
        socio.setDireccion("Av.Candada 1146");
        socio.setMaterno("moreno");
        socio.setPaterno("macha");
        socio.setNombres("erika");
        socio.setEmail("lidiaj155@hotmail.com");
        socio.setSexo(1);
        SocioService socioService = new SocioService();
        try {
            socioService.save(socio);
        } catch (DAOExcepcion ex) {
            Logger.getLogger(CampoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private SocioDAO socioDAO = null;
    
    public SocioService(){
        socioDAO = new SocioDAO();
    }
    
    public List<Socio> list() throws DAOExcepcion {
        return socioDAO.list();
    }

    public Socio get(Socio socio) throws DAOExcepcion {
        return socioDAO.get(socio);
    }

    public Socio save(Socio socio) throws DAOExcepcion {
        return socioDAO.save(socio);
    }
    
    public Socio update(Socio socio) throws DAOExcepcion {
        return socioDAO.update(socio);
    }
    
    public void delete(Socio socio) throws DAOExcepcion {
        socioDAO.delete(socio);
    }
    
}
