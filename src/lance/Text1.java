package lance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet(name = "asdf",urlPatterns = "/h")
public class Text1 extends javax.servlet.http.HttpServlet {

    private String message = "";

    @Override
    public void init() throws ServletException {
        message = "hello world";

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {



        PrintWriter pw = response.getWriter();
        pw.println(message);

    }
}
