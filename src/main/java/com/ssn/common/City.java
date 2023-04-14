package com.ssn.common;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;
import lombok.ToString;

@Data // to generate setter, getter methods and constrcutor
@Entity
@Table(name = "city")
public class City implements Serializable {
	private static final long serialVersionUID = 3499692008229836514L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
//	@ToString.Exclude
//	@OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
//	@Fetch(FetchMode.)
//	private List<User> city;

}
