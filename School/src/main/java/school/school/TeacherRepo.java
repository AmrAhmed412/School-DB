/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school.school;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class TeacherRepo {
    public void AddTeacher(Teacher T) 
    {
        try { 
            int count = School.s.executeUpdate("insert into Teacher values ("+ T.getID() +",'"+T.getName()+"','"+T.getAddress()+"','"+T.getNumber()+"',"+T.getSalary()+","+T.getExperienceYears()+")");
        } catch (Exception ex) {
           new TeacherGUI().ShowMessage(ex.getMessage());
        }
    }
    public void EditTeacher(Teacher T)
    {
          try {
            if (!T.getName().isEmpty())   // updates student name
            {
               
                int count =  School.s.executeUpdate("Update Teacher Set TeacherName = '"+T.getName()+"' Where ID = "+ T.getID());
            }
            
            if (!T.getAddress().isEmpty())   // updates student address
            {
             
                int count =  School.s.executeUpdate("Update Teacher Set TeacherAddress= '"+T.getAddress()+"' Where ID = "+ T.getID());
            }
            
            if (!T.getNumber().isEmpty())   // updates student number
            {
                int count =  School.s.executeUpdate("Update Teacher Set PhoneNumber = '"+T.getNumber()+"' Where ID = "+ T.getID());
            }
            
            if (T.getSalary() != -1)   // updates Teacher Salary
            {
                int count =  School.s.executeUpdate("Update Teacher Set Salary = "+String.valueOf(T.getSalary())+" Where ID = "+ T.getID());
            }
            
            if (T.getExperienceYears() != -1)   // updates Teacher Experience
            {
                int count =  School.s.executeUpdate("Update Teacher Set Experience = "+String.valueOf(T.getExperienceYears())+" Where ID = "+ T.getID());
            }
        } catch (Exception ex) {
            new TeacherGUI().ShowMessage(ex.getMessage());
        }
          
    }
    public void DeleteTeacher(Teacher T)
    {
        try
        {
            int count =  School.s.executeUpdate("Delete From Teacher Where ID = "+ T.getID());
        }
        catch (Exception e)
        {
            new TeacherGUI().ShowMessage("Error has occured, please make sure all the data entered is correct"); 
        }
    }
    public ResultSet ShowTable(String str)
    {
        try
        {
            return School.s.executeQuery("Select * from Teacher " + str);
        }
        catch (Exception e)
        {
            new TeacherGUI().ShowMessage(e.getMessage());
            return null;
        }
    }
}
