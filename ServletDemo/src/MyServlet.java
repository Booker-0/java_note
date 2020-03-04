import javax.servlet.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet({"/MyServlet"})
public class MyServlet extends GenericServlet {
    public void init(ServletConfig servletConfig) throws ServletException{

    }
    public ServletConfig getServletConfig(){
        return null;
    }
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException,ServletException {
        servletResponse.getWriter().write("helloworld");
    }
    public String getServletInfo(){
        return null;
    }
    public void destory() {
    }
}
