package lance;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "ReciveImage",urlPatterns = "/ReciveImage")
public class ReciveImage extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter pw = response.getWriter();

        long id = System.currentTimeMillis();
        ServletInputStream sis = request.getInputStream();
        String imageUrl = "/picture/" + id + ".jpg";
        OutputStream os = new FileOutputStream("C:/apache-tomcat-8.5.23/webapps/unnamed" + imageUrl);
        BufferedOutputStream bos = new BufferedOutputStream(os);

        byte[] bytes = new byte[1024];
        int data = 0;
        while((data = sis.read(bytes)) != -1){
            bos.write(bytes,0,data);
        }
        sis.close();
        bos.close();
        os.close();

        File file = new File("C:/apache-tomcat-8.5.23/webapps/unnamed" + imageUrl);
        if(file.exists()){
            pw.println("receive!");
            pw.println("http://192.168.56.1:8080/unnamed" + imageUrl);
        }else{
            pw.println("failue!");
        }
    }
}
