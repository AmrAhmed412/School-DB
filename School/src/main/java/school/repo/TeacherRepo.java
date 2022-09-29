/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import school.school.School;
import school.school.Teacher;
import school.school.TeacherGUI;

/**
 *
 * @author User
 */


// Handles the function of the Teacher table
public class TeacherRepo {
    
    // Adds teacher to DB
    public void AddTeacher(Teacher T) 
    {
        try {
            int count = School.s.executeUpdate("insert into Teacher values ("+ T.getID() +",'"+T.getName()+"','"+T.getAddress()+"','"+T.getNumber()+"',"+T.getSalary()+","+T.getExperienceYears()+")");
            // Adds teacher to DB
        } catch (Exception ex) {
           new TeacherGUI().ShowMessage(ex.getMessage());
        }
    }
    
    // Edits Teacher info
    public void EditTeacher(Teacher T)
    {
          try {
            if (!T.getName().isEmpty())   // updates student name if it's not empty
            {
               
                int count =  School.s.executeUpdate("Update Teacher Set TeacherName = '"+T.getName()+"' Where ID = "+ T.getID());
            }
            
            if (!T.getAddress().isEmpty())   // updates student address if it's not empty
            {
             
                int count =  School.s.executeUpdate("Update Teacher Set TeacherAddress= '"+T.getAddress()+"' Where ID = "+ T.getID());
            }
            
            if (!T.getNumber().isEmpty())   // updates student number if it's not empty
            {
                int count =  School.s.executeUpdate("Update Teacher Set PhoneNumber = '"+T.getNumber()+"' Where ID = "+ T.getID());
            }
            
            if (T.getSalary() != -1)   // updates Teacher Salary if it's not -1
            {
                int count =  School.s.executeUpdate("Update Teacher Set Salary = "+String.valueOf(T.getSalary())+" Where ID = "+ T.getID());
            }
            
            if (T.getExperienceYears() != -1)   // updates Teacher Experience if it's not -1
            {
                int count =  School.s.executeUpdate("Update Teacher Set Experience = "+String.valueOf(T.getExperienceYears())+" Where ID = "+ T.getID());
            }
        } catch (Exception ex) {
            new TeacherGUI().ShowMessage(ex.getMessage());
        }
          
    }
    
    // Deletes Teacher from DB
    public void DeleteTeacher(Teacher T)
    {
        try
        {
            int count =  School.s.executeUpdate("Delete From Teacher Where ID = "+ T.getID());
            // Query to delete teacher
        }
        catch (Exception e)
        {
            new TeacherGUI().ShowMessage(e.getMessage()); 
        }
    }
    
    // Shows Teacher table
    public ResultSet ShowTable(String str)
    {
        try
        {
            return School.s.executeQuery("Select * from Teacher " + str);
            // Query to show Teacher table
        }
        catch (Exception e)
        {
            new TeacherGUI().ShowMessage(e.getMessage());
            return null;        // in case of failure
        }
    }
}
