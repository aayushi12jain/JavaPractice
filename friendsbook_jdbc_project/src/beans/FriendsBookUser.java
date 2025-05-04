package beans;

import java.util.List;

public class FriendsBookUser {
	private String userName;
	private String gender;
	private String school;
	private List<Post> posts;

	public FriendsBookUser(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public void addPosttoUserProfile(Post posts) {
		this.posts.add(posts);
	}
	
	@Override
	public String toString() {
		return "FriendsBookUser [userName=" + userName + ", gender=" + gender + ", school=" + school + "]";
	}
	
	
	
}
