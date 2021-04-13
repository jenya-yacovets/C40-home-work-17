package by.tms.project.servlets;

import by.tms.project.servises.Calculation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/history")
public class History extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String result = new Calculation().history();

        if (result != "") {
            resp.getWriter().println(new Calculation().history());
        } else {
            resp.getWriter().println("Истории еще нет");
        }
    }
}
