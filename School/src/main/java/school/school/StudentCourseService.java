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
public class StudentCourseService {
    
    public void Enroll(Student STD, Course CRS, String Grade)
    {
        try {
            int count =  School.s.executeUpdate("insert into StudentCourse values ("+ STD.getID() +","+CRS.getID()+",'"+Grade +"')");
            // The query that adds a student to the School database
        } catch (Exception ex) {
            // n3ml function tsha8al el button b resala
//            new StudentGUI().ShowMessage("Error has occured, please make sure all the data entered is correct");
            new StudentGUI().ShowMessage(ex.getMessage());
        }
    }
    
    public void Drop(Student STD, Course CRS)
    {
        try{
            int count =  School.s.executeUpdate("Delete From StudentCourse Where StudentID = "+ STD.getID() + " AND CourseID = " + CRS.getID());
        } catch (Exception ex) {
            new StudentGUI().ShowMessage(ex.getMessage());
        }
        
    }
    
    public void EditGrade(Student STD, Course CRS, String Grade)
    {
        try {
            int count =  School.s.executeUpdate("Update StudentCourse Set Grade = '"+ Grade +"' Where StudentID = "+ STD.getID() + " AND CourseID = " + CRS.getID());
            // The query that adds a student to the School database
        } catch (Exception ex) {
            // n3ml function tsha8al el button b resala
//            new StudentGUI().ShowMessage("Error has occured, please make sure all the data entered is correct");
            new StudentGUI().ShowMessage(ex.getMessage());
        }
    }
    
    public ResultSet ShowTable(String str)
    {
        try
        {
            return School.s.executeQuery("Select Student.ID as 'StudentID', Course.ID as 'CourseID', Student.StudentName, Course.CourseName, StudentCourse.Grade  from Student  INNER JOIN StudentCourse  ON Student.ID = StudentCourse.StudentID INNER JOIN Course ON StudentCourse.CourseID = Course.ID " + str);
        }
        catch (Exception e)
        {
            new StudentGUI().ShowMessage(e.getMessage());
            return null;
        }
    }
}
