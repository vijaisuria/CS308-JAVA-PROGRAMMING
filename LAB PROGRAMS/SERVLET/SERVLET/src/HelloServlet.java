import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import main.WebServlet;

import java.io.PrintWriter;


public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            PrintWriter out = res.getWriter();
            int i = Integer.parseInt(req.getParameter("value1"));
            int j = Integer.parseInt(req.getParameter("value2"));
            int k=i+j;
            out.println("k=" + k);
            /* request dispatcher
            req.setAttribute("k" , k );

            RequestDispatcher rd=req.getRequestDispatcher("sq");
            rd.forward(req,res);*/

            //HttpSession
            /*HttpSession session= req.getSession();
            session.setAttribute("k", k);*/

            //cookies
            Cookie cookie=new Cookie("k" , k+"");
            res.addCookie(cookie);
            res.sendRedirect("sq");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
