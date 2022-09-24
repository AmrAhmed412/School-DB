/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school.school;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Teacher extends Person
{   
    private int Salary;
    private int ExperienceYears;
    
    Teacher(){}
    Teacher(int ID, String Name, String Address, String Number, ArrayList<Course> Courses, int Salary, int ExperienceYears)
    {
        super(ID, Name, Address, Number, Courses);
        setSalary(Salary);
        setExperienceYears(ExperienceYears);
    }
    
    
    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        if (Salary < 1000)
            Salary = 1000;
        this.Salary = Salary;
    }

    public int getExperienceYears() {
        return ExperienceYears;
    }

    public void setExperienceYears(int ExperienceYears) {
        if (ExperienceYears > 45)
            ExperienceYears = 2;
        this.ExperienceYears = ExperienceYears;
    }
    
    
//    
//    // Function to add teacher
//    public void AddTeacher(String TCH_IDText_ADD, String TCHNameText_ADD, String TCH_Salary_ADD, String TCH_CourseIDText_ADD, JTable TCH_DataTable)
//    {
//
//        try {
//            int count =  School.s.executeUpdate("insert into Teacher values ("+ TCH_IDText_ADD +",'"+TCHNameText_ADD+"','"+TCH_Salary_ADD+"',"+TCH_CourseIDText_ADD+")");
//            // The query that adds a teacher to the School database
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(new TeacherGUI(),"Error has occured, please make sure all the data entered is correct");
//        }
//        Table_Data_Filling(TCH_DataTable);  // Showing the table after modification
//    }
//
//    // Function to edit teacher grade
//    public void EditTeacher(String TCH_Salary_Edit_Text, String TCH_ID_Edit_Text, String TCH_CourseID_Edit_Text, JTable TCH_DataTable)
//    {
//        try {
//            int count =  School.s.executeUpdate("Update Teacher Set Salary = '"+TCH_Salary_Edit_Text+"' Where ID = "+ TCH_ID_Edit_Text +"AND CourseID = '"+TCH_CourseID_Edit_Text+"'");
//            // The query that edits a teacher's salary
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(new TeacherGUI(),"Error has occured, please make sure all the data entered is correct");
//        }
//        Table_Data_Filling(TCH_DataTable);  // Showing the table after modification
//    }
//
//    // Function to delete teacher
//    public void DeleteTeacher(String TCH_ID_Del_Text, String TCH_CourseID_Del_Text, JTable TCH_DataTable)
//    {
//        try {
//            int count =  School.s.executeUpdate("Delete From Teacher Where ID = "+ TCH_ID_Del_Text +"AND CourseID = '"+TCH_CourseID_Del_Text+"'");
//            // The query that deletes a teacher from the database
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(new TeacherGUI(),"Error has occured, please make sure all the data entered is correct");
//        }
//        Table_Data_Filling(TCH_DataTable);  // Showing the table after modification
//    }

}




