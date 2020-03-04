package cn.ideal.web.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //获取资源请求路径
        String requestURI = request.getRequestURI();

        //排除包含登录确实所需要的资源，给予放行
        if (requestURI.contains("/login.jsp") || requestURI.contains("/loginServlet")) {
            System.out.println("test1");
            chain.doFilter(request,response);
        }else{
            System.out.println("test2");
            //不包含，即验证用户是否已经登录
            Object user = request.getSession().getAttribute("user");
            if (user != null){
                //登陆了，放行
                chain.doFilter(request,response);
            }else{
                //没有登录，跳转回登录页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }
}