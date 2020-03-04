import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class FilterDemo implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException{
        System.out.println("我是过滤器Filter");
        chain.doFilter(req,resp);//执行这一句说明放行
    }
    public void init(FilterConfig config)throws ServletException{

    }
    public void destroy(){
    }
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
