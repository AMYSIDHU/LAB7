
package ca.sait.lab7.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Represents a role
 * @author 752808 Amy Sidhu
 */

@Entity

@Table(name = "role")

@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
})

public class Role implements Serializable {

    @Id
    @Basic
    @Column(name = "role_Id")
    private int id;
    
    @Column(name ="role_name")
    private String name;
    
    @OneToMany
    private List <User> user;
    
    public Role() {

        
    }
    
    public Role(int id, String name) {
        this.id = id;

        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}