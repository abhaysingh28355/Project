package com.railworld.AxisBank;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;

@Entity
public class Axis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Name;
	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "bid")
//	@OrderColumn(name ="type")
	private List<User> Branch;
	
	public Axis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public List<User> getBranch() {
		return Branch;
	}
	public void setBranch(List<User> branch) {
		Branch = branch;
	}
	
	
	
}
