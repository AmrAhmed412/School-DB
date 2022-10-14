/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package school.school.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import school.school.web.model.Course;
import school.school.web.model.School;
import school.school.web.model.Teacher;
import school.school.web.repo.TeacherRepo;
import school.school.web.services.TeacherCourseService;

/**
 *
 * @author amr23
 */
@WebServlet(name = "TeacherController", urlPatterns = {"/Teacher"})
public class TeacherController extends HttpServlet {

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
            out.println("<title>Servlet TeacherController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TeacherController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
        if (request.getParameter("ShowAllTeachers") != null) {
            ShowTableTeach(out, "");
        } else if (request.getParameter("Delete") != null) {
            if (request.getParameter("TeachID_Del").equals("")) {
                out.println("ID Field is empty");
            } else {
                String DeleteID = request.getParameter("TeachID_Del");
                Teacher TCH = new Teacher();
                try {
                    TCH.setID(Integer.parseInt(DeleteID));
                    new TeacherRepo().DeleteTeacher(TCH);
                    ShowTableTeach(out, "");
                    // Deletes the student from the DB
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
            }
        } else if (request.getParameter("ShowAllCourses") != null) {
            String str = "";
            if (!(request.getParameter("TeachID_Del").equals(""))) {
                str = "Where Teacher.ID=" + request.getParameter("TeachID_Del");
            }
            ShowTableTeachCRS(out, str);
        } else if (request.getParameter("Teach") != null) {
            if (request.getParameter("TeachID_Edit").equals("")) {
                out.println("Teacher ID Field is empty");
            } else if (request.getParameter("CrsID_Edit").equals("")) {
                out.println("Course ID Field is empty");
            } else {
                String TeachID = request.getParameter("TeachID_Edit");
                String CrsID = request.getParameter("CrsID_Edit");
                Teacher T = new Teacher();
                Course CRS = new Course();
                try {
                    T.setID(Integer.parseInt(TeachID));
                    CRS.setID(Integer.parseInt(CrsID));
                    new TeacherCourseService().Enroll(T, CRS);
                    ShowTableTeachCRS(out, "");
                    // Adds a course to the teacher
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
            }
        } else if (request.getParameter("Drop") != null) {
            if (request.getParameter("TeachID_Edit").equals("")) {
                out.println("Teacher ID Field is empty");
            } else if (request.getParameter("CrsID_Edit").equals("")) {
                out.println("Course ID Field is empty");
            } else {
                String TeachID = request.getParameter("TeachID_Edit");
                String CrsID = request.getParameter("CrsID_Edit");
                Teacher TCH = new Teacher();
                Course CRS = new Course();

                try {
                    TCH.setID(Integer.parseInt(TeachID));
                    CRS.setID(Integer.parseInt(CrsID));
                    new TeacherCourseService().Drop(TCH, CRS);
                    // Drops a course from the teacher

                    ShowTableTeachCRS(out, "");
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
            }
        } else {
            if (request.getParameter("TeachID").equals("")) {
                out.println("ID Field is empty");
            } else if (request.getParameter("TeachName").equals("") && request.getParameter("Add") != null) {
                out.println("Name Field is empty");
            } else {
                String Salary = request.getParameter("TeachSalary");
                String Ex = request.getParameter("TeachEx");
                if (request.getParameter("TeachSalary").equals("")) {
                    Salary = "-1";     // assigning a default value
                }
                if (request.getParameter("TeachEx").equals("")) {
                    Ex = "-1";    // assigning a default value
                }

                String ID = request.getParameter("TeachID");
                String Name = request.getParameter("TeachName");
                String Address = request.getParameter("TeachAddress");
                String Num = request.getParameter("TeachNum");

                try {
                    Teacher TCH = new Teacher(Integer.parseInt(ID), Name, Address, Num, null, Integer.parseInt(Salary), Integer.parseInt(Ex));
                    if (request.getParameter("Add") != null) {

                        new TeacherRepo().AddTeacher(TCH);
                        ShowTableTeach(out, "");
                    } else if (request.getParameter("Edit") != null) {
                        new TeacherRepo().EditTeacher(TCH);
                        ShowTableTeach(out, "");
                    }
                } catch (Exception e) {
                    out.println(e);
                }
            }
        }
    }

    protected void ShowTableTeachCRS(PrintWriter out, String str) {
        ResultSet result = new TeacherCourseService().ShowTable(str);
        out.println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=100%>"
                + "<tr><th>TEACHER ID</th><th>COURSE ID</th><th>TEACHER NAME</th><th>COURSE NAME</th></tr>");

        try {
            while (result.next()) {
                out.println("<tr><td><center>" + result.getString(1) + "</center></td>"
                        + "<td><center>" + result.getString(2) + "</center></td>"
                        + "<td><center>" + result.getString(3) + "</center></td>"
                        + "<td><center>" + result.getString(4) + "</center></td>"
                        + "</tr>");

            }
            out.println("<a href=\"http://localhost:8081/School-Web/Teacher.html \"><button>TeacherGUI</button> </a> <br> </br>");

        } catch (SQLException ex) {
            Logger.getLogger(TeacherController.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println("</table>");
    }

    protected void ShowTableTeach(PrintWriter out, String str) {
        ResultSet result = new TeacherRepo().ShowTable(str);
        out.println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=100%>"
                + "<tr><th>TEACHER ID</th><th>TEACHER NAME</th><th>ADDRESS</th><th>NUMBER</th><th>SALARY</th><th>EXPERIENCE YEARS</th></tr>");

        try {
            while (result.next()) {
                out.println("<tr><td><center>" + result.getString(1) + "</center></td>"
                        + "<td><center>" + result.getString(2) + "</center></td>"
                        + "<td><center>" + result.getString(3) + "</center></td>"
                        + "<td><center>" + result.getString(4) + "</center></td>"
                        + "<td><center>" + result.getString(5) + "</center></td>"
                        + "<td><center>" + result.getString(6) + "</center></td></tr>");

            }
            out.println("<a href=\"http://localhost:8081/School-Web/Teacher.html \"><button>TeacherGUI</button> </a> <br> </br>");

        } catch (SQLException ex) {
            Logger.getLogger(TeacherController.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println("</table>");
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

}
