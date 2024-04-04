package com.loginform.myapp;

import java.util.Date;
import java.util.Objects;

public class User {
	private String id;
	private String pwd;
	private String name;
	private Date birth;
	private String address;
	private Date reg_date;

	public User() {
	}

	public User(String id, String pwd, String name, Date birth) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birth = birth;
		this.reg_date = reg_date;
	}

	public User(String id, String pwd, String name, Date birth, String address, Date reg_date) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birth = birth;
		this.address = address;
		this.reg_date = reg_date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return id.equals(user.id) && Objects.equals(pwd, user.pwd) && Objects.equals(name, user.name)
				&& Objects.equals(birth, user.birth) && Objects.equals(address, user.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pwd, name, birth, address, reg_date);
	}

	@Override
	public String toString() {
		return "User{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                ", reg_date=" + reg_date +
                '}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
}
