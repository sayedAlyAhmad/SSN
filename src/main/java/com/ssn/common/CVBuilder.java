package com.ssn.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "cvbuilder")
public class CVBuilder   {
 	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "OBJECTIVES")
	private String objective;
	@Column(name = "SKILLS")
	private String skills;
	@Column(name = "EXPERIENCE")
	private String experience;
	@Column(name = "EDUCATION")
	private String education;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id",referencedColumnName = "ID",nullable=false)
 	private User user_id;
	 

	
	

}
