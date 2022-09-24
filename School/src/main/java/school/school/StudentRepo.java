/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school.school;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class StudentRepo {
    // Function to add student
    public void AddStudent(Student STD)
    {
        try {
            int count =  School.s.executeUpdate("insert into Student values ("+ STD.getID() +",'"+STD.getName()+"','"+STD.getAddress() +"','"+STD.getNumber()+"'," +STD.getAge()+ "," + STD.getFees()+")");
            // The query that adds a student to the School database
        } catch (Exception ex) {
            // n3ml function tsha8al el button b resala
            new StudentGUI().ShowMessage("Error has occured, please make sure all the data entered is correct");
        }
        // n3ml function temla el table
//        Table_Data_Filling(STD_DataTable);  // Showing the table after modification
    }

    // Function to edit student grade
    public void EditStudent(Student STD)
    {
        try {
            if (!STD.getName().isEmpty())   // updates student name
            {
                System.out.println("name");
                int count =  School.s.executeUpdate("Update Student Set StudentName = '"+STD.getName()+"' Where ID = "+ STD.getID());
            }
            
            if (!STD.getAddress().isEmpty())   // updates student address
            {
                System.out.println("address");
                int count =  School.s.executeUpdate("Update Student Set StudentAddress= '"+STD.getAddress()+"' Where ID = "+ STD.getID());
            }
            
            if (!STD.getNumber().isEmpty())   // updates student number
            {
                System.out.println("number");
                int count =  School.s.executeUpdate("Update Student Set PhoneNumber = '"+STD.getNumber()+"' Where ID = "+ STD.getID());
            }
            
            if (STD.getAge() != -1)   // updates student age
            {
                int count =  School.s.executeUpdate("Update Student Set Age = "+String.valueOf(STD.getAge())+" Where ID = "+ STD.getID());
            }
            
            if (STD.getFees() != -1)   // updates student fess
            {
                int count =  School.s.executeUpdate("Update Student Set Fees = "+String.valueOf(STD.getFees())+" Where ID = "+ STD.getID());
            }
        } catch (Exception ex) {
            new StudentGUI().ShowMessage("Error has occured, please make sure all the data entered is correct");
        }
//            Table_Data_Filling(STD_DataTable);  // Showing the table after modification
    }

    // Function to delete student
    public void DeleteStudent(Student STD)
    {
        try {
            int count =  School.s.executeUpdate("Delete From Student Where ID = "+ STD.getID());
            // The query that deletes a student from the database
        } catch (Exception ex) {
            new StudentGUI().ShowMessage(ex.getMessage());
//            new StudentGUI().ShowMessage("Error has occured, please make sure all the data entered is correct");
        }
//            Table_Data_Filling(STD_DataTable);  // Showing the table after modification
    }

    public ResultSet ShowTable(String str)
    {
        try
        {
            return School.s.executeQuery("Select * from Student " + str);
        }
        catch (Exception e)
        {
            new StudentGUI().ShowMessage(e.getMessage());
            return null;
        }
    }
}
