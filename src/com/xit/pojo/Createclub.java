package com.xit.pojo;

public class Createclub {
	private Integer id;
	private User user;
	private String clubName;
	private String clubBrief;
	private Integer userId;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getClubBrief() {
		return clubBrief;
	}
	public void setClubBrief(String clubBrief) {
		this.clubBrief = clubBrief;
	}
	@Override
	public String toString() {
		return "Createclub [id=" + id + ", user=" + user + ", clubName=" + clubName + ", clubBrief=" + clubBrief + "]";
	}
	
	
}
