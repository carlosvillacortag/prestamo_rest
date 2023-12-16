package cibertec.edu.pe.proyecto_prestamos_rest.config;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationEntryPointConfig extends BasicAuthenticationEntryPoint{
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException{
		
		response.addHeader("WWW-Authenticate","Basic Realm - " + getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		writer.println("HTTP status 401 - " + authException.getMessage()); 
	}
	
	@Override
	public void afterPropertiesSet(){
		setRealmName("almightyjava");
		super.afterPropertiesSet();;
	}
	
	
}
