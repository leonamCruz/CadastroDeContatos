package tech.leonam.microservico.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
/*
 * Você pode remover essa classe caso vá usar só com proxy reverso.
 * Com o proxy reverso o ip sempre será 127.0.0.1
 * */
public class IpFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) servletRequest;
        var ip = httpRequest.getRemoteAddr();

        System.out.println(ip);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}