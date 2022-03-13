/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import connect.ConnectionFactory;
import domain.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author FLAVIO
 */
public class Repository {
    
    public  static  List<Client>  findByAll () {
        List<Client> clientes =  new  ArrayList<> ();
        try ( Connection conn =  ConnectionFactory . getConnection();
             PreparedStatement ps = createPrepareStatementFindByAll(conn);
             ResultSet rs = ps . executeQuery()){
            while (rs . next()) {
                Client client =  new Client
                        .ClientBuilder()
                        .id(rs.getInt("id"))
                        .nome(rs.getString("nome"))
                        .senha(rs.getString("senha"))
                        .build();
                clientes . add(client);
            }
        } catch ( SQLException e) {
            JOptionPane.showMessageDialog(null, "Error while trying to find all clients");
        }
        return clientes;
    }
   private static PreparedStatement createPrepareStatementFindByAll(Connection conn) throws SQLException {
        String sql = "SELECT * FROM clientes;";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps;
    }
    public static Client findById(Integer id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementFindById(conn, id);
             ResultSet rs = ps.executeQuery()) {
            if (!rs.next()) return null;
            return  new Client.ClientBuilder()
                    .id(rs.getInt("id"))
                    .nome(rs.getString("nome"))
                    .senha(rs.getString("senha"))
                    .idade(rs.getInt("idade"))
                    .build();                   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error while trying to find id clients");
        }
        return null;
    }
    private static PreparedStatement createPrepareStatementFindById(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM clientes where id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }
    public static void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementDelete(conn, id)) {
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error while trying to delete clients");
        }
    }
    private static PreparedStatement createPrepareStatementDelete(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM clientes WHERE `id` = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }
    public static void save(Client client) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementSave(conn, client)) {
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error while trying to save clients");           
        }
    }
    private static PreparedStatement createPrepareStatementSave(Connection conn, Client client) throws
            SQLException {
        String sql = "INSERT INTO Clientes (`nome`,`senha`, `idade`) VALUES (?, ?, ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, client.getNome());
        ps.setString(2, client.getSenha());
        ps.setInt(3, client.getIdade());
        return ps;
    }
    public static void update(Client client) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementUpdate(conn, client)) {
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error while trying to update clients");
        }
    }

    private static PreparedStatement createPrepareStatementUpdate(Connection conn, Client client) throws
            SQLException {
        String sql = "UPDATE `clientes` SET `nome` = ?, `senha` = ?, `idade` = ? WHERE `id` = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, client.getNome());
        ps.setString(2, client.getSenha());
        ps.setInt(3, client.getIdade());
        ps.setInt(4, client.getId());
        return ps;
    }
}