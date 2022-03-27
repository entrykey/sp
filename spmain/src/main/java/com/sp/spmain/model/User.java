package com.sp.spmain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(length = 50)
	private String username;

	private String password;
	
	@Column(length = 50)
	private String email;

	@Column(length = 10)
	private String phone;
	
	@Column(length = 1)
	private String gender;
	
	private Boolean enabled;

	private Boolean token;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Role> role;

	
}
