package mainApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import beans.Comment;
import beans.FriendsBookUser;
import beans.Notification;
import beans.Post;

public class LoginWindow {


	private DataStorage data;
	private Scanner input = new Scanner(System.in);
	FriendsBookUser user = null;

	public LoginWindow(DataStorage d)
	{
		data = d;
	}

	public void login() {

		System.out.println("Please enter userId: ");
		String name = input.nextLine();
		System.out.println("Please enter password: ");
		String pswd = input.nextLine();

		user = data.login(name, pswd);
		if(user == null) {
			System.out.println("Login failed! Try Again!");
		}else {
			System.out.println("\nYou are successfully logged in. Welcome to your Account '"+ user.getUserName().toUpperCase() + "' \\^_^/ \n");

			int choice = -1;
			while(choice!=0)  
			{
				System.out.println("Please make your selection: ");
				System.out.println("1.	Select a post");
				System.out.println("2.	Check notifications");
				System.out.println("3.	Create a new post");
				System.out.println("4.	Friends");
				System.out.println("5.	Send a message");
				System.out.println("6.	Send a friend request");
				System.out.println("7.	See Hashtag in trends");
				System.out.println("0.	Logout");
				choice = input.nextInt();
				input.nextLine();
				System.out.println();
				switch(choice) {
				case 0:
					user = null;
					System.out.println("You are successfully logged out.");
					break;
				case 1:
					System.out.println("Select a post");
					commentOnPost();
					break;
				case 2:
					System.out.println("Check notifications");
					checkNotification(user);
					break;
				case 3:
					System.out.println("Create a new post");
					createPost(user);
					break;
				case 4:
					System.out.println("Friends");
					seeFriends(user);
					break;
				case 5:
					System.out.println("Send a message");
					sendMessage(user);
					break;
				case 6:
					System.out.println("Send a friend request");
					sendFriendRequest(user);
					break;
				case 7:
					System.out.println("See Hashtag in trends");
					data.getHashtags();
					break;
				default:
					System.out.println("Enter valid choice number.");
				}
			}
			System.out.println();
		}
	}


	private void checkNotification(FriendsBookUser user) {
		List<Notification> notifications = data.getNotifications(user.getUserName());
		List<String> notId = new ArrayList<>();
		System.out.println("Welcome to Notification Center! You have "+ notifications.size() +" notifications.");
		if(notifications.size()==0) {
			return;
		}
		System.out.println("Would you like to see them??(Y/N)");
		String choice = input.nextLine();
		int counter = 1;
		if(choice.equals("Y")) {
			for(Notification n : notifications) {
				if(n.getnUsername().equalsIgnoreCase(user.getUserName()) && n.getnStatus().equalsIgnoreCase("New")) {
					if(n.getnType().equalsIgnoreCase("Message")) {
						System.out.println("Message " + counter + ": " + n.getnMessage());
						counter++;
					}else {
						System.out.println(n.getnMessage());
						String wannaBeFriends = input.nextLine();
						if(wannaBeFriends.equalsIgnoreCase("Accept")) {
							String friendName = n.getnMessage().split(" ")[0];
							System.out.println(friendName);
							data.addFriend(user.getUserName(), friendName);
						}
					}
					notId.add(n.getNotificationId());
				}
			}
			data.updateNotificationStatus(notId);
		}

	}

	private void sendMessage(FriendsBookUser user) {

		ArrayList<String> friends = data.getFriendsList(user.getUserName());
		if(friends.size()>0) {
			System.out.println("Here is your friends List: " + friends.toString());
		}else {
			System.out.println("You have no friends :(");
			return;
		}

		System.out.println("Please enter the name whom you want to send the message : ");
		String requestName = input.nextLine();
		if(!friends.contains(requestName)) {
			System.out.println("The name you entered is not available on friends list. Please try again!");
			sendMessage(user);
			return;
		}

		System.out.println("Please enter the message : ");
		String message = input.nextLine();

		Notification n = new Notification("Message", message, "New", requestName);

		data.sendNotification(n);
	}

	private void sendFriendRequest(FriendsBookUser user) {

		List<String> people = data.seeAllOnFriendsBook(user.getUserName());
		System.out.println("People you may know: \n ");
		people.stream().forEach(x -> System.out.println("^-^ " + x));

		System.out.println("Please enter the name whom you want to send the friend request : ");
		String requestName = input.nextLine();
		if(!people.contains(requestName)) {
			System.out.println("The name you entered is not available on friendsbook. Please try again!");
			sendFriendRequest(user);
			return;
		}

		String message = user.getUserName() + " wants to be your friend (Accept/Deny).";
		Notification n = new Notification("Request", message, "New", requestName);

		data.sendNotification(n);

	}

	private void commentOnPost() {
		List<Post> posts = data.getLatestPostsOnFeeds(user.getUserName() );
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ \n");
		Post p1 = posts.get(0);
		System.out.println("Post 1: ");
		System.out.println("\\^_^/" + p1.getText() + "\\^_^/");
		System.out.println("#" + p1.getHashtag());
		System.out.println("Posted on : " + p1.getPostDateTime() + ", Posted By : " + p1.getPostPostedBy());
		System.out.println();
		List<Comment> comments1 = p1.getComments();
		if(comments1.size()>0) {
			for(Comment c:comments1) {
				System.out.println("\t * " + c.getText());
				System.out.println("\t \t -" + c.getCommentDateTime() + ", " + c.getPostedBy());
				System.out.println();
			}
		}
		Post p2 = posts.get(1);
		System.out.println("Post 2: ");
		System.out.println("\\^_^/" + p2.getText() + "\\^_^/");
		System.out.println("#" + p2.getHashtag());
		System.out.println("Posted on : " + p2.getPostDateTime() + ", Posted By : " + p2.getPostPostedBy());
		System.out.println();
		List<Comment> comments2 = p2.getComments();
		if(comments2.size()>0) {
			for(Comment c:comments2) {
				System.out.println("\t * " + c.getText());
				System.out.println("\t \t -" + c.getCommentDateTime() + ", " + c.getPostedBy());
				System.out.println();
			}
		}
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

		System.out.println("Do you want to make a comment?(Y/N)");
		String choice = input.nextLine();
		if(choice.equals("Y")) {
			System.out.println("Which post do you select?(1/2)");
			int i = input.nextInt();
			input.nextLine();
			System.out.println("Enter the comment : ");
			String comm = input.nextLine();
			if(comm.length()>20) {
				System.out.println("The comment lenght should not be more than 20 characters. Try again!");
			}else {
				Comment c = new Comment(comm);
				if(i==1) {
					data.postComment(p1, c, user.getUserName());
				}else if(i==2) {
					data.postComment(p2, c, user.getUserName());
				}else {
					System.out.println("Wrong choice. You are not allowed to make a comment anymore.");
				}
			}
		}
	}

	private void seeFriends(FriendsBookUser user) {
		ArrayList<String> friends = data.getFriendsList(user.getUserName());
		if(friends.size()>0) {
			System.out.println("Here is your friends List: " + friends.toString());
		}else {
			System.out.println("You have no friends :(");
			return;
		}
		System.out.println("\nWould you like to enter a friend's profile?(Y/N)");
		String choice = input.nextLine();
		if(choice.equals("Y")) {
			System.out.println("Enter the friend's name whose profile you want to see: ");
			String friendsName = input.nextLine();
			if(!friends.contains(friendsName)) {
				System.out.println("Wrong Name. Please try again!");
				seeFriends(user);
				return;
			}
			FriendsBookUser fbUser = data.displayFriendPosts(friendsName);
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("Welcome to "+ friendsName.toUpperCase() + "'s Profile.");
			System.out.println(friendsName + "'s Details : ");
			System.out.println("Gender : " + fbUser.getGender());
			System.out.println("School : " + fbUser.getSchool());
			if(fbUser.getPosts()!=null) {
				List<Post> posts = fbUser.getPosts();
				if(posts.size()>0) {
					Post p1 = posts.get(0);
					System.out.println("Posts: ");
					System.out.println("\\^_^/" + p1.getText() + "\\^_^/");
					System.out.println("#" + p1.getHashtag());
					System.out.println("Posted on : " + p1.getPostDateTime());
					if(posts.size()>1) {
						Post p2 = posts.get(1);
						System.out.println("\\^_^/" + p2.getText() + "\\^_^/");
						System.out.println("#" + p2.getHashtag());
						System.out.println("Posted on : " + p2.getPostDateTime());
					}
				}
			}
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		}
		System.out.println();

	}

	private void createPost(FriendsBookUser user) {


		System.out.println("Please enter the post content: ");
		String content = input.nextLine();
		ArrayList<String> hashtags = data.getHashtags();
		System.out.println("Mention the hashtags out the given list or create new hashtag: ");
		String hashtag = input.nextLine();

		if(hashtags.contains(hashtag)) {
			data.updateHashtag(hashtag);
		}else {
			data.insertHashtag(hashtag);
		}

		Post post = new Post(content, hashtag);

		data.createPost(user,post);

	}

}
