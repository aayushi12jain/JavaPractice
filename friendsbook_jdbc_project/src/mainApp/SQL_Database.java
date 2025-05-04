package mainApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Comment;
import beans.FriendsBookUser;
import beans.Notification;
import beans.Post;

public class SQL_Database implements DataStorage {

	final String url = "jdbc:sqlserver://localhost:1433;databaseName=friendsbook;encrypt=true;trustServerCertificate=true";
	final String user = "SA";
	final String password = "reallyStrongPwd123";

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	public void createUser(String name, String pswd, String gender, String school) {
		try {
			//connect to the db
			conn = DriverManager.getConnection(url, user, password);
			//create an obj for sql statement
			st = conn.createStatement();

			conn.setAutoCommit(false);
			//add new userProfile
			int t = st.executeUpdate("insert into userProfile values('" 
					+ name + "', '" 
					+ pswd + "', '" 
					+ gender + "', '" 
					+ school + "');");

			conn.commit();
			conn.setAutoCommit(true);
			System.out.println("Your user is created.");

		}catch(SQLException e ) {
			System.out.println("user Creation failed.");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public FriendsBookUser login(String name, String pass) {
		try
		{
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();
			rs = st.executeQuery("Select * from userProfile where username = '" + name + "'");

			if(rs.next())
			{
				if(pass.equals(rs.getString("password")))
				{
					return new FriendsBookUser(rs.getString(1));
				}
				else
				{
					return null;
				}
			}
			else
			{
				return null;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			try
			{
				conn.close();
				st.close();
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void createPost(FriendsBookUser fbUser, Post post) {
		try {
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();

			int i = st.executeUpdate("insert into post values ( '"
					+ post.getText() + "','"
					+ fbUser.getUserName() + "','"
					+ post.getPostDateTime() + "','"
					+ post.getHashtag() 
					+ "')");
			System.out.println("Your post is created.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			try
			{
				conn.close();
				st.close();
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

	@Override
	public ArrayList<String> getHashtags() {
		ArrayList<String> hashtags = new ArrayList<String>();
		try
		{

			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();
			rs = st.executeQuery("Select * from hashtag");

			if(rs!=null) {
				while(rs.next()) {
					hashtags.add(rs.getString("hashtag"));
				}
			}
			System.out.println("Hashtags in trends : " + hashtags.toString());
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			try
			{
				conn.close();
				st.close();
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return hashtags;
	}

	@Override
	public void updateHashtag(String data) {
		try {
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();

			int i = st.executeUpdate("update hashtag set appearanceCount = appearanceCount + 1 where hashtag='" + data + "'");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			try
			{
				conn.close();
				st.close();
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

	@Override
	public void insertHashtag(String data) {
		try {
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();

			int i = st.executeUpdate("insert into hashtag values('"+ data + "', 1)");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			try
			{
				conn.close();
				st.close();
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}


	}

	@Override
	public ArrayList<String> getFriendsList(String fbUser) {
		ArrayList<String> friends =  new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();
			rs = st.executeQuery("select * from friendRelationship where username1 = '" + fbUser + "' or username2 = '" + fbUser + "'");
			if(rs!=null) {
				while(rs.next()) {
					String fbUser1 = rs.getString("username1");
					String fbUser2 = rs.getString("username2");
					if(fbUser1.equals(fbUser)) {
						friends.add(fbUser2);
					}else {
						friends.add(fbUser1);
					}
				}
			}
		}catch(SQLException e) {
			System.out.println("user fetching failed.");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return friends;
	}

	@Override
	public FriendsBookUser displayFriendPosts(String friendsName) {
		FriendsBookUser fbUser =null;
		ArrayList<Post> posts =  new ArrayList<Post>();
		try {
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();
			rs = st.executeQuery("select * from post where username = '" + friendsName + "' order by postDateTime desc");
			if(rs!=null) {
				while(rs.next()) {
					Post p = new Post(rs.getString("content"),rs.getString("hashtag"),rs.getString("postDateTime"));
					posts.add(p);
				}
			}
			fbUser = getFriend(friendsName);
			fbUser.setPosts(posts);
		}catch(SQLException e) {
			System.out.println("user fetching failed.");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return fbUser;
	}

	@Override
	public FriendsBookUser getFriend(String friendsName) {
		FriendsBookUser fbUser = new FriendsBookUser(friendsName);
		try {
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();
			rs = st.executeQuery("select * from userProfile where username = '"+ friendsName +"'");
			if(rs.next()) {
				fbUser.setGender(rs.getString("gender"));
				fbUser.setSchool(rs.getString("school"));
			}
		}catch(SQLException e) {
			System.out.println("user fetching failed.");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return fbUser;
	}

	@Override
	public List<Post> getLatestPostsOnFeeds(String fbName) {
		ArrayList<Post> posts =  new ArrayList<Post>();
		try {
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();
			rs = st.executeQuery("select top 2 * from post " 
					+ "where username in (select username2 from friendRelationship where username1='"+fbName+"') "
					+ "or username in (select username1 from friendRelationship where username2='"+fbName+"') "
					+ "order by postDateTime desc");
			if(rs!=null) {
				while(rs.next()) {
					Post p = new Post(rs.getString("postId"),rs.getString("content"),rs.getString("hashtag"),rs.getString("postDateTime"), rs.getString("username"));
					List<Comment> comments = new ArrayList<Comment>();
					Statement st1 = conn.createStatement(); // new statement for inner query
					ResultSet rs1 =  st1.executeQuery("select * from comment where postId = '" + rs.getString("postId") + "'");
					if(rs1!=null) {
						while(rs1.next()) {
							Comment c = new Comment(rs1.getString("comment"),rs1.getString("commentDateTime"),rs1.getString("username"));
							comments.add(c);
						}
					}
					st1.close();
					p.setComments(comments);
					posts.add(p);
				}
			}
		}catch(SQLException e) {
			System.out.println("user fetching failed.");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return posts;
	}

	@Override
	public void postComment(Post p, Comment c, String username) {

		try {
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();

			int i = st.executeUpdate("insert into comment values('"
					+ c.getText() + "','"
					+ c.getCommentDateTime() + "','"
					+ username + "','"
					+ p.getPostId() + "')");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			try
			{
				conn.close();
				st.close();
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<String> seeAllOnFriendsBook(String fbName) {
		List<String> people = new ArrayList<String>();
		try {
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();
			rs = st.executeQuery("select username from userProfile"
					+ "where username not in (select username2 from friendRelationship where username1='"+fbName+"')"
					+ "and username not in (select username1 from friendRelationship where username2='"+fbName+"')"
					+ "and username != '"+fbName+"'");
			if(rs!=null) {
				while(rs.next()) {
					people.add(rs.getString("username"));
				}
			}
		}catch(SQLException e) {
			System.out.println("user fetching failed.");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return people;
	}

	@Override
	public void sendNotification(Notification n) {
		try {
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();
			int i = st.executeUpdate("insert into notification values('"
					+ n.getnType() + "','"
					+ n.getnMessage() + "','"
					+ n.getnDateTime() + "','"
					+ n.getnStatus() + "','"
					+ n.getnUsername()  + "')");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			try
			{
				conn.close();
				st.close();
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Notification> getNotifications(String userName) {
		List<Notification> notification = new ArrayList<Notification>();
		try {
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();
			rs = st.executeQuery("select * from notification where n_username = '" + userName + "' and n_status = 'New'");
			if(rs!=null) {
				while(rs.next()) {
					Notification n = new Notification(rs.getString("notificationId"), rs.getString("n_type"), rs.getString("content"),rs.getString("notificationDateTime"),rs.getString("n_status"),rs.getString("n_username"));
					notification.add(n);
				}
			}
		}catch(SQLException e) {
			System.out.println("user fetching failed.");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return notification;

	}

	@Override
	public void addFriend(String userName, String friendName) {
		try {
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();
			int i = st.executeUpdate("insert into friendRelationship values('"
					+ userName + "','" + friendName + "')");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			try
			{
				conn.close();
				st.close();
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}
	@Override
	public void updateNotificationStatus(List<String> notId) {
		try {
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();
			for(String s:notId) {
				int i = st.executeUpdate("update notification set n_status = 'Read' where notificationId='" + s + "'");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			try
			{
				conn.close();
				st.close();
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
