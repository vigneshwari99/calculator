package com.user;



public class user {
private int id;
private String name;
private String pass;
private String email;
/*private String addr;
private int  mob;*/
public boolean valid;
public boolean isValid() {
	return valid;
}
public void setValid(boolean valid) {
	this.valid = valid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
