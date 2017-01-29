package dataTransferObject;

public class User {
private String UserName;
private String UserId;
public User(String UserId,String Username)
{
	this.UserId=UserId;
	this.UserName=Username;
}
public User(String uid)
{
    this.UserId=uid;
    this.UserName=null;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public String getUserId() {
	return UserId;
}
public void setUserId(String userId) {
	UserId = userId;
}

}
