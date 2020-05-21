package servlets;

import models.Bike;
import models.User;
import repositories.BikesRepository;
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
@WebServlet("/companybikes")
public class BikesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bike> bikes= null;
        try {
            bikes = BikesRepository.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("bikes",bikes);
        request.getRequestDispatcher("bikes.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
            Bike b = new Bike();
            b.setIdcompany(Integer.parseInt(things.get("idcompany")));
            BikesRepository.save(b);



        } catch (SQLException  throwables) {
            throwables.printStackTrace();
        }

        List<Bike> bikes= null;
        try {
            bikes = BikesRepository.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("bikes",bikes);
        request.getRequestDispatcher("bikes.jsp").forward(request, response);
    }
}
