/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school.school.web.repo;

import java.sql.ResultSet;
import school.school.web.model.*;

/**
 *
 * @author User
 */

// Handles the functions of the Course Table
public class CourseRepo {
    
    // Function to add Courses
    public void AddCourse(Course CRS)
    {
        try {
            int count =  School.s.executeUpdate("insert into Course values ("+ CRS.getID() +",'"+CRS.getName()+"')");
            // The query that adds a Course to the School database
        } catch (Exception ex) {
            //new CoursesGUI().ShowMessage(ex.getMessage());
        }
    }

    // Function to edit Course name
    public void EditCourse(Course CRS)
    {
        try {
            int count =  School.s.executeUpdate("Update Course Set CourseName = '"+CRS.getName()+"' Where ID = "+ CRS.getID());
            // The query that edits a Course's name
        } catch (Exception ex) {
           //new CoursesGUI().ShowMessage(ex.getMessage());
        }
    }

    // Function to delete Course
    public void DeleteCourse(Course CRS)
    {
        try {
            int count =  School.s.executeUpdate("Delete From Course Where ID = "+ CRS.getID());
            // The query that deletes a Course from the database
        } catch (Exception ex) {
            //new CoursesGUI().ShowMessage(ex.getMessage());
        }
    }
    
    // Function to show Course table
    public ResultSet ShowTable(String str)
    {
        try
        {
            return School.s.executeQuery("Select * from Course " + str);
            // Query that shows Course table
        }
        catch (Exception e)
        {
            //new CoursesGUI().ShowMessage(e.getMessage());
            return null;    // in case of failure
        }
    }
}
