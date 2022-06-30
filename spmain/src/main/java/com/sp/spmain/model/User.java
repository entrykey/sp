package com.sp.spmain.model;

import java.util.Collection;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @ToString @AllArgsConstructor
@JsonIgnoreProperties({ "password", "token" })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(length = 50)
	private String username;
	
	@Column(length = 50)
	private String name;

	private String password;
	
	@Column(length = 50)
	private String email;

	@Column(length = 10)
	private String phone;
	
	@Column(length = 1)
	private String gender;
	
	private Boolean enabled;

	private Boolean token;
	
	@JsonBackReference
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),    
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))

    private Collection <Role> roles;

}
