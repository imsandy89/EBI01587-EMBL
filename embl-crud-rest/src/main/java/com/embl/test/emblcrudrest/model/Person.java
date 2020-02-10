package com.embl.test.emblcrudrest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	private Integer id;
	private String first_name;
	private String last_name;
	private Integer age;
	private String favourite_color;
	//private List<String> hobby;
	private String[] hobbies;

	public Person() {
	}

	public Person(Integer id, String fname, String lname, Integer age, String favColor, String[] hobbies) {
		this.id = id;
		this.first_name = fname;
		this.last_name = lname;
		this.age = age;
		this.favourite_color = favColor;
		this.hobbies = hobbies;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "first_name", nullable = false)
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	@Column(name = "last_name")
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Column(name = "age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "favourite_color")
	public String getFavourite_color() {
		return favourite_color;
	}

	public void setFavourite_color(String favourite_color) {
		this.favourite_color = favourite_color;
	}

	@Column(name = "hobby")
	public String[] getHobby() {
		return hobbies;
	}

	public void setHobby(String[] hobby) {
		this.hobbies = hobby;
	}

	/*@Override
	public String toString() {
		return this.getId()+", " + this.getFirst_name() + " " + this.getLast_name() + ", " + this.getAge() + ", "
				+ this.getFavourite_color() + ", " +this.getHobby();
	}*/
}
