/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package school.school;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author amr23
 */
public class StudentGUI extends javax.swing.JFrame {

    /**
     * Creates new form StudentGUI
     */
    public Student S = new Student();    // initializing a variable to access student functions
    public StudentGUI() {
        initComponents();
        // Filling the table with all students
        S.Table_Data_Filling(STD_DataTable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CourseIDText_ADD = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        EditBtnSTD = new javax.swing.JButton();
        AddBtnSTD = new javax.swing.JButton();
        STDNameText_ADD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        STD_IDText_ADD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        STD_ID_Edit_Text = new javax.swing.JTextField();
        STD_CourseID_Edit_Text = new javax.swing.JTextField();
        STD_Grade_Edit_Text = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        STD_DataTable = new javax.swing.JTable();
        STD_ID_Del_Text = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        STD_CourseID_Del_Text = new javax.swing.JTextField();
        DelBtnSTD = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        STDGrade_ADD = new javax.swing.JTextField();
        STD_ShowAllCourses = new javax.swing.JButton();
        STDShowAllCoursesText = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        STD_ShowAllStudents = new javax.swing.JButton();

        setTitle("Student's Menu");

        CourseIDText_ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseIDText_ADDActionPerformed(evt);
            }
        });

        jLabel1.setText("Course");

        EditBtnSTD.setText("Edit");
        EditBtnSTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnSTDActionPerformed(evt);
            }
        });

        AddBtnSTD.setText("Add");
        AddBtnSTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnSTDActionPerformed(evt);
            }
        });

        STDNameText_ADD.setName(""); // NOI18N

        jLabel2.setText("Student Name:");

        jLabel3.setText("Student ID:");

        jLabel4.setText("Student ID:");

        jLabel5.setText("Course ID:");

        jLabel6.setText("New Grade");

        STD_DataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(STD_DataTable);

        jLabel8.setText("Student ID:");

        jLabel9.setText("Course ID:");

        DelBtnSTD.setText("Delete");
        DelBtnSTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelBtnSTDActionPerformed(evt);
            }
        });

        jLabel10.setText("Grade");

        STD_ShowAllCourses.setText("Show All Courses");
        STD_ShowAllCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STD_ShowAllCoursesActionPerformed(evt);
            }
        });

        jLabel11.setText("Student ID:");

        STD_ShowAllStudents.setText("Show All Students");
        STD_ShowAllStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STD_ShowAllStudentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3))
                                                    .addGap(32, 32, 32))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(STD_IDText_ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(STDNameText_ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CourseIDText_ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(STDGrade_ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)
                                        .addComponent(AddBtnSTD, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(130, 130, 130)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel5)
                                                        .addGap(20, 20, 20))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addGap(19, 19, 19))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(STDShowAllCoursesText, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(STD_ShowAllCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(STD_Grade_Edit_Text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(STD_CourseID_Edit_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(STD_ID_Edit_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(EditBtnSTD, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(13, 13, 13)
                        .addComponent(STD_ID_Del_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(STD_CourseID_Del_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DelBtnSTD, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(394, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(STD_ShowAllStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(STD_ID_Edit_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(STD_CourseID_Edit_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(EditBtnSTD))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(STD_Grade_Edit_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(STDNameText_ADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(STD_IDText_ADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(AddBtnSTD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CourseIDText_ADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(STDGrade_ADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(STDShowAllCoursesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(STD_ShowAllCourses)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(STD_ID_Del_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(STD_CourseID_Del_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelBtnSTD))
                .addGap(7, 7, 7)
                .addComponent(STD_ShowAllStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CourseIDText_ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseIDText_ADDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CourseIDText_ADDActionPerformed

    private void AddBtnSTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnSTDActionPerformed
        // Checking if there is an empty text box
        if (STDNameText_ADD.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Student Name Field is empty.");
        }
        else if (STD_IDText_ADD.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Student ID Field is empty.");
        }
        else if (CourseIDText_ADD.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Course ID Field is empty.");
        }
        else if (STDGrade_ADD.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Grade Field is empty.");
        }
        else S.AddStudent(STD_IDText_ADD.getText(), STDNameText_ADD.getText(), STDGrade_ADD.getText(), CourseIDText_ADD.getText(), STD_DataTable);
        // in case all fields have been filled, add the student
    }//GEN-LAST:event_AddBtnSTDActionPerformed

    private void STD_ShowAllCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STD_ShowAllCoursesActionPerformed
        // TODO add your handling code here:
        // Checking if there is an empty text box
        if (STDShowAllCoursesText.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Student ID Field is empty.");
        }
        else S.Table_Data_Filling(STD_DataTable," Where ID ="+STDShowAllCoursesText.getText()); // Filling the table with the student's courses
    }//GEN-LAST:event_STD_ShowAllCoursesActionPerformed

    private void DelBtnSTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelBtnSTDActionPerformed
        // Checking if there is an empty text box 
        if (STD_ID_Del_Text.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Student ID Field is empty.");
        }
        else if (STD_CourseID_Del_Text.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Course ID Field is empty.");
        }
        else S.DeleteStudent(STD_ID_Del_Text.getText(), STD_CourseID_Del_Text.getText(), STD_DataTable);
        // Deleting that student's course data
    }//GEN-LAST:event_DelBtnSTDActionPerformed

    private void EditBtnSTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnSTDActionPerformed
        // Checking if there is an empty text box
        if (STD_ID_Edit_Text.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Student ID Field is empty.");
        }
        else if (STD_CourseID_Edit_Text.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Course ID Field is empty.");
        }
        else if (STD_Grade_Edit_Text.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Grade Field is empty.");
        }
        else S.EditStudent(STD_Grade_Edit_Text.getText(), STD_ID_Edit_Text.getText(), STD_CourseID_Edit_Text.getText(), STD_DataTable);
        // Editing that student's course grade
    }//GEN-LAST:event_EditBtnSTDActionPerformed

    private void STD_ShowAllStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STD_ShowAllStudentsActionPerformed
        // TODO add your handling code here:
        // Filling the table with all students
        S.Table_Data_Filling(STD_DataTable);
    }//GEN-LAST:event_STD_ShowAllStudentsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Showing the Student data window
                new StudentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtnSTD;
    private javax.swing.JTextField CourseIDText_ADD;
    private javax.swing.JButton DelBtnSTD;
    private javax.swing.JButton EditBtnSTD;
    private javax.swing.JTextField STDGrade_ADD;
    private javax.swing.JTextField STDNameText_ADD;
    private javax.swing.JTextField STDShowAllCoursesText;
    private javax.swing.JTextField STD_CourseID_Del_Text;
    private javax.swing.JTextField STD_CourseID_Edit_Text;
    private javax.swing.JTable STD_DataTable;
    private javax.swing.JTextField STD_Grade_Edit_Text;
    private javax.swing.JTextField STD_IDText_ADD;
    private javax.swing.JTextField STD_ID_Del_Text;
    private javax.swing.JTextField STD_ID_Edit_Text;
    private javax.swing.JButton STD_ShowAllCourses;
    private javax.swing.JButton STD_ShowAllStudents;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

class Student extends TableFilling
{   
    Student(){};

    // Function to add student
    public void AddStudent(String STD_IDText_ADD, String STDNameText_ADD, String STDGrade_ADD, String CourseIDText_ADD, JTable STD_DataTable)
    {
        try {
            int count =  School.s.executeUpdate("insert into Student values ("+ STD_IDText_ADD +",'"+STDNameText_ADD+"','"+STDGrade_ADD +"',"+CourseIDText_ADD+")");
            // The query that adds a student to the School database
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new StudentGUI(),"Error has occured, please make sure all the data entered is correct");
        }
        Table_Data_Filling(STD_DataTable);  // Showing the table after modification
    }

    // Function to edit student grade
    public void EditStudent(String STD_Grade_Edit_Text, String STD_ID_Edit_Text, String STD_CourseID_Edit_Text, JTable STD_DataTable)
    {
        try {
            int count =  School.s.executeUpdate("Update Student Set Grade = '"+STD_Grade_Edit_Text+"' Where ID = "+ STD_ID_Edit_Text +"AND CourseID = '"+STD_CourseID_Edit_Text+"'");
            // The query that edits a student's grade

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new StudentGUI(),"Error has occured, please make sure all the data entered is correct");
        }
            Table_Data_Filling(STD_DataTable);  // Showing the table after modification
    }

    // Function to delete student
    public void DeleteStudent(String STD_ID_Del_Text, String STD_CourseID_Del_Text, JTable STD_DataTable)
    {
        try {
            int count =  School.s.executeUpdate("Delete From Student Where ID = "+ STD_ID_Del_Text +"AND CourseID = '"+STD_CourseID_Del_Text+"'");
            // The query that deletes a student from the database
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new StudentGUI(),"Error has occured, please make sure all the data entered is correct");
        }
            Table_Data_Filling(STD_DataTable);  // Showing the table after modification
    }
}

