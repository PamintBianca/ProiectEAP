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

@WebServlet("/logincompany")
public class CompanyServlet extends HttpServlet{



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("companylogin.jsp").forward(request, response);
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
            CompanyRepository companyRepository= new CompanyRepository();
            List<Company> companies = companyRepository.findByEmailandPass(things.get("email"),things.get("password"));

            if (companies.size() == 0)
                request.setAttribute("loginError", "Email sau parola gresita!");
            else {
                request.setAttribute("email", companies.get(0).getEmail());
                request.setAttribute("nume", companies.get(0).getNume());
                request.setAttribute("parola", companies.get(0).getParola());
            }

            request.getRequestDispatcher("companylogin.jsp").forward(request, response);

        } catch (SQLException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }
}
