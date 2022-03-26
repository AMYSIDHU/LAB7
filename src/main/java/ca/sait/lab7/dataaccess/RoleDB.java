package ca.sait.lab7.dataaccess;


import ca.sait.lab7.models.Role;
import java.util.List;
import javax.persistence.EntityManager;


public class RoleDB {

    public Role get(int roleId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Role role = em.find(Role.class, roleId);
            return role;
        } finally {
            em.close();
        }
    }

    public List<Role> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Role> roles = em.createNamedQuery("Role.findAll", Role.class).getResultList();
            return roles;
        } finally {
            em.close();
        }
    }
}