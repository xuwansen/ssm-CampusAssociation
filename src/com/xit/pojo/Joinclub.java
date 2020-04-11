package com.xit.pojo;

public class Joinclub {
	private int id;
	private int clubId;
	private int userId;
	private String name;
	private String phone;
	private String grade;
	private String professional;
	private String joinclubid;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJoinclubid() {
		return joinclubid;
	}
	public void setJoinclubid(String joinclubid) {
		this.joinclubid = joinclubid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Joinclub [id=" + id + ", clubId=" + clubId + ", userId=" + userId + ", name=" + name + ", phone="
				+ phone + ", grade=" + grade + ", professional=" + professional + ", joinclubid=" + joinclubid + "]";
	}

}
