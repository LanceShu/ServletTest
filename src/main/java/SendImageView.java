import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class SendImageView {

    public static void main(String[] args) throws IOException {

        String urls = "http://192.168.56.1:8080/SimpleBox/ImageUrl";
        String result = doPost(urls);
        System.out.println(result);
    }

    private static String doPost(String urls) throws IOException {
        URL url = new URL(urls);
        URLConnection conn = url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);

        BufferedOutputStream bos = new BufferedOutputStream(
                conn.getOutputStream());

        InputStream is = new FileInputStream("E:/doubi.jpg");
        BufferedInputStream bis = new BufferedInputStream(is);

        byte[] bytes = new byte[1024];
        int length = 0;
        while((length = bis.read(bytes)) != -1){
            bos.write(bytes,0,length);
        }

        bis.close();
        is.close();
        bos.close();


        StringBuilder response = new StringBuilder();
        Scanner in = new Scanner(conn.getInputStream());
        while(in.hasNextLine()){
            response.append(in.nextLine());
            response.append("\n");
        }
        return response.toString();
    }


}
