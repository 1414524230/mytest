package com.dom.multiple.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "testFilter",urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    public void destroy() {
        /*销毁时调用*/
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*过滤方法 主要是对request和response进行一些处理，然后交给下一个过滤器或Servlet处理*/
        System.out.println("路过路过");
        chain.doFilter(req, resp);//交给下一个过滤器或servlet处理
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("来了");
        /*初始化方法  接收一个FilterConfig类型的参数 该参数是对Filter的一些配置*/

    }
}
