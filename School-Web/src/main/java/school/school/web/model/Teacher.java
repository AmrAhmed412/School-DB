/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school.school.web.model;

import java.util.ArrayList;

public class Teacher extends Person
{   
    private int Salary;
    private int ExperienceYears;
    
    public Teacher(){}
    public Teacher(int ID, String Name, String Address, String Number, ArrayList<Course> Courses, int Salary, int ExperienceYears)
    { 
        super (ID,Name,Address,Number,Courses);
        //(ID, Name, Address, Number, Courses);      // using person's constructor
        setSalary(Salary);
        setExperienceYears(ExperienceYears);
    }
    
    
    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        if (Salary < 1000 && Salary != -1)
            Salary = 1000;
        this.Salary = Salary;
    }

    public int getExperienceYears() {
        return ExperienceYears;
    }

    public void setExperienceYears(int ExperienceYears) {
        if (ExperienceYears > 45 && ExperienceYears != -1)
            ExperienceYears = 2;
        this.ExperienceYears = ExperienceYears;
    }

    @Override
    public String toString() {
        return super.toString()+ "Salary=" + Salary + ", ExperienceYears=" + ExperienceYears ;
    }
    
}
