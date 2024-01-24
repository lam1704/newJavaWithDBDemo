/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Human;
import model.HumanType;

public class DBContext {

    Connection connection;

    public DBContext() {
        try {
            String user = "sa";
            String pass = "sa";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Human";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Human> getHumans() {
        ArrayList<Human> humans = new ArrayList<>();
        try {
            String sql = "SELECT h.humanid,h.humanname,h.humandob,h.humangender,ht.typeid,ht.typename " + "FROM Human h INNER JOIN HumanTYPE ht ON h.typeid= ht.typeid";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Human h = new Human();
                h.setID(rs.getInt("humanid"));
                h.setName(rs.getString("humanname"));
                h.setDob(rs.getDate("humandob"));
                h.setGender(rs.getBoolean("humangender"));

                HumanType ht = new HumanType();
                ht.setTypeID(rs.getInt("typeid"));
                ht.setName(rs.getString("typename"));
                h.setType(ht);
                humans.add(h);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return humans;
    }

    public ArrayList<HumanType> getTypes() {
        ArrayList<HumanType> types = new ArrayList<>();
        try {
            String sql = "SELECT [typeid],[typename] FROM[HumanType]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                HumanType ht = new HumanType();
                ht.setTypeID(rs.getInt("typeid"));
                ht.setName(rs.getString("typename"));
                types.add(ht);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return types;
    }

  /*  public static void main(String[] arg) {
        DBContext db = new DBContext();
        ArrayList<Human> lst = db.getHumans();
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i).getType());
        }
    }*/
}
