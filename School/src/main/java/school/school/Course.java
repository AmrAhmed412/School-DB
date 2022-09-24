/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package school.school;

/**
 *
 * @author User
 */
public class Course {
    private int ID;
    private String Name;
    
    Course(){}
    Course(int ID, String Name)
    {
        setID(ID);
        setName(Name);
    }
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        if(ID < 1)
            ID = 1;
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    
}
