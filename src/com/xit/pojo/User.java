package com.xit.pojo;

public class User {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String account;
	private String name;
	private String password;
	private Integer role_id;
	private String phone;
	private String role_name;
	private String grade;
	private String professional;
	private int clubId;
	public User() {
	}
	
	public User(String account, String name, String password, Integer role_id, String phone,
			String grade, String professional) {
		super();
		this.account = account;
		this.name = name;
		this.password = password;
		this.role_id = role_id;
		this.phone = phone;
		this.grade = grade;
		this.professional = professional;
	}

	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
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
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
