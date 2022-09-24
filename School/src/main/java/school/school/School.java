/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school.school;
import java.sql.*;
import java.util.ArrayList; // import the ArrayList class
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amr23
 */
public class School {
    
    static Connection con = null;
    static Statement s;
    public static void main(String[]args)
   {
        // Showing the school main menu window
        new SchoolGUI().setVisible(true);
        try  
        { 
            // Connecting to the database
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Amr Ahmed's connection info
//            con = DriverManager.getConnection("jdbc:sqlserver://AMR-AHMED:1433;instance=Amr-Ahmed;databaseName=School;encrypt=true;trustServerCertificate=true;","sa","1234");
            // Ali Hashish's connection info
            con = DriverManager.getConnection("jdbc:sqlserver://CS-MOA-HOMEOFFI\\SQLEXPRESS:62600;instance=CS-MOA-HOMEOFFI\\SQLEXPRESS;databaseName=School;encrypt=true;trustServerCertificate=true;","sa","1234");
            s = con.createStatement();
            System.out.println("Connection established successfully");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
       
   }
}

//
//class TableFilling {
//    // Overloading the function with empty strings to avoid the where clause
//    public void Table_Data_Filling(JTable a)
//    {
//        Table_Data_Filling(a, "");
//    }
//
//    public void Table_Data_Filling(JTable a, String str)
//    {
//        // Removing top empty rows from the table
//        DefaultTableModel dtm = (DefaultTableModel) a.getModel();
//        dtm.setRowCount(0);
//        try {
//            // Executing the query and filling the table
//            ResultSet rs = School.s.executeQuery("Select * from "+ this.getClass().getSimpleName() + str);
//            // The function will behave differntly according to the class calling it
//            ResultSetMetaData rsmd = rs.getMetaData();
//            DefaultTableModel model = (DefaultTableModel) a.getModel();
//            int cols = rsmd.getColumnCount();
//            String[] colName = new String [cols];
//            for(int i=0; i<cols; i++)
//            {
//                colName[i] = rsmd.getColumnName(i+1);
//            }
//            model.setColumnIdentifiers(colName);
//            String name, grade, ID, CourseID;
//            while(rs.next()) {
//                ID=rs.getString(1);
//                name=rs.getString(2);
//                try {   // in case of Course table, this will exceed the column index limit
//                    grade=rs.getString(3);
//                    CourseID=rs.getString(4);
//                    String[] row= {ID, name, grade,CourseID};
//                    model.addRow(row); // adding a row to the table
//                }
//                catch (Exception e)
//                {
//                    String[] row= {ID, name};
//                    model.addRow(row); // adding a row to the table
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CoursesGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//}