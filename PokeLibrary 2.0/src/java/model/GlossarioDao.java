/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class GlossarioDao implements InterfaceGlossarioDao {
    @Override
    public ArrayList<Glossario> getDados() {
        ArrayList<Glossario> glossario = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
//
//        try {
//            JDBCconectionSingleton jdbc=JDBCconectionSingleton.getInstance();
//            conn = jdbc.getConnection();
//            stmt = conn.createStatement();
//            String str = "select * from Glossario";
//            ResultSet set = stmt.executeQuery(str);
//            while (set.next()) {
//                String verbete = set.getString("Verbete");
//                String descricaoVerbete = set.getString("Descricao_verbete");
//                int id_usuario = set.getInt("id_usuario");
//                int id_glossario = set.getInt("id_glossario");
//                Glossario auxGlossario = new Glossario(id_glossario, verbete, descricaoVerbete, id_usuario);
//                glossario.add(auxGlossario);
//            }
//
//        } catch (SQLException ex) {
//
//            ex.printStackTrace();
//    }
        return glossario;
    }
}
