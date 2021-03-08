package ui;

import org.postgresql.jdbc.PgResultSet;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class Program
{
    static String url = "jdbc:postgresql://localhost:5432/vet";
    static Properties props = new Properties();

    public static void main(String[] args) throws SQLException
    {
        props.setProperty("user", "test");
        props.setProperty("password", "test");

        try (Connection conn = DriverManager.getConnection(url, props))
        {
            addDog(conn, "Arne", 125, "88888888", "B2");
            addCat(conn, "Arne", 125, "77777777", 17);
            addPet(conn, "Nanok", 57, "88888888");
            String sql = "SELECT * FROM all_pets;";
            PreparedStatement statement = conn.prepareStatement(sql);
            try (ResultSet result = statement.executeQuery())
            {
                while (result.next())
                {
                    System.out.println(toString(result));//result.toString());
                    //System.out.println("" + result.getInt(1) + " " + result.getString(2));
                }
            }
        }
    }
    
    public static void addDog(Connection conn, String name, int age, String vetCvr, String barkPitch) throws SQLException
    {
        PreparedStatement stmt = conn.prepareStatement("CALL create_dog(?,?,?,?)");
        stmt.setString(1, name);
        stmt.setInt(2, age);
        stmt.setString(3, vetCvr);
        stmt.setString(4, barkPitch);
        stmt.execute();
    }

    public static void addCat(Connection conn, String name, int age, String vetCvr, int lifeCount) throws SQLException
    {
        PreparedStatement stmt = conn.prepareStatement("CALL create_cat(?,?,?,?)");
        stmt.setString(1, name);
        stmt.setInt(2, age);
        stmt.setString(3, vetCvr);
        stmt.setInt(4, lifeCount);
        stmt.execute();
    }

    public static void addPet(Connection conn, String name, int age, String vetCvr) throws SQLException
    {
        PreparedStatement stmt = conn.prepareStatement("CALL create_pet(?,?,?)");
        stmt.setString(1, name);
        stmt.setInt(2, age);
        stmt.setString(3, vetCvr);

        stmt.execute();
    }
    
    public static String toString(ResultSet p) throws SQLException
    {
        StringJoiner sb = new StringJoiner(" ");
        sb.add(p.getInt("id") + "");
        sb.add(p.getString("name"));
        sb.add(p.getInt("age") + "");
        sb.add(p.getString("vet_cvr"));
        String barkpitch = p.getString("bark_pitch");
        int lifecount = p.getInt("lifecount");
        sb.add(barkpitch == null ? (lifecount == 0 ? "PET" : "CAT") : "DOG");
        return sb.toString();
    }
}
