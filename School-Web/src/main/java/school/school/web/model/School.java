/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school.school.web.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class School {
    
    static Connection con = null;
    public static Statement s;
    public static void main(String[]args)
    {
       innit();
    }
    
    public static void innit()
    {
        try  
        { 
            // Connecting to the database
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // Amr Ahmed's connection info
            con = DriverManager.getConnection("jdbc:sqlserver://AMR-AHMED:1433;instance=Amr-Ahmed;databaseName=School;encrypt=true;trustServerCertificate=true;","sa","1234");
            
            // Ali Hashish's connection info
//            con = DriverManager.getConnection("jdbc:sqlserver://CS-MOA-HOMEOFFI\\SQLEXPRESS:62600;instance=CS-MOA-HOMEOFFI\\SQLEXPRESS;databaseName=School;encrypt=true;trustServerCertificate=true;","sa","1234");

            s = con.createStatement();
            System.out.println("Connection established successfully");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}