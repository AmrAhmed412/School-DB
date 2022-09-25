/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school.school;

import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class TeacherCourseService {
    
    
    
     public void Enroll(Teacher T, Course CRS)
    {
        try {
            int count =  School.s.executeUpdate("insert into TeacherCourse values ("+ T.getID() +","+CRS.getID()+")");
            // The query that adds a student to the School database
        } catch (Exception ex) {
            // n3ml function tsha8al el button b resala

            new TeacherGUI().ShowMessage(ex.getMessage());
        }
    }
    
    public void Drop(Teacher T, Course CRS)
    {
        try{
            int count =  School.s.executeUpdate("Delete From TeacherCourse Where TeacherID = "+ T.getID() + " AND CourseID = " + CRS.getID());
        } catch (Exception ex) {
            new TeacherGUI().ShowMessage(ex.getMessage());
        }
        
    }
    public ResultSet ShowTable(String str)
    {
        try
        {
            return School.s.executeQuery("Select Teacher.ID as 'TeacherID', Course.ID as 'CourseID', Teacher.TeacherName, Course.CourseName from Teacher  INNER JOIN TeacherCourse ON Teacher.ID = TeacherCourse.TeacherID INNER JOIN Course ON TeacherCourse.CourseID = Course.ID " + str);
        }
        catch (Exception e)
        {
            new StudentGUI().ShowMessage(e.getMessage());
            return null;
        }
    }
}

