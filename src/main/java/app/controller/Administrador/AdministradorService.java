/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller.Administrador;

import app.dao.AdministradorDAO;

import app.dao.DAOExcepcion;
import app.model.Administrador;
import java.util.List;

/**
 *
 * @author jvargas
 */
public class AdministradorService {
        private AdministradorDAO administradorDAO = null;
    
    public AdministradorService(){
        administradorDAO = new AdministradorDAO();
    }
    
    public List<Administrador> list() throws DAOExcepcion {
        return administradorDAO.list();
    }

    public Administrador get(Administrador administrador) throws DAOExcepcion {
        return administradorDAO.get(administrador);
    }

    public Administrador save(Administrador administrador) throws DAOExcepcion {
        return administradorDAO.save(administrador);
    }
    
    public Administrador update(Administrador administrador) throws DAOExcepcion {
        return administradorDAO.update(administrador);
    }
    
    public void delete(Administrador administrador) throws DAOExcepcion {
        administradorDAO.delete(administrador);
    }
}
