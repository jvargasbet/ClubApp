
package app.dao;


import app.model.Administrador;
import app.zelper.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAO extends BaseDAO{
     public List<Administrador> list() throws DAOExcepcion {
        List<Administrador> lista = new ArrayList<Administrador>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionDB.obtenerConexion();
            String query = "select * from general;";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Administrador item = new Administrador();
                item.setId(rs.getInt("id"));
                item.setUsuario(rs.getString("descripcion"));
                item.setPassword(rs.getString("costo_hora"));
                lista.add(item);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return lista;
    }

    public Administrador get(Administrador administrador)
            throws DAOExcepcion {
        String query = "select * from general where id = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       Administrador admi = new Administrador();
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setLong(1,administrador.getId());
            rs = stmt.executeQuery();
               
            while (rs.next()) {
                admi.setId(rs.getInt("id"));
                admi.setUsuario(rs.getString("usuario"));
                admi.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
              System.err.println(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return admi;
    }

    public Administrador save(Administrador administrador) throws DAOExcepcion {
        String query = "insert into general(id, usuario, PASSWORD) VALUES(?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);

            stmt.setString(1, administrador.getUsuario());
            stmt.setString(2, administrador.getPassword());
            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo insertar");
            }
            int id = 0;
            query = "select last_insert_id()";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            administrador.setId(id);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return administrador;
    }
    
     public Administrador update(Administrador administrador) throws DAOExcepcion {
        String query = "update general usuario=?,password=? where id=?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
             stmt.setString(1, administrador.getUsuario());
            stmt.setString(2, administrador.getPassword());
            stmt.setLong(3, administrador.getId());
            
            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo actualizar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return administrador;
    }

    public void delete(Administrador administrador) throws DAOExcepcion {
        String query = "delete from general WHERE id=?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setLong(1, administrador.getId());
            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo eliminar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
    }

}
