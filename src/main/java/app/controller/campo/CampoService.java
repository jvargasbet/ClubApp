package app.controller.campo;

import app.dao.CampoDAO;
import app.dao.DAOExcepcion;
import app.dao.CampoDAO;
import app.model.Campo;
import app.model.Local;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CampoService {
    
    
    public static void main(String[] args) {
        
        Campo campo = new Campo();
        campo.setDescripcion("Mejorando la cancha");
        campo.setEstado(1);
        campo.setCostoHora(2d);
        campo.setTipo(1);
        campo.setLocal(null);
        Local local = new Local();
        local.setId(1);
        campo.setLocal(local);
        CampoService campoService =  new CampoService();
        try {
            campoService.save(campo);
        } catch (DAOExcepcion ex) {
            Logger.getLogger(CampoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private CampoDAO campoDAO = null;
    
    public CampoService(){
        campoDAO = new CampoDAO();
    }
    
    public List<Campo> list() throws DAOExcepcion {
        return campoDAO.list();
    }

    public Campo get(Campo campo) throws DAOExcepcion {
        return campoDAO.get(campo);
    }

    public Campo save(Campo campo) throws DAOExcepcion {
        return campoDAO.save(campo);
    }
    
    public Campo update(Campo campo) throws DAOExcepcion {
        return campoDAO.update(campo);
    }
    
    public void delete(Campo camppo) throws DAOExcepcion {
        campoDAO.delete(camppo);
    }
    
}
