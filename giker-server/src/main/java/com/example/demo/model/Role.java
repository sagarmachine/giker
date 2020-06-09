package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.jboss.logging.Logger;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="role")
public class Role implements GrantedAuthority {

	static Logger logg= Logger.getLogger(Role.class);
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="role_name")
	private String rolename;
	
	@ManyToMany(mappedBy ="roles", fetch = FetchType.EAGER)
//	@JoinTable(name="user_role",
//		    joinColumns=@JoinColumn(name = "role_id"),
//		    inverseJoinColumns=@JoinColumn(name="user_name"))
	private List<User> users;

	public Role() {
		
	}
	
	public Role(String role) {
		super();
		this.id = id;
		this.rolename = role;
	}

	@Override
	public String toString() {
		return "[role=" + rolename + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return rolename;
	}

	public void setRole(String role) {
		this.rolename = role;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		logg.info("I am Called ---------------------------------------------------------->"+rolename);
		return rolename ;
	}
	
	public void addUser(User user) {
		if(users==null)
			users= new ArrayList();
		users.add(user);
		
	}
	
	
}
