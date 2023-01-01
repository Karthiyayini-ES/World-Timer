package Timer;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.tomcat.util.net.TLSClientHelloExtractor;
public class WorldTimer extends HttpServlet{
     public void service(ServletRequest req, ServletResponse res) throws IOException {
		try {
		res.setContentType("text/html");
		 PrintWriter pwriter=res.getWriter();
		String country = req.getParameter("SelectValues");
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.setTimeZone(TimeZone.getTimeZone(country));
		sdf.applyPattern("dd MMM yyyy HH:mm:ss z");
		RequestDispatcher obj =  req.getRequestDispatcher("/WorldTimer.html");
		obj.include(req, res);
		
        pwriter.println("<h2 id='result'>"+"Current Time: "+sdf.format(Calendar.getInstance().getTime())+"</h2>");
//		res.getWriter().print(sdf.format(Calendar.getInstance().getTime()));
		
		}
	    catch (Exception e) {
//	    	e.printStackTrace(); 
	    	System.out.println(e);
		}
			
		
	}



}



