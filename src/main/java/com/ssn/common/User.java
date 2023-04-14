package com.ssn.common;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data // to generate setter, getter methods and constrcutor
@Entity
@Table(name = "user")

public class User   {
 	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "USER_FIRST_NAME")
	private String fName;
	@Column(name = "USER_LAST_NAME")
	private String lName;
	@Column(name = "USER_EMAIL_OR_PHONE")
	private String emailOrPhone;
	@Column(name = "NEW_PASSWORD")
	private String nPass;
	@Column(name = "CONFIRM_PASSWORD")
	private String cPass;
	@Column(name = "USER_GENDER")
	private String gender;
//	@ToString.Exclude
//	@JoinColumn(name = "CITY_ID", referencedColumnName = "ID")
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	private City city;
	@OneToMany(mappedBy = "user_id",cascade = CascadeType.ALL)
		//	,cascade = CascadeType.ALL)
//	@ToString.Exclude
	//@JsonBackReference
//	@JsonManagedReference
 	private Set<CVBuilder> user_id;

}
