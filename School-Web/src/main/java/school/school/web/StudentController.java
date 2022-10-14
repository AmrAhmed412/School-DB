/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package school.school.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import school.school.web.model.*;
import school.school.web.repo.StudentRepo;
import school.school.web.model.School;
import school.school.web.services.StudentCourseService;

/**
 *
 * @author amr23
 */
@WebServlet(name = "StudentController", urlPatterns = {"/Student"})
public class StudentController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
//protected void service(HttpServletRequest request, HttpServletResponse response)
//
//    throws ServletException, IOException 
//{
//        PrintWriter out = response.getWriter();
//        out.println("amogus");
//}
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("amogus");

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        School sch = new School();
        sch.innit();
        if (request.getParameter("ShowAllStudents") != null) {
            ShowTableStud(out, "");
        } else if (request.getParameter("Delete") != null) {
            if (request.getParameter("StudID_Del").equals("")) {
                out.println("ID Field is empty");
            } else {
                String DeleteID = request.getParameter("StudID_Del");
                Student STD = new Student();
                try {
                    STD.setID(Integer.parseInt(DeleteID));
                    new StudentRepo().DeleteStudent(STD);
                    ShowTableStud(out, "");
                    // Deletes the student from the DB
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
            }
        } else if (request.getParameter("ShowAllCourses") != null) {
            String str = "";
            if (!(request.getParameter("StudID_Del").equals(""))) {
                str = "Where Student.ID=" + request.getParameter("StudID_Del");
            }
            ShowTableStudCRS(out, str);
        } else if (request.getParameter("Enroll") != null) {
            if (request.getParameter("StudID_Edit").equals("")) {
                out.println("Student ID Field is empty");
            } else if (request.getParameter("CrsID_Edit").equals("")) {
                out.println("Course ID Field is empty");
            } else {
                String StudID = request.getParameter("StudID_Edit");
                String CrsID = request.getParameter("CrsID_Edit");
                String Grade = request.getParameter("Grade");
                try {
                    StudentCourse STD_CRS = new StudentCourse(Integer.parseInt(StudID), Integer.parseInt(CrsID), Grade);
                    new StudentCourseService().Enroll(STD_CRS);
                    ShowTableStudCRS(out, "");
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
            }
        } else if (request.getParameter("EditGrade") != null) {
            if (request.getParameter("StudID_Edit").equals("")) {
                out.println("Student ID Field is empty");
            } else if (request.getParameter("CrsID_Edit").equals("")) {
                out.println("Course ID Field is empty");
            } else if (request.getParameter("Grade").equals("")) {
                out.println("Grade Field is empty");
            } else {
                String StudID = request.getParameter("StudID_Edit");
                String CrsID = request.getParameter("CrsID_Edit");
                String Grade = request.getParameter("Grade");
                try {
                    StudentCourse STD_CRS = new StudentCourse(Integer.parseInt(StudID), Integer.parseInt(CrsID), Grade);
                    new StudentCourseService().EditGrade(STD_CRS);
                    ShowTableStudCRS(out, "");
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
            }
        } else if (request.getParameter("Drop") != null) {
            if (request.getParameter("StudID_Drop").equals("")) {
                out.println("Student ID Field is empty");
            } else if (request.getParameter("CrsID_Drop").equals("")) {
                out.println("Course ID Field is empty");
            } else {
                String StudID = request.getParameter("StudID_Drop");
                String CrsID = request.getParameter("CrsID_Drop");
                Student STD = new Student();
                Course CRS = new Course();

                try {
                    STD.setID(Integer.parseInt(StudID));
                    CRS.setID(Integer.parseInt(CrsID));
                    new StudentCourseService().Drop(STD, CRS);
                    ShowTableStudCRS(out, "");
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
            }
        } else {
            if (request.getParameter("StudID").equals("")) {
                out.println("ID Field is empty");
            } else if (request.getParameter("StudName").equals("") && request.getParameter("Add") != null) {
                out.println("Name Field is empty");
            } else {
                String Age = request.getParameter("StudAge");
                String Fees = request.getParameter("StudFees");
                if (request.getParameter("StudAge").equals("")) {
                    Age = "-1";     // assigning a default value
                }
                if (request.getParameter("StudFees").equals("")) {
                    Fees = "-1";    // assigning a default value
                }

                String ID = request.getParameter("StudID");
                String Name = request.getParameter("StudName");
                String Address = request.getParameter("StudAddress");
                String Num = request.getParameter("StudNum");

                try {
                    Student stud = new Student(Integer.parseInt(ID), Name, Address, Num, null, Integer.parseInt(Age), Integer.parseInt(Fees));
                    if (request.getParameter("Add") != null) {

                        new StudentRepo().AddStudent(stud);
                        ShowTableStud(out, "");
                    } else if (request.getParameter("Edit") != null) {
                        new StudentRepo().EditStudent(stud);
                        ShowTableStud(out, "");
                    }
                } catch (Exception e) {
                    out.println(e);
                }
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    protected void ShowTableStudCRS(PrintWriter out, String str) {
        ResultSet result = new StudentCourseService().ShowTable(str);
        out.println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=100%>"
                + "<tr><th>STUDENT ID</th><th>COURSE ID</th><th>STUDENT NAME</th><th>COURSE NAME</th><th>GRADE</th></tr>");

        try {
            while (result.next()) {
                out.println("<tr><td><center>" + result.getString(1) + "</center></td>"
                        + "<td><center>" + result.getString(2) + "</center></td>"
                        + "<td><center>" + result.getString(3) + "</center></td>"
                        + "<td><center>" + result.getString(4) + "</center></td>"
                        + "<td><center>" + result.getString(5) + "</center></td></tr>");

            }
            out.println("<a href=\"http://localhost:8081/School-Web/Student.html \"><button>StudentGUI</button> </a> <br> </br>");

        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println("</table>");
    }

    protected void ShowTableStud(PrintWriter out, String str) {
        ResultSet result = new StudentRepo().ShowTable(str);
        out.println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=100%>"
                + "<tr><th>STUDENT ID</th><th>STUDENT NAME</th><th>ADDRESS</th><th>NUMBER</th><th>AGE</th><th>FEES</th></tr>");

        try {
            while (result.next()) {
                out.println("<tr><td><center>" + result.getString(1) + "</center></td>"
                        + "<td><center>" + result.getString(2) + "</center></td>"
                        + "<td><center>" + result.getString(3) + "</center></td>"
                        + "<td><center>" + result.getString(4) + "</center></td>"
                        + "<td><center>" + result.getString(5) + "</center></td>"
                        + "<td><center>" + result.getString(6) + "</center></td></tr>");

            }
            out.println("<a href=\"http://localhost:8081/School-Web/Student.html \"><button>StudentGUI</button> </a> <br> </br>");

        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println("</table>");
    }
}
