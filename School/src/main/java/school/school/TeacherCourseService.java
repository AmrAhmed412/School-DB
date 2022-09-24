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

