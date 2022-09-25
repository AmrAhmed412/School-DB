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

// A student is a person
// Emulating the Student table in the DB
public class Student extends Person
{
    int Age;
    int Fees;
    
    Student(){}
    Student (int ID, String Name, String Address, String Number, ArrayList<Course> Courses, int Age, int Fees)
    {
        super(ID, Name, Address, Number, Courses);      // using person's constructor
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
}


