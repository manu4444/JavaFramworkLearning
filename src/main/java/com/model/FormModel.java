package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonProperty;


@Entity
@Table(name = "FORM")
public class FormModel {
  @Id @GeneratedValue
  private int id;
  
  @JsonProperty("name")
  private String name;
  
  @JsonProperty("password")
  private String password;
  
  public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public FormModel() {
  }

public FormModel(int id, String name, String password) {
	this.id = id;
	this.name = name;
	this.password = password;
}
  public int getId() {
      return id;
  }
  public void setId(int id) {
      this.id = id;
  }
} 
