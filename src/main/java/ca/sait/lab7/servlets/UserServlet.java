
package ca.sait.lab7.servlets;


import ca.sait.lab7.models.Role;
import ca.sait.lab7.models.User;
import ca.sait.lab7.services.UserService;
import ca.sait.lab7.services.RoleService;
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
 

    UserService us = new UserService();
    RoleService rs = new RoleService();
   
  String action = request.getParameter("action");

        

        if (action != null && action.equals("delete")) {
            try {
                String email = request.getParameter("email");
                boolean deleted = us.delete(email);

            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
 try {
 List<User> users = us.getAll();
 List<Role> roles = rs.getAll();

            
  request.setAttribute("users", users);
  request.setAttribute("roles", roles);
            
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
    RoleService rs = new RoleService();



   String action = request.getParameter("action");

             

   if(action != null && action.equals("add"))
            {   
                try {
    List<Role> roles = rs.getAll();
    String rolesName = "";  
    String email = request.getParameter("email");
    String firstName = request.getParameter("firtsName");
    String lastName = request.getParameter("lastName");
    String password = request.getParameter("password");
    String active = (request.getParameter("active") == null) ? "0" : "1";
    int role_id = Integer.parseInt(request.getParameter("role"));  
                    
                      
                    
                    for (Role role : roles) {
                        if (role_id == role.getId()){
                            rolesName = role.getName();                            
                        }    
                    }

                    Role role = new Role(role_id, rolesName); 

                 us.insert(email, Boolean.parseBoolean(active), firstName, lastName, password, role);
                } catch (Exception ex) {
               Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  else if(action != null && action.equals("edit"))
            {
       try {
    List<Role> roles = rs.getAll();
    String rolesName = "";  
    String email = request.getParameter("email");
    String firstName = request.getParameter("firtsName");
    String lastName = request.getParameter("lastName");
    String password = request.getParameter("password");
    String active = (request.getParameter("active") == null) ? "0" : "1";
    int role_id = Integer.parseInt(request.getParameter("role"));  
                    
                      
                    
                    for (Role role : roles) {
                        if (role_id == role.getId()){
                            rolesName = role.getName();                            
                        }    
                    }
                    Role role = new Role(role_id, rolesName); 

            us.update(email, Boolean.parseBoolean(active), firstName, lastName, password, role);

              } catch (Exception ex) {
           Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
         }
 else if(action != null && action.equals("delete"))
        {
    try {

    String email = request.getParameter("email");
  
         us.delete(email);
            } catch (Exception ex) {
          Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        try {
    List<User> users = us.getAll();
    List<Role> roles = rs.getAll();

    request.setAttribute("users", users);
    request.setAttribute("roles", roles);
       
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