package app14b;

import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;

import app14a.FirstServlet;

@HandlesTypes({ UsefulServlet.class })
public class ServletContainerlnitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx)
			throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("OnStartUp");
		Servlet userfulServlet = ctx.createServlet(FirstServlet.class);
		ServletRegistration registration = ctx.addServlet("userfulServlet",
				userfulServlet);
		registration.addMapping("/useful");
		System.out.println("finish");
	}
}
