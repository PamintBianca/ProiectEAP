package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("page1.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String line = request.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);

        if (line.split("=").length == 2)
            line = line.split("=")[1];
        else
            line = "";

        request.setAttribute("mesaj", line);

//        response.getWriter().println("Am primit mesajul tau!");
        request.getRequestDispatcher("page1.jsp").forward(request, response);
    }

}
