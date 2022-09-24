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
public class Person {
    private int ID;
    private String Name;
    private String Address;
    private String Number;
    private ArrayList<Course> Courses = new ArrayList<Course>();
    
    Person(){}
    Person (int ID, String Name, String Address, String Number, ArrayList<Course> Courses)
    {
        setID(ID);
        setName(Name);
        setAddress(Address);
        setNumber(Number);
        setCourses(Courses);
                
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        if(ID < 1)
            ID = 1;   // Then Database rejects it if its not unique
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        try
        {
            if (!Number.isEmpty())
                Integer.parseInt(Number);
            this.Number = Number;
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        
    }
    
    public ArrayList<Course> getCourses() {
        return Courses;
    }

    public void setCourses(ArrayList<Course> Courses) {
        this.Courses = Courses;
    }
    
    public void addCourse(Course Course)
    {
        Courses.add(Course);
    }
}

// Repo : add, edit, remove
// Services : dh elly byerboto bl courses