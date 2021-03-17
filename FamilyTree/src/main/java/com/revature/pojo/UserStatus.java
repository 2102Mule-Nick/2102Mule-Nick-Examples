package com.revature.pojo;

public class UserStatus {

	private int userStatusID;

	private String userStatusValue;

	private String userId;

	public int getUserStatusID() {
		return userStatusID;
	}

	public void setUserStatusID(int userStatusID) {
		this.userStatusID = userStatusID;
	}

	public String getUserStatusValue() {
		return userStatusValue;
	}

	public void setUserStatusValue(String userStatusValue) {
		this.userStatusValue = userStatusValue;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserStatus(int userStatusID, String userStatusValue, String userId) {
		super();
		this.userStatusID = userStatusID;
		this.userStatusValue = userStatusValue;
		this.userId = userId;
	}

}
