/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kontaktlisa;
//impotering

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jahar
 */
// connetion objekt håller kopplingen till databasen öppet och ett konstruktor körs när vi skriver som gör att ansluttnigen till databasen in
public class DBManager {

    private Connection conn = null;

    /**
     * Constructor for database class. This class handels database connection
     * and querys
     *
     */
    public DBManager() {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "kontaktlista";
        String userName = "kontaktlista";
        String password = "kontaktlista";
// Laddar drivrutinen för MySQL och skapar anslutingen 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Ansluten");
        } catch (SQLException e) {
            System.out.println("pap " + e.getMessage() + " " + e.getSQLState());
            if (conn == null) {
                System.out.println("Ingen anslutning");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ap " + e.getMessage());
        }
    }

    /**
     * Inserting a new contact in tha database
     *
     * @param kontakt is the new contact to be inserted to the databse.
     * @return non zero value on succsessfull insert, zero value on none
     * succsessful insert.
     */
    public int insert(Kontakt kontakt) {
        int res = 0;

        // Check for active connection, not written yet
        //if (connected()) {
        try {
            String sql = "insert into kontakt(firstname,lastname,phonenumber)"
                    + " VALUES (?, ?,?)";
            PreparedStatement stmt
                    = conn.prepareStatement(sql);

            // Set Parameters
            stmt.setString(1, kontakt.getFörnamn());
            stmt.setString(2, kontakt.getEfternamn());
            stmt.setString(3, kontakt.getTelefonnummer());

            // Execute SQL query
            res = stmt.executeUpdate();
            System.out.println(res + " record inserted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //}
        return res;
    }
/**
     * Raderar en kontakt baserat på dess ID-nummer.
     * id Siffran som användaren skrivit in i programmet.
     */
    public int delete(int id) {
        int res = 0;
        try {
            String sql = "DELETE FROM kontakt WHERE kontaktid = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Sätt ID:t i SQL-frågan
            stmt.setInt(1, id);

            // Kör raderingen
            res = stmt.executeUpdate();
            System.out.println(res + " kontakt raderad");
        } catch (SQLException e) {
            System.out.println("Fel vid radering: " + e.getMessage());
        }
        return res;
    }

    /**
     * Metod for retriveing all the records in the database
     *
     * @return ResultSet object whith all records orders by id
     */
    public ResultSet getAllData() {
        ResultSet rs = null;
        // Check for active connection, not written yet
        //if (connected()) {
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM kontakt order by kontaktid");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " Error!");
        }
        //}
        return rs;
    }
}
