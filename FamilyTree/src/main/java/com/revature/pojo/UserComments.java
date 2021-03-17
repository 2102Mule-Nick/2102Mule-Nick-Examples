package com.revature.pojo;

public class UserComments {

	private int userCommentsId;
	private String userCommentsValue;
	private int userStatusId;
	private int userId;

	public String getUserCommentsValue() {
		return userCommentsValue;
	}

	public void setUserCommentsValue(String userCommentsValue) {
		this.userCommentsValue = userCommentsValue;
	}

	public int getUserStatusId() {
		return userStatusId;
	}

	public void setUserStatusId(int userStatusId) {
		this.userStatusId = userStatusId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUsercommentsId() {
		return userCommentsId;
	}

	public UserComments(int usercommentsId, String userCommentsValue, int userStatusId, int userId) {
		super();
		this.userCommentsId = usercommentsId;
		this.userCommentsValue = userCommentsValue;
		this.userStatusId = userStatusId;
		this.userId = userId;
	}

}
