/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school.school.web.model;

public class StudentCourse {
    int StudentID;
    int CourseID;
    String Grade;
    
    public StudentCourse() {}
    public StudentCourse(int StudentID, int CourseID, String Grade)
    {
        setStudentID(StudentID);
        setCourseID(CourseID);
        setGrade(Grade);
    }
    
    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        if(StudentID < 1)
            StudentID = 1;   // Then Database rejects it if it's not unique
        this.StudentID = StudentID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        if(CourseID < 1)
            CourseID = 1;   // Then Database rejects it if it's not unique
        this.CourseID = CourseID;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String Grade) {
        if(Grade.compareToIgnoreCase("A") < 0 || Grade.compareToIgnoreCase("F") > 0 || Grade.compareToIgnoreCase("E") == 0)
            Grade = "U";
        this.Grade = Grade.toUpperCase();
    }
}
