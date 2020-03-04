import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet ("/HelloWorld")
public class HelloWorld extends HttpServlet {
    private String message;
    public void init() throws ServletException{
        message="Hello world,this message is from servlet!";
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<h1>" + message + "</h1>");
    }
        public void destory() {
            super.destroy();
        }

}
