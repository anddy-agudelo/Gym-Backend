package com.back.gym.utils;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

// @Component
public class Autorizacion implements Filter{
    
    public static final String KEY="Molasslqpla";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
       
                HttpServletRequest httpServletRequest = (HttpServletRequest) request;
                String url = httpServletRequest.getRequestURI();  
                if(url.contains("/api/usuarios/login")||url.contains("/api/usuarios") || url.contains("index")|| url.contains(".js")|| url.contains(".css")|| url.contains(".ico")|| url.contains("assets")|| url.contains("#")){
                    chain.doFilter(request, response);
                }else{
                    String hash = httpServletRequest.getHeader("Authorization");
                    if(hash==null || hash.trim().equals("")){
                        response.setContentType("application/json");
                        String body= "{\"autorizacion \":\"Sin Autorizacion\"}";
                        response.getWriter().write(body);
                    }

                    try {
                        Jws<Claims> claims=Jwts.parser().setSigningKey(KEY).parseClaimsJws(hash);
                        if(url.contains("/api/ejercicios")||url.contains("/api/sedes")||url.contains("/api/suscripciones")){
                    chain.doFilter(request, response);
                        }
                    } catch (Exception e) {
                    }
                }
        
    }

}
