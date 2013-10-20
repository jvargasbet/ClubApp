package app.dao;

import app.model.Alquiler;
import app.zelper.ConexionDB;
import app.zelper.Helper;
import java.sql.Connection;
import java.sql.Date;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AlquilerDAO extends BaseDAO {

    public List<Alquiler> list() throws DAOExcepcion {
        List<Alquiler> lista = new ArrayList<Alquiler>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionDB.obtenerConexion();
            String query = "select * from Alquiler order by id;";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Alquiler item = new Alquiler();
                item.setId(rs.getInt("id"));
                item.setHoraInicio(rs.getString("hora_inicio"));
                item.setHoraFin(rs.getString("hora_fin"));
                item.setFecha(rs.getDate("dia"));
                item.setServicios(rs.getString("servicios"));
                item.setEstado(rs.getInt("estado"));
                //item.setSocio(rs.getString("Id_socio"));
                //item.setCampo(rs.getInt("id_campo"));

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

    public Alquiler get(Alquiler alquiler)
            throws DAOExcepcion {
        String query = "select * from socio where id = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alquiler item = new Alquiler();
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setLong(1, alquiler.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                item.setId(rs.getInt("id"));
                item.setHoraInicio(rs.getString("hora_inicio"));
                item.setHoraFin(rs.getString("hora_fin"));
                item.setFecha(rs.getDate("dia"));
                item.setServicios(rs.getString("servicios"));
                item.setEstado(rs.getInt("estado"));
                //item.setSocio(rs.getString("Id_socio"));
                //item.setCampo(rs.getInt("id_campo"));
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

    public Alquiler save(Alquiler alquiler) throws DAOExcepcion {
        String query = "INSERT INTO solicitud_alquiler(hora_inicio, hora_fin, dia, servicios, estado, id_socio, id_campo) VALUES(?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, alquiler.getHoraInicio());
            stmt.setString(2, alquiler.getHoraFin());
            //Pregunta profesor
            stmt.setDate(3, Helper.getSQLDate(alquiler.getFecha()));
            stmt.setString(4, alquiler.getServicios());
            stmt.setInt(5, alquiler.getEstado());
            stmt.setLong(6, alquiler.getSocio().getId());
            stmt.setLong(7, alquiler.getCampo().getId());
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
            alquiler.setId(id);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return alquiler;
    }

    public Alquiler update(Alquiler alquiler) throws DAOExcepcion {
        String query = "UPDATE solicitud_alquiler SET hora_inicio= ?, hora_fin = ?, dia = ?, servicios = ?, estado = ?, id_socio = ?, id_campo = ?  WHERE id = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, alquiler.getHoraInicio());
            stmt.setString(2, alquiler.getHoraFin());
            //Pregunta profesor
            stmt.setDate(3,  new Date(alquiler.getFecha().getTime()));
            stmt.setString(4, alquiler.getServicios());
            stmt.setInt(5, alquiler.getEstado());
            stmt.setLong(6, alquiler.getSocio().getId());
            stmt.setLong(7, alquiler.getCampo().getId());
            stmt.setLong(8, alquiler.getId());

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
        return alquiler;
    }

    public void delete(Alquiler alquiler) throws DAOExcepcion {
        String query = "delete from solicitud_alquiler WHERE id=?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setLong(1, alquiler.getId());
            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo eliminar la solicitud de alquiler");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
    }
}
