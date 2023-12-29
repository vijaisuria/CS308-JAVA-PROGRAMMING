import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;

import java.io.PrintWriter;

public class addServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            PrintWriter out = res.getWriter();
            /* request dispatcher
            int k= (int)(req.getAttribute("k"));
            out.println("square of k=" + k+ "is " + (k*k));*/
            //HttpSession
            /*HttpSession session= req.getSession();
            int k= (int) session.getAttribute("k");*/

            //cookie
            int k=0;
            Cookie[] cookies=req.getCookies();
            for(Cookie c: cookies){
                if(c.getName().equals("k"))
                     k=Integer.parseInt(c.getValue());
            }
            out.println("square of k= " + k+ "  is " + (k*k));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}