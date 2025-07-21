package mainApp;

import java.util.ArrayList;
import java.util.List;

import beans.Comment;
import beans.FriendsBookUser;
import beans.Notification;
import beans.Post;

public interface DataStorage {
	void createUser(String name, String pswd, String gender, String school);
	FriendsBookUser login(String name, String password);
	void createPost(FriendsBookUser user, Post post);
	ArrayList<String> getHashtags();
	void updateHashtag(String data);
	void insertHashtag(String data);
	ArrayList<String> getFriendsList(String string);
	FriendsBookUser displayFriendPosts(String friendsName);
	FriendsBookUser getFriend(String friendsName);
	List<Post> getLatestPostsOnFeeds(String friendsName);
	void postComment(Post p, Comment c, String u);
	List<String> seeAllOnFriendsBook(String friendsName);
	void sendNotification(Notification n);
	List<Notification> getNotifications(String userName);
	void addFriend(String userName, String friendName);
	void updateNotificationStatus(List<String> notId);

}
