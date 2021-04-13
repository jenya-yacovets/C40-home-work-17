package by.tms.project.servlets;

import by.tms.project.exceptions.ParametersNotPassedException;
import by.tms.project.servises.Calculation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/operation")
public class Operation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String operation = req.getParameter("operation");
        String numbers = req.getParameter("numbers");

        try {
            double response = new Calculation(operation, numbers).response();
            resp.getWriter().format("Результат: %f", response);
        } catch (ParametersNotPassedException e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}
