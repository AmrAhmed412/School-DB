/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school.school;
import java.sql.*;

/**
 *
 * @author amr23
 */
public class School {
    
     static Connection con=null;
     static Statement s;
    public static void main(String[]args)
   {
      SchoolGUI sch= new SchoolGUI();
      sch.show();
       try  { Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
              con = DriverManager.getConnection("jdbc:sqlserver://AMR-AHMED:1433;instance=Amr-Ahmed;databaseName=School;encrypt=true;trustServerCertificate=true;","sa","1234");
              s = con.createStatement();
            }
       catch(Exception ex)
       {
           System.out.println(ex);
       }
       
   }
}
