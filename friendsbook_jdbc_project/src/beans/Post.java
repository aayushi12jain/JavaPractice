package beans;

import java.util.List;

public class Post {
	private String postId;
	private String text;
	private String hashtag;
	private String postDateTime;
	private String postPostedBy;
	private List<Comment> comments;
	
	public String getPostId() {
		return postId;
	}

	public Post(String text, String hashtag) {
		super();
		this.text = text;
		this.hashtag = hashtag;
		this.postDateTime = new DateAndTime().DateTime();
	}

	public Post(String text, String hashtag, String postDateTime) {
		super();
		this.text = text;
		this.hashtag = hashtag;
		this.postDateTime = postDateTime;
	}

	public Post(String postId, String text, String hashtag, String postDateTime, String postPostedBy) {
		super();
		this.postId = postId;
		this.text = text;
		this.hashtag = hashtag;
		this.postDateTime = postDateTime;
		this.postPostedBy = postPostedBy;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPostDateTime() {
		return postDateTime;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void addCommentToPost(Comment comment) {
		this.comments.add(comment);
	}

	public String getPostPostedBy() {
		return postPostedBy;
	}

	public void setPostPostedBy(String postPostedBy) {
		this.postPostedBy = postPostedBy;
	}
	
	


}
