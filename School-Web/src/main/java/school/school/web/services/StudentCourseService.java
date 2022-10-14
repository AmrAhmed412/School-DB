/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school.school.web.services;

import java.sql.ResultSet;
import school.school.web.model.*;

/**
 *
 * @author User
 */

// Connects the Student Table to the Course Table
public class StudentCourseService {
    
    // Adds a Course to the student
    public void Enroll(StudentCourse STD_CRS)
    {
        try {
            int count = School.s.executeUpdate("insert into StudentCourse values ("+ STD_CRS.getStudentID() +","+STD_CRS.getCourseID()+",'"+STD_CRS.getGrade() +"')");
            // The query that adds a course to the student
        } catch (Exception ex) {
            //new StudentGUI().ShowMessage(ex.getMessage());
        }
    }
    
    // Drops a student from the Course
    public void Drop(Student STD, Course CRS)
    {
        try{
            // Query to delete a course from the student's courses
            int count =  School.s.executeUpdate("Delete From StudentCourse Where StudentID = "+ STD.getID() + " AND CourseID = " + CRS.getID());
        } catch (Exception ex) {
            //new StudentGUI().ShowMessage(ex.getMessage());
        }
    }
    
    // Edits the grade of a student
    public void EditGrade(StudentCourse STD_CRS)
    {
        try {
            int count =  School.s.executeUpdate("Update StudentCourse Set Grade = '"+ STD_CRS.getGrade() +"' Where StudentID = "+ STD_CRS.getStudentID() + " AND CourseID = " + STD_CRS.getCourseID());
            // The query that edits student's course grade
        } catch (Exception ex) {
            //new StudentGUI().ShowMessage(ex.getMessage());
        }
    }
    
    // Shows Student and Course table
    public ResultSet ShowTable(String str)
    {
        try
        {
            return School.s.executeQuery("Select Student.ID as 'StudentID', Course.ID as 'CourseID', Student.StudentName, Course.CourseName, StudentCourse.Grade  from Student  INNER JOIN StudentCourse  ON Student.ID = StudentCourse.StudentID INNER JOIN Course ON StudentCourse.CourseID = Course.ID " + str);
            // Query that shows the joined table of Student and Course
        }
        catch (Exception e)
        {
            //new StudentGUI().ShowMessage(e.getMessage());
            return null;    // in case of failure
        }
    }
}