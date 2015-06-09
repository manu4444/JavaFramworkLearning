package com.eclipseLink;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;


@Entity
public class FormModel {
  @Id @GeneratedValue
  private int id;
  private String name;
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
  public int getId() {
      return id;
  }
  public void setId(int id) {
      this.id = id;
  }
} 
