package app.controller.campo;

import app.dao.CampoDAO;
import app.dao.DAOExcepcion;
import app.dao.CampoDAO;
import app.model.Campo;
import java.util.List;

public class CampoService {
    
    private CampoDAO campoDAO = null;
    
    public CampoService(){
        campoDAO = new CampoDAO();
    }
    
    public List<Campo> list() throws DAOExcepcion {
        return campoDAO.list();
    }

    public Campo get(Campo local) throws DAOExcepcion {
        return campoDAO.get(local);
    }

    public Campo save(Campo local) throws DAOExcepcion {
        return campoDAO.save(local);
    }
    
    public Campo update(Campo local) throws DAOExcepcion {
        return campoDAO.update(local);
    }
    
    public void delete(Campo local) throws DAOExcepcion {
        campoDAO.delete(local);
    }
    
}
