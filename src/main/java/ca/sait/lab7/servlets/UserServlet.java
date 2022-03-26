
package ca.sait.lab7.servlets;


import ca.sait.lab7.models.Role;
import ca.sait.lab7.models.User;
import ca.sait.lab7.services.UserService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 752808
 */

public class UserServlet extends HttpServlet {
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  UserService service = new UserService();


        String action = request.getParameter("action");

        if (action != null && action.equals("delete")) {
            try {
                String email = request.getParameter("email");
                boolean deleted = service.delete(email);

            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
 try {
 List<User> users = service.getAll();
            
 request.setAttribute("users", users);
            
 this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
   } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex); }
        
        
  }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
     UserService us = new UserService();
     Role roles= new Role();
     String action = request.getParameter("action");
    String email = request.getParameter("email");
    String firstName = request.getParameter("firtsName");
     String lastName = request.getParameter("lastName");
    String password = request.getParameter("password");
    String active = (request.getParameter("active") == null) ? "0" : "1";
    int role_id = Integer.parseInt(request.getParameter("role"));
              

   if(action != null && action.equals("add"))
            {   
                try {
                 us.insert(email, Boolean.parseBoolean(active), firstName, lastName, password, roles);
                } catch (Exception ex) {
               Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  else if(action != null && action.equals("edit"))
            {
       try {
            us.update(email, Boolean.parseBoolean(active), firstName, lastName, password, roles);
              } catch (Exception ex) {
           Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
         }
 else if(action != null && action.equals("delete"))
        {
    try {
         us.delete(email);
            } catch (Exception ex) {
          Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        try {
   List<User> users = us.getAll();
      request.setAttribute("user", users);
        } catch (Exception ex) {
   Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

}