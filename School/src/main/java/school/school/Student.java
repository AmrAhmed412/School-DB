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
public class Student extends Person
{
    int Age;
    int Fees;
    
    Student(){}
    Student (int ID, String Name, String Address, String Number, ArrayList<Course> Courses, int Age, int Fees)
    {
        super(ID, Name, Address, Number, Courses);
        setAge(Age);
        setFees(Fees);
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        if ((Age < 4 || Age > 20 )&& Age != -1)    // makes sure age is valid
            Age = 4;
        this.Age = Age;
        
            
    }

    public int getFees() {
        return Fees;
    }

    public void setFees(int Fees) {
        if (Fees < 1000 && Fees != -1)    // makes sure Fees is valid
            Fees = 1000;
        this.Fees = Fees;
    }

//    // Function to add student
//    public void AddStudent(String STD_IDText_ADD, String STDNameText_ADD, String STDGrade_ADD, String CourseIDText_ADD, JTable STD_DataTable)
//    {
//        try {
//            int count =  School.s.executeUpdate("insert into Student values ("+ STD_IDText_ADD +",'"+STDNameText_ADD+"','"+STDGrade_ADD +"',"+CourseIDText_ADD+")");
//            // The query that adds a student to the School database
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(new StudentGUI(),"Error has occured, please make sure all the data entered is correct");
//        }
//        Table_Data_Filling(STD_DataTable);  // Showing the table after modification
//    }
//
//    // Function to edit student grade
//    public void EditStudent(String STD_Grade_Edit_Text, String STD_ID_Edit_Text, String STD_CourseID_Edit_Text, JTable STD_DataTable)
//    {
//        try {
//            int count =  School.s.executeUpdate("Update Student Set Grade = '"+STD_Grade_Edit_Text+"' Where ID = "+ STD_ID_Edit_Text +"AND CourseID = '"+STD_CourseID_Edit_Text+"'");
//            // The query that edits a student's grade
//
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(new StudentGUI(),"Error has occured, please make sure all the data entered is correct");
//        }
//            Table_Data_Filling(STD_DataTable);  // Showing the table after modification
//    }
//
//    // Function to delete student
//    public void DeleteStudent(String STD_ID_Del_Text, String STD_CourseID_Del_Text, JTable STD_DataTable)
//    {
//        try {
//            int count =  School.s.executeUpdate("Delete From Student Where ID = "+ STD_ID_Del_Text +"AND CourseID = '"+STD_CourseID_Del_Text+"'");
//            // The query that deletes a student from the database
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(new StudentGUI(),"Error has occured, please make sure all the data entered is correct");
//        }
//            Table_Data_Filling(STD_DataTable);  // Showing the table after modification
//    }
}


