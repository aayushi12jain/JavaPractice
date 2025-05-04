package beans;

public class Comment {
	
	private String text;
	private String commentDateTime;
	private String postedBy;
	
	
	public Comment(String text, String commentDateTime, String postedBy) {
		super();
		this.text = text;
		this.commentDateTime = commentDateTime;
		this.postedBy = postedBy;
	}
	
	public Comment(String text) {
		super();
		this.text = text;
		this.commentDateTime = new DateAndTime().DateTime();
	}
	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCommentDateTime() {
		return commentDateTime;
	}

	public void setCommentDateTime(String commentDateTime) {
		this.commentDateTime = commentDateTime;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	
	
	

}
