/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.test;

import app.dao.DAOExcepcion;
import app.dao.ServicioDAO;
import app.model.Servicio;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;


/**
 *
 * @author jvargas
 */
public class ServicioDAOTest {

    @Test
    public void obtenerTotalTest() {
        ServicioDAO dao = new ServicioDAO();
        try {        
            List<Servicio> servicio = new ArrayList<Servicio>();
            servicio = dao.list();
            for (Servicio servicio1 : servicio) {
                System.out.println("Total --> " + servicio1.getDescripcion());
            }
            
        } catch (DAOExcepcion e) {
            Assert.fail("falló");
        }
    }
}
