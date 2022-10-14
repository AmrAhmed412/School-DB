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
import school.school.web.repo.CourseRepo;
import school.school.web.repo.TeacherRepo;
import school.school.web.services.StudentCourseService;
import school.school.web.services.TeacherCourseService;

/**
 *
 * @author amr23
 */
@WebServlet(name = "CourseController", urlPatterns = {"/Course"})
public class CourseController extends HttpServlet {

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
            out.println("<title>Servlet CourseController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseController at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("ShowAllCourses") != null) {
            ShowTableCRS(out, "");
        } else if (request.getParameter("Delete") != null) {
            if (request.getParameter("CrsID_ShowAll").equals("")) {
                out.println("ID Field is empty");
            } else {
                String DeleteID = request.getParameter("CrsID_ShowAll");
                Course CRS = new Course();
                try {
                    CRS.setID(Integer.parseInt(DeleteID));
                    new CourseRepo().DeleteCourse(CRS);
                    ShowTableCRS(out, "");
                    // Deletes the student from the DB
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
            }
        } else if (request.getParameter("ShowAllTeachers") != null) {
            String str = "";
            if (!(request.getParameter("CrsID_ShowAll").equals(""))) {
                str = "Where Course.ID=" + request.getParameter("CrsID_ShowAll");
            }
            ShowTableTeachCRS(out, str);
        } else if (request.getParameter("ShowAllStudents") != null) {
            String str = "";
            if (!(request.getParameter("CrsID_ShowAll").equals(""))) {
                str = "Where Course.ID=" + request.getParameter("CrsID_ShowAll");
            }
            ShowTableStudCRS(out, str);
        } else {
            if (request.getParameter("CrsID").equals("")) {
                out.println("ID Field is empty");
            } else if (request.getParameter("CrsName").equals("")) {
                out.println("Name Field is empty");
            } else {

                String ID = request.getParameter("CrsID");
                String Name = request.getParameter("CrsName");

                try {
                    Course CRS = new Course(Integer.parseInt(ID), Name);
                    if (request.getParameter("Add") != null) {

                        new CourseRepo().AddCourse(CRS);
                        ShowTableCRS(out, "");
                    } else if (request.getParameter("Edit") != null) {
                        new CourseRepo().EditCourse(CRS);
                        ShowTableCRS(out, "");
                    }
                } catch (Exception e) {
                    out.println(e);
                }
            }
        }
    }

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
            out.println("<a href=\"http://localhost:8081/School-Web/Course.html \"><button>CourseGUI</button> </a> <br> </br>");

        } catch (SQLException ex) {
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println("</table>");
    }

    protected void ShowTableTeachCRS(PrintWriter out, String str) {
        ResultSet result = new TeacherCourseService().ShowTable(str);
        out.println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=100%>"
                + "<tr><th>TEACHER ID</th><th>COURSE ID</th><th>TEACHER NAME</th><th>COURSE NAME</th></tr>");

        try {
            while (result.next()) {
                out.println(
                        "<tr><td><center>" + result.getString(1) + "</center></td>"
                        + "<td><center>" + result.getString(2) + "</center></td>"
                        + "<td><center>" + result.getString(3) + "</center></td>"
                        + "<td><center>" + result.getString(4) + "</center></td>"
                        + "</tr>");

            }
            out.println("<a href=\"http://localhost:8081/School-Web/Course.html \"><button>CourseGUI</button> </a> <br> </br>");

        } catch (SQLException ex) {
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println("</table>");
    }

    protected void ShowTableCRS(PrintWriter out, String str) {
        ResultSet result = new CourseRepo().ShowTable(str);
        out.println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=100%>"
                + "<tr><th>COURSE ID</th><th>COURSE NAME</th></tr>");

        try {
            while (result.next()) {
                out.println("<tr><td><center>" + result.getString(1) + "</center></td>"
                        + "<td><center>" + result.getString(2) + "</center></td>"
                        + "</tr>");

            }
            out.println("<a href=\"http://localhost:8081/School-Web/Course.html \"><button>CourseGUI</button> </a> <br> </br>");

        } catch (SQLException ex) {
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
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
