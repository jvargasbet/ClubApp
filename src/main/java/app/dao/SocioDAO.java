/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;


import app.model.Socio;
import app.zelper.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jvargas
 */
public class SocioDAO extends BaseDAO{
   
    public List<Socio> list() throws DAOExcepcion {
        List<Socio> lista = new ArrayList<Socio>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionDB.obtenerConexion();
            String query = "select * from Socio order by paterno;";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Socio item = new Socio();
                item.setId(rs.getInt("id"));
                item.setPaterno(rs.getString("paterno"));
                item.setMaterno(rs.getString("materno"));
                item.setNombres(rs.getString("nombres"));
                item.setDireccion(rs.getString("direccion"));
                item.setCelular(rs.getInt("celular"));
                item.setEmail(rs.getString("email"));
                item.setSexo(rs.getInt("sexo"));
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

    public Socio get(Socio socio)
            throws DAOExcepcion {
        String query = "select * from socio where id = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Socio item = new Socio();
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setLong(1, socio.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                item.setId(rs.getInt("id"));
                item.setPaterno(rs.getString("paterno"));
                item.setMaterno(rs.getString("materno"));
                item.setNombres(rs.getString("nombres"));
                item.setDireccion(rs.getString("direccion"));
                item.setCelular(rs.getInt("celular"));
                item.setEmail(rs.getString("email"));
                item.setSexo(rs.getInt("sexo"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return item;
    }

    public Socio save(Socio local) throws DAOExcepcion {
        String query = "insert into socio(email, nombres, paterno, materno, celular, sexo, direccion) values (?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, local.getEmail());
            stmt.setString(2, local.getNombres());
            stmt.setString(3, local.getPaterno());
            stmt.setString(4, local.getMaterno());
            stmt.setInt(5, local.getCelular());
            stmt.setInt(6, local.getSexo());
            stmt.setString(7, local.getDireccion());
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
            local.setId(id);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return local;
    }

    public Socio update(Socio socio) throws DAOExcepcion {
        String query = "update socio set email=?,nombres=?,paterno=?, materno=?,celular=?,sexo=?, direccion=? where id=?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, socio.getEmail());
            stmt.setString(2, socio.getNombres());
            stmt.setString(3, socio.getPaterno());
            stmt.setString(4, socio.getMaterno());
            stmt.setInt(5, socio.getCelular());
            stmt.setInt(6, socio.getSexo());
            stmt.setString(7, socio.getDireccion());
            stmt.setLong(8, socio.getId());

            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo actualizar el socio");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return socio;
    }

    public void delete(Socio socio) throws DAOExcepcion {
        String query = "delete from socio WHERE id=?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setLong(1, socio.getId());
            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo eliminar el socio");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
    }
 
}
