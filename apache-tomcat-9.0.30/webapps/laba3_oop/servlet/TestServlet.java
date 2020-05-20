package main.webapp.servlet;

import com.google.gson.Gson;
import main.webapp.data.DataBase;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
    private Gson json = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String carJson = json.toJson(DataBase.getInstance().getCars());
        System.out.println(DataBase.getInstance().getCars().toString());
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(carJson);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println();
       // System.out.println(req.getParameter("name"));
       // System.out.println(req.getParameter("model"));
    }
}
