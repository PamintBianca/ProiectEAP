package servlets;
import models.Company;
import models.User;
import repositories.CompanyRepository;
import repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/registercompany")
public class RegisterCompanyServlet extends HttpServlet{



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registercompany.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String line = request.getReader().readLine();
        line = URLDecoder.decode(line);
        System.out.println(line);
        String[] fields = line.split("&");
        String[] kv;

        HashMap<String, String> things = new HashMap<String, String>();


        for (int i = 0; i < fields.length; ++i)
        {
            kv = fields[i].split("=");
            if (2 == kv.length)
            {
                things.put(kv[0], kv[1]);
            }
        }

        try {
//            CompanyRepository userRepository = new UserRepository();
            Company c = new Company(things.get("email"),things.get("password"),things.get("nume"));
            CompanyRepository.save(c);
            if (c == null)
                request.setAttribute("loginError", "Eroare DB!");
            else
                request.setAttribute("succes", "Succes");

            request.getRequestDispatcher("registercompany.jsp").forward(request, response);

        } catch (SQLException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }
}
