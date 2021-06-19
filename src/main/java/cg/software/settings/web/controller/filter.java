package cg.software.settings.web.controller;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class filter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request=(HttpServletRequest) servletRequest;
        String uri=request.getRequestURI();
        HttpSession session=null;
        session=request.getSession();
        if(uri.indexOf("login")!=-1||"/crm/".equals(uri)){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        if(session == null){

        }
        //filterChain.doFilter(servletRequest,servletResponse);


    }
}
