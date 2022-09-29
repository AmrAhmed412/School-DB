/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import school.school.School;
import school.school.Student;
import school.school.StudentGUI;

/**
 *
 * @author User
 */

// Handles the function of the Student table
public class StudentRepo {
    
    // Function to add student
    public void AddStudent(Student STD)
    {
        try {
            int count =  School.s.executeUpdate("insert into Student values ("+ STD.getID() +",'"+STD.getName()+"','"+STD.getAddress() +"','"+STD.getNumber()+"'," +STD.getAge()+ "," + STD.getFees()+")");
            // The query that adds a student to the School database
        } catch (Exception ex) {
            new StudentGUI().ShowMessage(ex.getMessage());
        }
    }

    // Function to edit student grade
    public void EditStudent(Student STD)
    {
        try 
        {
            if (!STD.getName().isEmpty())   // updates student name if it's not empty
            {
                
                int count =  School.s.executeUpdate("Update Student Set StudentName = '"+STD.getName()+"' Where ID = "+ STD.getID());
            }
            
            if (!STD.getAddress().isEmpty())   // updates student address if it's not empty
            {
                
                int count =  School.s.executeUpdate("Update Student Set StudentAddress= '"+STD.getAddress()+"' Where ID = "+ STD.getID());
            }
            
            if (!STD.getNumber().isEmpty())   // updates student number if it's not empty
            {
                
                int count =  School.s.executeUpdate("Update Student Set PhoneNumber = '"+STD.getNumber()+"' Where ID = "+ STD.getID());
            }
            
            if (STD.getAge() != -1)   // updates student age if it's not -1
            {
                int count =  School.s.executeUpdate("Update Student Set Age = "+String.valueOf(STD.getAge())+" Where ID = "+ STD.getID());
            }
            
            if (STD.getFees() != -1)   // updates student fess if it's not -1
            {
                int count =  School.s.executeUpdate("Update Student Set Fees = "+String.valueOf(STD.getFees())+" Where ID = "+ STD.getID());
            }
        } catch (Exception ex) {
            new StudentGUI().ShowMessage(ex.getMessage());
        }
    }

    // Function to delete student
    public void DeleteStudent(Student STD)
    {
        try {
            int count =  School.s.executeUpdate("Delete From Student Where ID = "+ STD.getID());
            // The query that deletes a student from the database
        } catch (Exception ex) {
            new StudentGUI().ShowMessage(ex.getMessage());
        }
    }

    // Shows the Student table
    public ResultSet ShowTable(String str)
    {
        try
        {
            return School.s.executeQuery("Select * from Student " + str);
            // Query to show student table
        }
        catch (Exception e)
        {
            new StudentGUI().ShowMessage(e.getMessage());
            return null;        // in case of failure
        }
    }
}
