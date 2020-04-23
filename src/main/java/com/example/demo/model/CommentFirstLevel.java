package com.example.demo.model;

import java.util.Date;
import java.util.List;

public class CommentFirstLevel {
	private String id;
	private String sayingId;
	private String commenter;
	private String avatar;
	private String commentContent;
	private Date commentTime;
	private CommentSaying commentSaying;
	private List<CommentSecondLevel> slcs;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSayingId() {
		return sayingId;
	}

	public void setSayingId(String sayingId) {
		this.sayingId = sayingId;
	}

	public String getCommenter() {
		return commenter;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public CommentSaying getCommentSaying() {
		return commentSaying;
	}

	public void setCommentSaying(CommentSaying commentSaying) {
		this.commentSaying = commentSaying;
	}

	public List<CommentSecondLevel> getSlcs() {
		return slcs;
	}

	public void setSlcs(List<CommentSecondLevel> slcs) {
		this.slcs = slcs;
	}

	@Override
	public String toString() {
		return "CommentFirstLevel{" +
				"id='" + id + '\'' +
				", sayingId='" + sayingId + '\'' +
				", commenter='" + commenter + '\'' +
				", avatar='" + avatar + '\'' +
				", commentContent='" + commentContent + '\'' +
				", commentTime=" + commentTime +
				", commentSaying=" + commentSaying +
				", slcs=" + slcs +
				'}';
	}
}
