/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class TicketDao implements InterfaceTicketDao {
    @Override
    public void AdicionarTicket(int idUsuario, String DescricaoErro, String tituloErro) {
        Connection conn = null;
        PreparedStatement pstmt = null;

//        try {
//            JDBCconectionSingleton jdbc=JDBCconectionSingleton.getInstance();
//            conn = jdbc.getConnection();
//            pstmt = conn.prepareStatement("insert into Ticket (Titulo_ticket,Descricao_ticket) values (?,?)");
//            pstmt.setString(1, tituloErro);
//            pstmt.setString(2, DescricaoErro);
//            pstmt.executeUpdate();
//            //pega o ultimo id adicionado que será o id do ticket
//            String str = "SELECT LAST_INSERT_ID()";
//            ResultSet set = pstmt.executeQuery(str);
//            int idTicket = 0;
//            if (set.next()) {
//                idTicket = set.getInt(1);
//            }
//            pstmt = conn.prepareStatement("insert into Usuario_has_ticket (id_ticket,id_usuario) values (?,?)");
//            pstmt.setInt(1, idTicket);
//            pstmt.setInt(2, idUsuario);
//            pstmt.executeUpdate();
//        } catch (SQLException ex) {
//
//            ex.printStackTrace();
//        }
    }
}
