package servlets;

import java.io.IOException;
import jakarta.servlet.*;

public class TimerFilter implements Filter{

	@Override
	public void doFilter(ServletRequest res, ServletResponse req, FilterChain chain)
			throws IOException, ServletException {

		long x = System.nanoTime();
		chain.doFilter(res, req);
		long diffx = System.nanoTime() - x;
		System.out.println("Time of diffx = "+diffx+" Nano sec. " + x);
	}



}
