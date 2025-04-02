package servlets;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;



@WebFilter(urlPatterns = "/*")
public class CounterFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		
		Map<String, Integer> counters = (Map<String, Integer>) application.getAttribute("counters");
		
		if(counters == null) {
			counters = new HashMap<String, Integer>();
			application.setAttribute("counters", counters);
		}
		String url = request.getRequestURI();
		
		if(counters.containsKey(url)) {
			int count = counters.get(url);
			counters.put(url, ++count);
		}else {
			counters.put(url, 1);
		}
		
		System.out.println(counters);
		chain.doFilter(request, res);
		
		
		
	}


	
}
