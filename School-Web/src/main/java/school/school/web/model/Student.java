/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school.school.web.model;

import java.util.ArrayList;

public class Student extends Person
{
    int Age;
    int Fees;
    
   public Student(){}
   public Student (int ID, String Name, String Address, String Number, ArrayList<Course> Courses, int Age, int Fees)
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
    @Override
    public String toString() {
        return super.toString()+ "Fees=" + Fees + ", Age=" + Age ;
    }
}
